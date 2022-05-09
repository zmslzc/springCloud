package com.zecan.springcloud.controller;

import com.zecan.springcloud.entity.CommonResult;
import com.zecan.springcloud.entity.Payment;
import com.zecan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
   private  PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;
    @PostMapping("/create")
    public CommonResult<Integer> createPayment(@RequestBody Payment payment) {
        Integer data = paymentService.createPayment(payment);
        if (data > 0) {
            log.info("订单插入成功" + 2);
            return new CommonResult<>(200, "订单插入成功" + "端口号" + serverPort, data);

        } else {
            log.info("订单创建时发生异常");
            return new CommonResult<>(444, "订单插入失败", null);
        }
    }

    @GetMapping("/find/{id}")
    public CommonResult<Payment> findPaymentById(@PathVariable("id") long id) {
        Payment data = paymentService.findPaymentById(id);
        if (data != null) {
            log.info("订单查询成功");
            return new CommonResult<>(200, "订单查询成功" + "端口号" + serverPort, data);

        } else {
            log.info("订单创建时发生异常");
            return new CommonResult<>(444, "订单查询失败", null);
        }
    }

    @GetMapping("/discovery")
    public Object getDiscovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("服务端名:" + service);
        }
        //获取在服务注册中心中的实例 => 传入的参数是服务器名 (key)
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getInstanceId() + " "
                    + instance.getHost() + " "
                    + instance.getPort() + " "
                    + instance.getUri() + "\t");
        }
        return this.discoveryClient;
    }

    @GetMapping("/time")
    public String timeOut() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
