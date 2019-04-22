package com.atagotech.qk.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Tom on 2019-04-22.
 * 一句话描述：会话状态拦截器 判断cookies是否超时
 */
public class SessionAuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("进入拦截器......RequestParamsInterceptor");
        System.out.println(httpServletRequest.getRequestURL());
        if (httpServletRequest.getRequestURL().toString().contains("/user/login")) {
            return true;
        }
        //httpServletRequest.getCookies()
        //判断cookie有效期

        return false;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }

}
