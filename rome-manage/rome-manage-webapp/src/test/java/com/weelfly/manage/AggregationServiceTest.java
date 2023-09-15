package com.weelfly.manage;

import com.weelfly.manage.bean.domain.User;
import com.weelfly.manage.service.AggregationService;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AggregationServiceTest {

    @Resource
    private AggregationService aggregationService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Test
    public void saveUser() throws Exception {
        User user = new User();
        final String username = "admin" + RandomStringUtils.randomNumeric(3);
        user.setEmail("overflow0503@sina.co,")
                .setNickName("aatkropx")
                .setUsername(username)
                .setEnabled(true)
                .setPassword(passwordEncoder.encode("123456"));
        aggregationService.saveUser(user);

        System.err.println("username = " + username);

    }

    @Test
    public void intoUser() throws Exception {
        User user = new User();
        final String username = "admin" + RandomStringUtils.randomNumeric(3);
        user.setEmail("overflow0503@sina.co,")
                .setNickName("aatkropx")
                .setUsername(username)
                .setEnabled(true)
                .setPassword(passwordEncoder.encode("123456"));
        aggregationService.intoUser(user);

        System.err.println("username = " + username);

    }
}

















