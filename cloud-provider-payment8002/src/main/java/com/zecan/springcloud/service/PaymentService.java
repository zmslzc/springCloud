package com.zecan.springcloud.service;

import com.zecan.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    /**
     * @Description: 创建支付
     * @Param:
     * @return:
     * @Author: 泽灿
     * @Date: 2022/4/30
     */
    Integer createPayment(@Param("payment") Payment payment);


    /**
     * @Description: 根据订单id查询订单
     * @Param:
     * @return:
     * @Author: 泽灿
     * @Date: 2022/4/30
     */
    Payment findPaymentById(long id);
}
