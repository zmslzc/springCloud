package com.zecan.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName PaymentHystrixService
 * @Description TODO
 * @date 2022/5/6 10:44
 * @Version 1.0
 */

@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentHystrixServiceFallBackImpl.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
     String paymentInfo_OK(@PathVariable("id") Integer id);


    @GetMapping("/payment/hystrix/timeout/{id}")
     String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
