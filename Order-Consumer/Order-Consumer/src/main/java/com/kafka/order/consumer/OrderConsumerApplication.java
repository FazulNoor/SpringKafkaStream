package com.kafka.order.consumer.OrderConsumer;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class OrderConsumerApplication {

	public static void main(String[] args) {
    log.info("Application OrderConsumerApplication Start >>>>>>");
		SpringApplication.run(OrderConsumerApplication.class, args);
    log.info("Application OrderConsumerApplication End >>>>>>");
	}

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {

      System.out.println("Let's inspect the beans provided by Spring Boot:");

      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {
        System.out.println(beanName);
      }
    };
  }    
}
