package com.example.cloudproviderpayment8002.mapper;

import com.example.cloudaipcommons.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentMapper {
    List<Payment> findAll();
    int addPayment(@Param("payment") Payment payment);
}
