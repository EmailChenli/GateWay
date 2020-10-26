package com.example.cloudproviderpayment8001.service;

import com.example.cloudaipcommons.entity.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> findAll();
    int addPayment(Payment payment);
}
