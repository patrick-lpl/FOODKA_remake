package com.swu.foodka.config;

import com.swu.foodka.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liuxiaolin
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/")
                .excludePathPatterns("/user/login"
                        ,"/user/register"
                        ,"/static/user/userLogin.html"
                        ,"/static/user/register.html"
                        ,"assets/css/*"
                        ,"assets/js/*");
    }
}
