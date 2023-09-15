package com.weelfly.manage.service;

import com.weelfly.manage.bean.domain.Role;
import com.weelfly.manage.bean.domain.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台管理角色表 服务类
 * </p>
 *
 * @author shenshuangqing
 * @since 2017-06-19
 */
public interface RoleService extends IService< Role > {


    List< Role > listByUserId ( Long userId );

    boolean save ( Long userId , Long roleId );

    List< Role > listByUserRole ( List< UserRole > userRoles );

    boolean deleteRelatedById ( Long id );

	Role getByRoleNameCode ( String roleCode );

}
