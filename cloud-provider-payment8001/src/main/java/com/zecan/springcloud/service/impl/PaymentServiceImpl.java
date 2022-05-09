package com.zecan.springcloud.service.impl;


import com.zecan.springcloud.dao.PaymentDao;
import com.zecan.springcloud.entity.Payment;
import com.zecan.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public Integer createPayment(Payment payment) {
        return paymentDao.createPayment(payment);
    }

    @Override
    public Payment findPaymentById(long id) {
        return paymentDao.findPaymentById(id);
    }
}
