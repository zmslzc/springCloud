package com.zecan.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderController
 * @Description TODO
 * @date 2022/5/5 10:33
 * @Version 1.0
 */
@RestController
@RequestMapping("/zk_order")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    public static final String ZOOKEEPER_URL = "http://cloud-provider-payment";


    @GetMapping("/consumer_zk")
    public String paymentInfo() {
        return restTemplate.getForObject(ZOOKEEPER_URL + "/zookeeper_payment/zk",String.class);
    }
}
