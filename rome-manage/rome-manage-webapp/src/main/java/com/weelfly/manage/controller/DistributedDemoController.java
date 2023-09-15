package com.weelfly.manage.controller;

import com.weelfly.manage.permission.Pass;
import com.weelfly.manage.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 分布式异步业务示例
 */
@Pass
@RestController
@RequestMapping("distributed")
public class DistributedDemoController {


    @Resource
    private UserService userService;

    /**
     * 支付
     */
    @GetMapping("pay")
    public ResponseEntity<String> pay() {
        // 支付处理
        userService.pay();
        return ResponseEntity.ok().body("支付成功");
    }


}
