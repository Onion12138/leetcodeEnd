package com.ecnu.onion.leetcode.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author onion
 * @date 2019-08-16 -10:27
 */
@Component
@Slf4j
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String header = request.getHeader("token");
        if(header != null && header.length() !=0 ){
            return true;
        }else{
            log.info("未登录，被拦截器拦截");
            return false;
        }
    }
}
