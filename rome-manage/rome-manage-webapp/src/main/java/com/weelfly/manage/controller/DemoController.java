package com.weelfly.manage.controller;

import com.weelfly.common.ResponseEntityPro;
import com.weelfly.common.annotation.PassInjectionAttackIntercept;
import com.weelfly.common.util.DistributedCode;
import com.weelfly.manage.bean.domain.User;
import com.weelfly.manage.permission.Pass;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 *
 */
@Pass
@RestController
public class DemoController {


    @GetMapping("demo")
    public ResponseEntity demo() {
        return new ResponseEntityPro().add("id", DistributedCode.globalUniqueId())
                .add("password", "123456")
                .buildOk();
    }

    @GetMapping("demo2")
    public ResponseEntity demo2() {
        return ResponseEntityPro.badRequest(
                new User().setPassword("123456")
                        .setNickName("shenshuangqing")
                        .setPhone("18696666666")
                        .setRealName("渣渣辉")
                        .setLastPasswordResetDate(new Date())
                        .setRemark("地精风险投资公司")
                        .setEmail("yujunhao_8831@yahoo.com"),
                "-password"
        );
    }

    @GetMapping("injection")
    @PassInjectionAttackIntercept({"update", "delete"})
    public ResponseEntity<String> injection() {
        return ResponseEntityPro.ok(DistributedCode.globalUniqueId());
    }


}
