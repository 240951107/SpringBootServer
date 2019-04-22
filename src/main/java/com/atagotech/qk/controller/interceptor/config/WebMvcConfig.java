package com.atagotech.qk.controller.interceptor.config;

import com.atagotech.qk.controller.interceptor.LogInterceptor;
import com.atagotech.qk.controller.interceptor.RequestParamsInterceptor;
import com.atagotech.qk.controller.interceptor.SessionAuthenticationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Tom on 2019-04-22.
 * 一句话描述：
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor());
        registry.addInterceptor(new SessionAuthenticationInterceptor());
        registry.addInterceptor(new RequestParamsInterceptor());
    }
}
