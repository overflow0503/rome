package com.weelfly.security.config;

import com.weelfly.security.websocket.JwtWebSocketInterceptorAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.support.ChannelInterceptor;

/**
 * @author : shenshuangqing
 */
@Configuration
public class SpringWebSocketSecurityConfig {

    @Bean
    public ChannelInterceptor channelInterceptor() {
        return new JwtWebSocketInterceptorAdapter();
    }
}
