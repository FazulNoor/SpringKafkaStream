package com.kafka.order.consumer.service;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaOrderConsumer {
    
    @KafkaListener(topics = {"inventoryTopic"},containerFactory = "ordContainerFactory", groupId = "groupId")
    public void receiveOrder(String orderId) {
        System.out.println("Order Received>>>>>>"+orderId);
    }
}
