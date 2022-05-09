package com.zecan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName OrderFeignMain
 * @Description TODO
 * @date 2022/5/5 17:44
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients //开启OpenFeign
public class OrderFeignMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain.class,args);
    }
}
