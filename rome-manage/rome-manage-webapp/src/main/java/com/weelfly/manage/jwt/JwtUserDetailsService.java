package com.weelfly.manage.jwt;

import com.weelfly.manage.GlobalCacheConstant;
import com.weelfly.manage.bean.domain.Role;
import com.weelfly.manage.bean.domain.RolePermissionResource;
import com.weelfly.manage.bean.domain.User;
import com.weelfly.manage.bean.vo.PermissionResourceVO;
import com.weelfly.manage.service.PermissionResourceService;
import com.weelfly.manage.service.RolePermissionResourceService;
import com.weelfly.manage.service.RoleService;
import com.weelfly.manage.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author shenshuangqing
 */
@Service("userDetailsService")
@CacheConfig(cacheNames = GlobalCacheConstant.USER_DETAILS_SERVICE_NAMESPACE)
public class JwtUserDetailsService implements UserDetailsService {

    @Lazy
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private PermissionResourceService permissionResourceService;
    @Resource
    private RolePermissionResourceService rolePermissionResourceService;


    @Cacheable(key = "#username", condition = "#username != null")
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isBlank(username)) {
            throw new UsernameNotFoundException(String.format("该'%s'用户名不存在.", username));
        }
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("该'%s'用户名不存在.", username));
        }
        // 虽然说可以对SuperAdmin和Root直接放行,但在程序上还是应该让他们有归属,该有的角色和权限信息还是得有
        List<Role> roles = roleService.listByUserId(user.getId());
        final List<RolePermissionResource> rolePermissionResources = rolePermissionResourceService.listByUserId(user.getId());
        final List<PermissionResourceVO> permissionResource = permissionResourceService.listUserPermissionByRolePermissionResource(
                rolePermissionResources);
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getNickName(),
                user.getRealName(),
                user.getEmail(),
                user.getPhone(),
                user.getUserImageUrl(),
                user.getLastPasswordResetDate(),
                user.getCreateUserId(),
                user.getCreateTime(),
                user.getUpdateTime(),
                user.getRemark(),
                user.getEnabled(),
                roles,
                permissionResource,
                rolePermissionResources
        );
    }


}










