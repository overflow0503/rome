package com.weelfly.manage.permission;

import java.lang.annotation.*;

/**
 * 不需要权限,只需登录即可
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotNeedPermission {
}
