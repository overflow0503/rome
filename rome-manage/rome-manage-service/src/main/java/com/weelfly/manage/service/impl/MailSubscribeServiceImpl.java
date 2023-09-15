package com.weelfly.manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weelfly.common.PagingRequest;
import com.weelfly.manage.bean.domain.MailSubscribe;
import com.weelfly.manage.mapper.MailSubscribeMapper;
import com.weelfly.manage.service.MailSubscribeService;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 邮件订阅 服务实现类
 * </p>
 *
 * @author shenshuangqing
 * @since 2017-08-07
 */
@Service
public class MailSubscribeServiceImpl extends ServiceImpl<MailSubscribeMapper, MailSubscribe> implements MailSubscribeService {

    @Override
    public PageInfo<MailSubscribe> listPage(PagingRequest pagingRequest) {
        PageHelper.startPage(pagingRequest.getPageNumber(), pagingRequest.getPageSize());
        return new PageInfo<>(super.list());
    }


}
