package com.example.springmvc.handlerinterceptor.handlerinterceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * Created by pkpk1234 on 2017/6/11.
 */
@Slf4j
public class LogCookieHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Arrays.stream(request.getCookies())
                .forEach(cookie -> log.info("cookie = {} : {}", cookie.getName(), cookie.getValue()));
        return super.preHandle(request, response, handler);
    }

}
