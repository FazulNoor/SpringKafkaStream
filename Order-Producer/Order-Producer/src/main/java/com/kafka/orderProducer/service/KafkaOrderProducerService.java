package com.kafka.orderProducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaOrderProducerService {
    
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendOrder(String msg){
        log.info("Send Order to Inventory Topic>>>>>"+msg);
        kafkaTemplate.send("inventoryTopic", msg);
    }
}