package com.devjones.obpc.controller;

import com.devjones.obpc.service.RedisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 홈 컨트롤러
 * 테스트용도
 */
@Controller
public class HomeController {

    RedisService redisService;

    public HomeController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/redis-test")
    public void test() {
        redisService.setValues("test1", "테스트밸류1");
        System.out.println("test1 : " + redisService.getValues("test1"));
    }
}
