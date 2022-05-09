package com.zecan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName OrderZkMain
 * @Description TODO
 * @date 2022/5/5 10:30
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain.class,args);
    }
}
