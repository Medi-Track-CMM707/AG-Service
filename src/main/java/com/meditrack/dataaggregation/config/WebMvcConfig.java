package com.meditrack.dataaggregation.config;

import com.meditrack.dataaggregation.interceptor.HeaderInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final HeaderInterceptor headerInterceptor;

    public WebMvcConfig(HeaderInterceptor headerInterceptor) {
        this.headerInterceptor = headerInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Add your custom interceptor
        registry.addInterceptor(headerInterceptor);
    }
}
