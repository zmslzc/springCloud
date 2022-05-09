package com.zecan.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName HystrixServer
 * @Description TODO
 * @date 2022/5/6 9:05
 * @Version 1.0
 */
@Service
@DefaultProperties(defaultFallback = "fallback")
public class HystrixServer {


    //正常访问方法
    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "\tpaymentInfo_OK，id：" + id;
    }


    //超时访问方法
   /* @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })*/
    @HystrixCommand
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 5;
        try {
            TimeUnit.MILLISECONDS.sleep(timeNumber* 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() +
                "\tpaymentInfo_TimeOut，id：" + id + "，耗时：" + timeNumber + "秒";
    }
    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() +
                "\tpaymentInfo_TimeOut，id：" + id + "error";
    }

    public String fallback() {
        return "当前网络忙,请稍后再试";
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled" , value = "true") ,// 开启断路器
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//休眠时间窗口期（休眠多久进入半开模式（单位毫秒，默认5秒））
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求的总数阈值
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage" , value = "60") // 请求次数中的百分比到多少时跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0){
            throw  new RuntimeException("****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return  Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }


    // ============服务熔断

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数,请稍后再试， id: " + id;
    }

}
