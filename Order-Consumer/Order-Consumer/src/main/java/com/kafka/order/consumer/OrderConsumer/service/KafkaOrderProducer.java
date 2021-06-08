package com.kafka.order.consumer.OrderConsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaOrderProducer {
    
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendOrder(String msg) {
        kafkaTemplate.send("KakfaOrder",msg);
    }
}
