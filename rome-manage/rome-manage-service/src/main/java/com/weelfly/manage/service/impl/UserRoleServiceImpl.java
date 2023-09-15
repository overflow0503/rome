package com.weelfly.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weelfly.common.PagingRequest;
import com.weelfly.manage.bean.domain.UserRole;
import com.weelfly.manage.mapper.UserRoleMapper;
import com.weelfly.manage.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 后台管理用户角色中间表 服务实现类
 * </p>
 *
 * @author shenshuangqing
 * @since 2017-06-19
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {


    @Override
    public PageInfo<UserRole> listPage(PagingRequest pagingRequest) {
        PageHelper.startPage(pagingRequest.getPageNumber(), pagingRequest.getPageSize());
        return new PageInfo<>(super.list());
    }

    @Override
    public List<UserRole> listByUserId(Long userId) {
        if (Objects.isNull(userId)) {
            return Collections.emptyList();
        }
        return super.list(new QueryWrapper<UserRole>().eq("user_id", userId));
    }


}
