package com.kafka.OrderProducer.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OrderProducerController {
    
    @PutMapping("/ord/{orderId}")
    public String sendOrder(@PathVariable String orderId){
        return "Order Send to Processor ="+orderId;
    }
}
