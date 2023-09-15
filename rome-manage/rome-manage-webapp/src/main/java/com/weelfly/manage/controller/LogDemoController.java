package com.weelfly.manage.controller;

import com.github.pagehelper.PageInfo;
import com.weelfly.common.PagingRequest;
import com.weelfly.common.ResponseEntityPro;
import com.weelfly.common.annotation.Log;
import com.weelfly.manage.bean.domain.User;
import com.weelfly.manage.permission.Pass;
import com.weelfly.manage.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : shenshuangqing
 * @date : 2017/8/26
 */
@Pass
@RestController
@RequestMapping("log")
public class LogDemoController {

    @Resource
    private UserService userService;

    @Log
    @GetMapping("users")
    public ResponseEntity<List<User>> users() {
        return ResponseEntityPro.ok(userService.list());
    }

    @GetMapping("users-page")
    public ResponseEntity<PageInfo<User>> listPage(PagingRequest pagingRequest) {
        return ResponseEntityPro.ok(userService.listPage(pagingRequest));
    }


}
