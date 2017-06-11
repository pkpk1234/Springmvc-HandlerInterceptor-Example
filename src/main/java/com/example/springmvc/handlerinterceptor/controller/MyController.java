package com.example.springmvc.handlerinterceptor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by pkpk1234 on 2017/6/11.
 */
@RestController
public class MyController {

    @GetMapping("/time")
    public ResponseEntity<String> currentTime() throws InterruptedException {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        Thread.sleep(((threadLocalRandom.nextInt(2) +1 )*1000) );
        Date date = new Date();
        return ResponseEntity.ok(date.toString());
    }
}
