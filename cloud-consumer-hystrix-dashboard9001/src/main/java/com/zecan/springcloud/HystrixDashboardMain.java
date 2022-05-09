package com.zecan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @ClassName HystrixDashboardMain
 * @Description TODO
 * @date 2022/5/7 8:18
 * @Version 1.0
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain {
    public static void main(String[] args) {

        SpringApplication.run(HystrixDashboardMain.class, args);
    }
}
