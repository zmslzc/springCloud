package com.zecan.springcloud.service;

import com.zecan.springcloud.entity.CommonResult;
import com.zecan.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName OpenFeignServer
 * @Description TODO
 * @date 2022/5/5 17:50
 * @Version 1.0
 *  使用OpenFeign连接 生产端controller
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OpenFeignServer {

    @GetMapping("/payment/find/{id}")
    CommonResult<Payment> findPaymentById(@PathVariable("id") long id);


    @GetMapping("/payment/time")
     String timeOut();
}
