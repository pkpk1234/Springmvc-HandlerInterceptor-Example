package com.example.springmvc.handlerinterceptor;

import com.example.springmvc.handlerinterceptor.handlerinterceptor.LogCookieHandlerInterceptor;
import com.example.springmvc.handlerinterceptor.handlerinterceptor.LogTimeHandlerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@Component
@Slf4j
class InitRunner implements CommandLineRunner {
    private final String initMsg;
    @Autowired
    public InitRunner(@Value("${init.message}") String initMsg) {
        this.initMsg = initMsg;
    }
    @Override
    public void run(String... strings) throws Exception {
        log.info(">>>>>>>>>>>> init message is {}",this.initMsg);
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
