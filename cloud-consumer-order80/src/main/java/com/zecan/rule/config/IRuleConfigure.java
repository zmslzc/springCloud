package com.zecan.rule.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName IRuleConfigure
 * @Description TODO
 * @date 2022/5/5 16:30
 * @Version 1.0
 */

@Configuration
public class IRuleConfigure {

    @Bean
    public IRule myRule(){
        return new RandomRule();    //负载均衡机制改为随机
    }
}
