package com.kafka.order.consumer.OrderConsumer.config;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderKafkaConfig{

    @Bean
    KafkaProducer orderKafkaProducer(){
        Properties
    }

}