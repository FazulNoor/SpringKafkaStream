package com.kafka.order.consumer.controller;

import com.kafka.order.consumer.OrderConsumer.service.KafkaOrderProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class OrderConsumerController{

    @Autowired
    private KafkaOrderProducer kafkaOrderProducer;

    public String hello(){
        return "Hello World!!";
    }
    
    @GetMapping("/ord/{orderId}")
    public void publishOrder(@PathVariable String orderId){
        kafkaOrderProducer.sendOrder(orderId);
    }
}