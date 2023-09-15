package com.weelfly.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.weelfly.common.PagingRequest;
import com.weelfly.manage.bean.domain.MailSubscribe;

/**
 * <p>
 * 邮件订阅 服务类
 * </p>
 */
public interface MailSubscribeService extends IService<MailSubscribe> {


    PageInfo<MailSubscribe> listPage(PagingRequest pagingRequest);


}
