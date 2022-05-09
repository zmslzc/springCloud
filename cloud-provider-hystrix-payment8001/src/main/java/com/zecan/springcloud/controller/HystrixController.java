package com.zecan.springcloud.controller;

import com.zecan.springcloud.service.HystrixServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName HystrixController
 * @Description TODO
 * @date 2022/5/6 9:06
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class HystrixController {

    @Resource
    HystrixServer server;


    @Value("${server.port}")    //spring的@Value注解
    private String ServerPort;

   @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = server.paymentInfo_OK(id);
        log.info("******result：" + result);
        return result;
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = server.paymentInfo_TimeOut(id);
        log.info("******result：" + result);
        return result;
    }

    // ===============服务熔断测试

    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = server.paymentCircuitBreaker(id);
        log.info("******result：" + result);
        return result;
    }

}
