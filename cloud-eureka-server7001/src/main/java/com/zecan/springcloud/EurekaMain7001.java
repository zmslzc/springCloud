package com.zecan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EurekaMain7001
 * @Description TODO
 * @date 2022/5/2 10:42
 * @Version 1.0
 */

@SpringBootApplication
@EnableEurekaServer // 开启服务注册中心
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class);
    }
}
