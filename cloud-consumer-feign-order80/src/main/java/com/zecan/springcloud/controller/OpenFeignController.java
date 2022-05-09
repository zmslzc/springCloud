package com.zecan.springcloud.controller;

import com.zecan.springcloud.entity.CommonResult;
import com.zecan.springcloud.entity.Payment;
import com.zecan.springcloud.service.OpenFeignServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName OpenFeignController
 * @Description TODO
 * @date 2022/5/5 17:55
 * @Version 1.0
 */

@RestController
@RequestMapping("/openfeign")
public class OpenFeignController {

    @Resource
    private OpenFeignServer openFeignServer; //注入


    @GetMapping("/test/{id}")
   public CommonResult<Payment> findPaymentById(@PathVariable("id") long id) {
       return  openFeignServer.findPaymentById(id);
    }

    @GetMapping("/payment/time")
    public String timeOut(){
        return openFeignServer.timeOut();
    }
}
