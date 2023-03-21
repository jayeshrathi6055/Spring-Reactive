package com.example.Customer.config;

import com.example.Customer.Models.CustomerEntity;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import reactor.core.publisher.Flux;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.sender.SenderOptions;

import java.util.Collections;
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
	public NewTopic database(){
		return TopicBuilder.name("database").build();
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
	@Bean
	public ReactiveKafkaProducerTemplate<String, Flux<CustomerEntity>> reactiveKafkaProducerListJsonTemplate(
			KafkaProperties properties) {
		Map<String, Object> props = properties.buildProducerProperties();
		return new ReactiveKafkaProducerTemplate<String, Flux<CustomerEntity>>(SenderOptions.create(props));
	}

	@Bean
	public ReceiverOptions<String, Flux<CustomerEntity>> kafkaReceiverOptions(@Value(value = "jsonTopic") String topic, KafkaProperties kafkaProperties) {
		ReceiverOptions<String, Flux<CustomerEntity>> basicReceiverOptions = ReceiverOptions.create(kafkaProperties.buildConsumerProperties());
		return basicReceiverOptions.subscription(Collections.singletonList(topic));
	}

	@Bean
	public ReactiveKafkaConsumerTemplate<String, Flux<CustomerEntity>> kafkaConsumerTemplate(ReceiverOptions<String, Flux<CustomerEntity>> kafkaReceiverOptions) {
		return new ReactiveKafkaConsumerTemplate<String, Flux<CustomerEntity>>(kafkaReceiverOptions);
	}

}
