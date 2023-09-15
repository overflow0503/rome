package com.weelfly.manage;

import com.weelfly.common.util.JsonUtils;
import com.weelfly.manage.bean.domain.User;
import com.weelfly.manage.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Test
    public void save() throws Exception {
        User user = new User();
        user.setEmail("overflow0503@sina.com")
                .setNickName("aatkropx")
                .setUsername("admin")
                .setEnabled(true)
                .setPassword(passwordEncoder.encode("admin"));
        userService.save(user);

    }

    @Test
    public void name() {
        final User admin = userService.findByUsername("admin");

        System.err.println(admin);

        JsonUtils.toJson(admin);

    }
}

















