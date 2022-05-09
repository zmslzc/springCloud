package com.zecan.springcloud;

import com.zecan.rule.config.IRuleConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient // 开启Eureka的服务注册
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = IRuleConfigure.class)
public class OrderConsumer {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumer.class);
    }
}
