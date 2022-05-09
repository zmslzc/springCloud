package com.zecan.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName PaymentHystrixServiceFallBackImpl
 * @Description TODO
 * @date 2022/5/6 18:28
 * @Version 1.0
 */
@Service
public class PaymentHystrixServiceFallBackImpl implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService \t fallback-paymentInfo_OK----";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService \t fallback-paymentInfo_TimeOut----";
    }
}
