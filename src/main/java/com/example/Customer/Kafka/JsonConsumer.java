package com.example.Customer.Kafka;

import com.example.Customer.Models.CustomerEntity;
import com.example.Customer.Repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class JsonConsumer {
	@Autowired
	private CustomerRepository repository;

	private ReactiveKafkaConsumerTemplate<String, Flux<CustomerEntity>> consumer;
	private static final Logger logger = LoggerFactory.getLogger(JsonConsumer.class);

	public JsonConsumer(ReactiveKafkaConsumerTemplate<String, Flux<CustomerEntity>> consumer) {
		this.consumer = consumer;
	}

	@KafkaListener(topics = "jsonTopic", groupId = "consumerId")
	public void consume(CustomerEntity message , @Payload List<CustomerEntity> messages){
		logger.info(String.format("Data -> %s", message.toString()));
		messages.forEach(i-> System.out.println(i.getName()));
		if(message.getId()==0){
			repository.insert(message.getName(),message.getAge(),message.getNumber()).subscribe();
		}else {
			repository.update(message.getName(),message.getAge(), message.getNumber(), message.getId()).subscribe();
		}
	}
}
