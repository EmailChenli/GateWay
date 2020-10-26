package com.example.cloudproviderpayment8002.conntroller;

import com.example.cloudaipcommons.entity.CommonResult;
import com.example.cloudaipcommons.entity.Payment;
import com.example.cloudproviderpayment8002.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("payment8002")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

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
        commonResult.setMessage("Success::");
        commonResult.setData(paymentService.addPayment(payment));
        return commonResult;
    }

    @GetMapping("discovery")
    public Object discovery(){
        List<String> services =  discoveryClient.getServices();
        for(String element : services){
            log.info("List:::"+element);
        }
        List<ServiceInstance>  instances = discoveryClient.getInstances("CLOUD-SERVICE-PAYMENT");
        for(ServiceInstance instance : instances){
            log.info(instance.getServiceId()+"::\n"+instance.getHost()+"::\n"+instance.getPort()+"::\n"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
