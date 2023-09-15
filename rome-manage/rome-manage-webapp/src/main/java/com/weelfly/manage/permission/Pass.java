package com.weelfly.manage.permission;

import java.lang.annotation.*;

/**
 * 放行
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Pass {
}
