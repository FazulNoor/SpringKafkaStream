package com.kafka.orderProducer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.apache.kafka.common.config.SecurityConfig;

@Configuration
public class KafkaOrderProducerConfig {
    
    @Bean
    public ProducerFactory<String,String> producerFactory(){
        Map<String, Object> configMap = new HashMap();
        // configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "pkc-lzvrd.us-west4.gcp.confluent.cloud:9092");
        configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "0.0.0.0:9092");
        configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        // configMap.put("sasl.mechanism", "PLAIN");
        // configMap.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule   required username='UTN7C7PX4Y2X6NDK'   password='0b5EhRHMapkN1a/j+5KWweMbxzL2f0D9QS/6d2mNqBFl3lDcFS5pg8JoPiR9LZ5H';");
        // configMap.put("security.protocol", "SASL_SSL");
        // configMap.put("basic.auth.credentials.source","USER_INFO");
        // configMap.put("basic.auth.user.info","PJBY3STK56VXCW63:BSY71TGZ1BqyNEieCu7V7odtIpIQYOFs9FtAyGqIExlnCkTm3h0DYopxmUcO1sKN");
        // configMap.put("schema.registry.ur","https://psrc-2225o.us-central1.gcp.confluent.cloud");
        
        return new DefaultKafkaProducerFactory<String,String>(configMap);
    } 

    @Bean
    public KafkaTemplate<String,String> kafkaTemplate(){
        return new KafkaTemplate<String,String>(producerFactory());
    }
}
