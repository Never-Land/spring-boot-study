package com.spring.mvc.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器，实现方式普通的Bean实现HandlerInterceptor接口或继承HandlerInterceptorAdapter
 * 演示使用继承方式自定义拦截器
 */
public class DemoInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = Long.parseLong(String.valueOf(request.getAttribute("startTime")));
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long handleTime = endTime - startTime;
        System.out.println("本次请求处理消耗时间为:" + handleTime + "ms");
        request.setAttribute("handlerTime", handleTime);
    }
}
