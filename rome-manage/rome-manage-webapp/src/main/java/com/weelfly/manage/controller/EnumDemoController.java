package com.weelfly.manage.controller;

import com.weelfly.manage.bean.domain.PermissionResource;
import com.weelfly.manage.permission.Pass;
import com.weelfly.manage.service.PermissionResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 枚举映射
 */
@Pass
@RestController
@RequestMapping("enums")
public class EnumDemoController {

    @Resource
    private PermissionResourceService permissionResourceService;


    @GetMapping
    public ResponseEntity<List<PermissionResource>> list() {
        return ResponseEntity.ok().body(permissionResourceService.list());
    }


}
