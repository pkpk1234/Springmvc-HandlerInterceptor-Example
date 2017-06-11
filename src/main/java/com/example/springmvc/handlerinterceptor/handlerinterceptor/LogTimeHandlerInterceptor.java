package com.example.springmvc.handlerinterceptor.handlerinterceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by pkpk1234 on 2017/6/11.
 */

@Slf4j
public class LogTimeHandlerInterceptor extends HandlerInterceptorAdapter {

    ThreadLocal<Long> timeHolder = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        timeHolder.set(System.currentTimeMillis());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Long start = timeHolder.get();
        Long current = System.currentTimeMillis();
        log.info("request {} use time: {} mills.", request.getRequestURI(), (current - start) );
        timeHolder.remove();
        super.postHandle(request, response, handler, modelAndView);
    }
}
