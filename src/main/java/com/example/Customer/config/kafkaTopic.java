package com.example.Customer.config;

import com.example.Customer.Models.CustomerEntity;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import reactor.kafka.sender.SenderOptions;

import java.util.Map;

@Configuration
public class kafkaTopic {
	@Bean
	public NewTopic jrathi(){
		return TopicBuilder.name("jrathi").build();
	}

	@Bean
	public NewTopic jsonTopic(){
		return TopicBuilder.name("jsonTopic").build();
	}

	@Bean
	public ReactiveKafkaProducerTemplate<String, String> reactiveKafkaProducerTemplate(
			KafkaProperties properties) {
		Map<String, Object> props = properties.buildProducerProperties();
		return new ReactiveKafkaProducerTemplate<String, String>(SenderOptions.create(props));
	}

	@Bean
	public ReactiveKafkaProducerTemplate<String, CustomerEntity> reactiveKafkaProducerJsonTemplate(
			KafkaProperties properties) {
		Map<String, Object> props = properties.buildProducerProperties();
		return new ReactiveKafkaProducerTemplate<String, CustomerEntity>(SenderOptions.create(props));
	}
}
