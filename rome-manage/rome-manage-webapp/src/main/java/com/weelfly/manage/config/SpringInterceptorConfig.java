package com.weelfly.manage.config;

import com.weelfly.manage.permission.AdminPermissionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 */
@Configuration
public class SpringInterceptorConfig implements WebMvcConfigurer {

    @Bean
    public AdminPermissionInterceptor adminPermissionInterceptor() {
        return new AdminPermissionInterceptor();
    }

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminPermissionInterceptor()).addPathPatterns("/**");
    }


}
