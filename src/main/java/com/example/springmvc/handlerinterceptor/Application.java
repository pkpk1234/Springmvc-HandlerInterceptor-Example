package com.example.springmvc.handlerinterceptor;

import com.example.springmvc.handlerinterceptor.handlerinterceptor.LogCookieHandlerInterceptor;
import com.example.springmvc.handlerinterceptor.handlerinterceptor.LogTimeHandlerInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@Configuration
class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogTimeHandlerInterceptor());
        registry.addInterceptor(new LogCookieHandlerInterceptor());
        super.addInterceptors(registry);
    }
}
