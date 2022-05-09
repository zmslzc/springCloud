package com.zecan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName ConsulMain
 * @Description TODO
 * @date 2022/5/5 11:47
 * @Version 1.0
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsulMain.class,args);
    }
}
