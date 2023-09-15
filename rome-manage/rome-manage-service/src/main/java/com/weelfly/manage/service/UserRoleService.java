package com.weelfly.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.weelfly.common.PagingRequest;
import com.weelfly.manage.bean.domain.UserRole;

import java.util.List;

/**
 * <p>
 * 后台管理用户角色中间表 服务类
 * </p>
 *
 * @author shenshuangqing
 * @since 2017-06-19
 */
public interface UserRoleService extends IService<UserRole> {


    PageInfo listPage(PagingRequest pagingRequest);


    List<UserRole> listByUserId(Long userId);
}
