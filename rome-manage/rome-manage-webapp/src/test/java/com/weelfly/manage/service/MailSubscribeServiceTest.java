package com.weelfly.manage.service;

import com.github.pagehelper.PageInfo;
import com.weelfly.common.PagingRequest;
import com.weelfly.manage.bean.domain.MailSubscribe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailSubscribeServiceTest {

    @Resource
    private MailSubscribeService mailSubscribeService;

    @Test
    public void listPage() {
        final PageInfo<MailSubscribe> pageInfo = mailSubscribeService.listPage(new PagingRequest());
        System.err.println("pageInfo = " + pageInfo);
    }
}