package com.zecan.springcloud.controller;

import com.zecan.springcloud.entity.CommonResult;
import com.zecan.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    //如果是集群模式,那么此时的用户访问的URL地址应该是注册中心中的key值可以直接访问到其中的地址
    private static final String ORDER_USER_URL = "http://CLOUD-PAYMENT-SERVICE";


    @Resource
    RestTemplate restTemplate;

    @GetMapping("/create")
    public CommonResult<Payment> createPayment(Payment payment) {
        return restTemplate.postForObject(ORDER_USER_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/find/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id) {
        return restTemplate.getForObject(ORDER_USER_URL+"/payment/find/" + id,CommonResult.class);
    }

    @GetMapping("/entity/{id}")
    public CommonResult<Payment> getPaymentEntity(@PathVariable("id") long id) {
        ResponseEntity<CommonResult> entity =
                restTemplate.getForEntity(ORDER_USER_URL + "/payment/find/" + id, CommonResult.class);
        log.info(entity.getStatusCode() + "\t" + entity.getStatusCodeValue());
        if(entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody(); // 获取其内部数据,
        }else {
            return new CommonResult<Payment>(444,"数据异常");
        }
    }
}
