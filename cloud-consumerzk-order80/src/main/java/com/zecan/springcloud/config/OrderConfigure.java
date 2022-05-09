package com.zecan.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName OrderConfigure
 * @Description TODO
 * @date 2022/5/5 10:32
 * @Version 1.0
 */
@Configuration
public class OrderConfigure {


    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
