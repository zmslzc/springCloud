package com.zecan.spingcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName ZookeeperClientMain
 * @Description TODO
 * @date 2022/5/5 9:19
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperClientMain {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperClientMain.class,args);
    }

}
