package com.kafka.orderProducer.Controller;

import com.kafka.orderProducer.service.KafkaOrderProducerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OrderProducerController {

    @Autowired
    private KafkaOrderProducerService kafkaOrderProducerService;
    
    @PutMapping("/ord/{orderId}")
    public String sendOrder(@PathVariable String orderId){
        kafkaOrderProducerService.sendOrder(orderId);
        return "Order Id Send to Processor ="+orderId;
    }
}
