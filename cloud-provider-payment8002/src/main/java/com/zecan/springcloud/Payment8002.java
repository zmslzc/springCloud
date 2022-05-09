package com.zecan.springcloud;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan(value = "com.zecan.springcloud.dao")
@EnableEurekaClient  //将当前类注册到服务注册中心去 在启动的时候自动添加
public class Payment8002 {
    public static void main(String[] args) {
        SpringApplication.run(Payment8002.class, args);
    }
}
