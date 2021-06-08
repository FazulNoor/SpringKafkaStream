package com.kafka.order.consumer.OrderConsumer.config;

import java.io.ObjectInputFilter.Config;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.connect.json.JsonSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class OrderKafkaConfig {

    @Bean
    ProducerFactory<String, String> producerFactory() {
        Map<String, Object> configMap = new HashMap();
        configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092");
        configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configMap);
    }

    @Bean
    KafkaTemplate<String,String> kafkaTemplate(){
        return new KafkaTemplate<String,String>(producerFactory());
    }

}