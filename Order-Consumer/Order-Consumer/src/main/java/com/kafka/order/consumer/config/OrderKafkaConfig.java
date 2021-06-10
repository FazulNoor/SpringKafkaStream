package com.kafka.order.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import lombok.extern.slf4j.Slf4j;


@Configuration
@Slf4j
public class OrderKafkaConfig {

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        log.info("Start consumerFactory>>>>");
        Map<String, Object> configMap = new HashMap();
        configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configMap.put(ConsumerConfig.GROUP_ID_CONFIG,"groupId");
        configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        log.info("End consumerFactory>>>>");
        return new DefaultKafkaConsumerFactory<>(configMap);

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,String> ordContainerFactory(){
        log.info("Start ordContainerFactory>>>>");
        ConcurrentKafkaListenerContainerFactory<String,String> conKafkaContFactory = new ConcurrentKafkaListenerContainerFactory<>();
        conKafkaContFactory.setConsumerFactory(consumerFactory());
        conKafkaContFactory.setConcurrency(3);
        log.info("End ordContainerFactory>>>>");
        return conKafkaContFactory;
    }

}