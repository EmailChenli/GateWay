package com.example.cloudproviderpayment8001.controller;

import com.example.cloudaipcommons.entity.CommonResult;
import com.example.cloudaipcommons.entity.Payment;
import com.example.cloudproviderpayment8001.service.PaymentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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

    //@GetMapping("findAll")
    @ApiOperation(value="查询全部", notes="返回结果集")
    @ApiImplicitParam(name = "查询全部", value = "无参数", required = true, dataType = "")
    @RequestMapping(value = "findAll",method = RequestMethod.GET)
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

    @ApiOperation(value="Head请求方法测试", notes="根据请求头返回")
    @ApiImplicitParam(name = "language", value = "接收语言", required = true, dataType = "String")
    @RequestMapping(value = "findHead",method = RequestMethod.HEAD)
    public String findHead(){
        log.info("FindHead");
        return "FindHead";
    }

    @ApiOperation(value="Head请求方法测试", notes="根据请求头返回")
    @ApiImplicitParam(name = "language", value = "接收语言", required = true, dataType = "String")
    @RequestMapping(value = "findPUT",method = RequestMethod.PUT)
    public String findPut(){
        log.info("FindPut");
        return "FindPut";
    }


    @ApiOperation(value="Head请求方法测试", notes="根据请求头返回")
    @ApiImplicitParam(name = "language", value = "接收语言", required = true, dataType = "String")
    @RequestMapping(value = "findDELETE",method = RequestMethod.DELETE)
    public String findDelete(){
        log.info("FindDelete");
        return "FindDelete";
    }



}
