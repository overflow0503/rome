package com.weelfly.manage.service.impl;

import com.weelfly.common.util.AssertUtils;
import com.weelfly.manage.bean.domain.User;
import com.weelfly.manage.service.AggregationService;
import com.weelfly.manage.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AggregationServiceImpl implements AggregationService {

    @Resource
    private UserService userService;


    @Override
    public void saveUser(User user) {
        userService.save(user);
        AssertUtils.assertError("测试事务是否回滚(可传播),请查看数据库.");
    }

    @Override
    public void intoUser(User user) {
        userService.save(user);
        AssertUtils.assertError("测试事务是否回滚(可传播),请查看数据库.");
    }
}
