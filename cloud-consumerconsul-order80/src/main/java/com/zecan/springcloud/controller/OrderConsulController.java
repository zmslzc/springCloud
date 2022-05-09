package com.zecan.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderConsulController
 * @Description TODO
 * @date 2022/5/5 14:45
 * @Version 1.0
 */
@RestController
@RequestMapping("/consumer")
public class OrderConsulController {
    @Resource

    private RestTemplate restTemplate;

    public static final String CONSUL_URL = "http://cloud-providerconsul-payment";


    @GetMapping("/payment_consul")
    public String paymentInfo() {
        return restTemplate.getForObject(CONSUL_URL + "/consul/payment_consul",String.class);
    }
}
