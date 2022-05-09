package com.zecan.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName ConsulController
 * @Description TODO
 * @date 2022/5/5 11:48
 * @Version 1.0
 */

@RestController
@RequestMapping("/consul")
public class ConsulController {

    @Value(
            value = "${server.port}"
    )
    private String SERVER_PORT;

    @GetMapping("/payment_consul")
    public String paymentInfo() {
        return "springcloud with consul :" + SERVER_PORT + "\t" + UUID.randomUUID().toString();
    }
}
