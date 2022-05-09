package com.zecan.spingcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName ZookeeperController
 * @Description TODO
 * @date 2022/5/5 9:20
 * @Version 1.0
 */
@RestController
@RequestMapping("/zookeeper_payment")
public class ZookeeperController {

    @Value("${server.port}")
    private String SERVER_PORT;

    @GetMapping("/zk")
    public String paymentZk() {
        return "springcloud with zookeeper :" + SERVER_PORT + "\t" + UUID.randomUUID().toString();
    }


    @GetMapping
    public String payment(){
        return "111";
    }
}
