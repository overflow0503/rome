package com.weelfly.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.weelfly.manage.bean.domain.SystemConfig;
import com.weelfly.common.PagingRequest;

/**
 * <p>
 * 系统配置表服务类
 * </p>
 *
 */
public interface SystemConfigService extends IService<SystemConfig> {

    PageInfo listPage ( PagingRequest pagingRequest );




}
