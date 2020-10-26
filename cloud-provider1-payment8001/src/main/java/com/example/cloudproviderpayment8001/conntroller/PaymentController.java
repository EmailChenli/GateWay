package com.example.cloudproviderpayment8001.conntroller;

import com.example.cloudaipcommons.entity.CommonResult;
import com.example.cloudaipcommons.entity.Payment;
import com.example.cloudproviderpayment8001.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("findAll")
    public CommonResult<?> findAll(){
        log.info("FindAll");
        CommonResult<List<Payment>> commonResult = new CommonResult<>();
        commonResult.setCode(200);
        commonResult.setMessage("Success::"+serverPort);
        commonResult.setData(paymentService.findAll());
        return commonResult;
    }

    @PostMapping("add")
    public CommonResult<?> addPayment(@RequestBody Payment payment){
        log.info("FindAll");
        CommonResult<Integer> commonResult = new CommonResult<>();
        commonResult.setCode(200);
        commonResult.setMessage("Success");
        commonResult.setData(paymentService.addPayment(payment));
        return commonResult;
    }

}
