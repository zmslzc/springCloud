package com.zecan.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName OpenFeignConfigure
 * @Description TODO
 * @date 2022/5/5 18:34
 * @Version 1.0
 */

@Configuration
public class OpenFeignConfigure {

    @Bean
    Logger.Level getLogger() {
        return Logger.Level.FULL;
    }
}
