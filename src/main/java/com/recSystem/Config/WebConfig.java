package com.recSystem.Config;

import com.recSystem.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private UserServiceImpl userService;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor(userService))
                .addPathPatterns("/api/user/*")
                .excludePathPatterns("/api/user/register")
                .excludePathPatterns("/api/user/login")
                .excludePathPatterns("/api/user/validate_email")
                .excludePathPatterns("/api/user/validate_username");
    }
}
