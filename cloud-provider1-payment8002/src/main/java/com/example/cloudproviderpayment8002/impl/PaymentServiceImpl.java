package com.example.cloudproviderpayment8002.impl;

import com.example.cloudaipcommons.entity.Payment;
import com.example.cloudproviderpayment8002.mapper.PaymentMapper;
import com.example.cloudproviderpayment8002.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentMapper paymentMapper;

    @Override
    public List<Payment> findAll() {
        return paymentMapper.findAll();
    }

    @Override
    public int addPayment(Payment payment) {
        return paymentMapper.addPayment(payment);
    }

}
