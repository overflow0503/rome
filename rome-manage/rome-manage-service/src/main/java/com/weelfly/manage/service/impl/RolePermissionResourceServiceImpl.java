package com.weelfly.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weelfly.common.PagingRequest;
import com.weelfly.manage.bean.domain.Role;
import com.weelfly.manage.bean.domain.RolePermissionResource;
import com.weelfly.manage.bean.domain.User;
import com.weelfly.manage.mapper.RolePermissionResourceMapper;
import com.weelfly.manage.service.RolePermissionResourceService;
import com.weelfly.manage.service.RoleService;
import com.weelfly.manage.service.UserService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台管理角色资源中间表 服务实现类
 * </p>
 */
@Service
public class RolePermissionResourceServiceImpl extends ServiceImpl<RolePermissionResourceMapper, RolePermissionResource> implements RolePermissionResourceService {

    @Resource
    private RoleService roleService;
    @Resource
    private UserService userService;

    @Override
    public PageInfo<RolePermissionResource> listPage(PagingRequest pagingRequest) {
        PageHelper.startPage(pagingRequest.getPageNumber(), pagingRequest.getPageSize());
        return new PageInfo<>(super.list());
    }

    @Override
    public List<RolePermissionResource> listByUserId(Long userId) {
        // 1. 得到用户
        final User user = userService.getById(userId);

        if (Objects.isNull(user)) {
            return Collections.emptyList();
        }
        // 2. 得到角色
        final List<Role> roles = roleService.listByUserId(user.getId());

        if (CollectionUtils.isEmpty(roles)) {
            return Collections.emptyList();
        }
        // 3. 得到角色资源中间表信息
        return super.list(
                new QueryWrapper<RolePermissionResource>().lambda().in(
                        RolePermissionResource::getRoleId,
                        roles.parallelStream().map(Role::getId).collect(Collectors.toList())
                )
        );
    }

}
