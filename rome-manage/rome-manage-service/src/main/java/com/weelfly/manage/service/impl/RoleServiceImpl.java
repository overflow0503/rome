package com.weelfly.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weelfly.common.util.AssertUtils;
import com.weelfly.manage.bean.domain.Role;
import com.weelfly.manage.bean.domain.RolePermissionResource;
import com.weelfly.manage.bean.domain.UserRole;
import com.weelfly.manage.mapper.RoleMapper;
import com.weelfly.manage.service.RolePermissionResourceService;
import com.weelfly.manage.service.RoleService;
import com.weelfly.manage.service.UserRoleService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台管理角色表 服务实现类
 * </p>
 *
 * @author shenshuangqing
 * @since 2017-06-19
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {


    @Resource
    private UserRoleService userRoleService;
    @Resource
    private RolePermissionResourceService rolePermissionResourceService;


    @Override
    public List<Role> listByUserId(Long userId) {

        final List<Object> roleIds = userRoleService.listObjs(new QueryWrapper<UserRole>().eq("user_id", userId)
                .select("role_id"));

        if (CollectionUtils.isEmpty(roleIds)) {
            return null;
        }
        return new ArrayList<>(super.listByIds(roleIds.parallelStream()
                .map(Object::toString)
                .collect(Collectors.toList())));
    }


    @Override
    public boolean save(Long userId, Long roleId) {
        if (Objects.isNull(userId)) {
            return false;
        }
        final Role role = super.getById(roleId);
        AssertUtils.isTrue(Objects.isNull(role), "角色不存在");
        UserRole userRole = new UserRole();
        userRole.setUserId(userId)
                .setRoleId(roleId);
        return userRoleService.save(userRole);
    }

    @Override
    public List<Role> listByUserRole(List<UserRole> userRoles) {
        if (CollectionUtils.isEmpty(userRoles)) {
            return Collections.emptyList();
        }
        final List<Long> roleIds = userRoles.parallelStream()
                .map(UserRole::getRoleId)
                .collect(Collectors.toList());
        return new ArrayList<>(super.listByIds(roleIds));
    }

    @Override
    public boolean deleteRelatedById(Long id) {
        AssertUtils.isTrue(!super.removeById(id), "角色删除失败");
        AssertUtils.isTrue(!rolePermissionResourceService.remove(new QueryWrapper<RolePermissionResource>().eq(
                "role_id",
                id)), "角色删除失败");
        return true;
    }

    @Override
    public Role getByRoleNameCode(String roleCode) {
        return super.getOne(new QueryWrapper<Role>().eq("role_name_code", roleCode));
    }


}












