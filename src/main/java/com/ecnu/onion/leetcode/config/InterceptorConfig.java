package com.ecnu.onion.leetcode.config;

import com.ecnu.onion.leetcode.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author onion
 * @date 2019-08-16 -10:32
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Autowired
    private MyInterceptor interceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                .addPathPatterns("/answer/**");
    }
}
