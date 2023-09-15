package com.weelfly.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.weelfly.common.PagingRequest;
import com.weelfly.manage.bean.domain.RolePermissionResource;

import java.util.List;

/**
 * <p>
 * 后台管理角色资源中间表 服务类
 * </p>
 */
public interface RolePermissionResourceService extends IService<RolePermissionResource> {

    PageInfo<RolePermissionResource> listPage(PagingRequest pagingRequest);

    List<RolePermissionResource> listByUserId(Long userId);


}
