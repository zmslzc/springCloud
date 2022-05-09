package com.zecan.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//消费者支付模块配置类
@Configuration
public class OrderConfig {


    //配置各个模块之间连接的restTemplate
    @Bean
    @LoadBalanced //开启集群的负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}


