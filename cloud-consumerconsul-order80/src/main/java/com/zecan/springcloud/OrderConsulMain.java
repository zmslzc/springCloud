package com.zecan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName OrderConsulMain
 * @Description TODO
 * @date 2022/5/5 14:44
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain.class,args);
    }
}
