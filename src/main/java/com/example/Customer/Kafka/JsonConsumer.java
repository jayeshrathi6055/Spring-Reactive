package com.example.Customer.Kafka;

import com.example.Customer.Models.CustomerEntity;
import com.example.Customer.Repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonConsumer {
	@Autowired
	private CustomerRepository repository;
	private static final Logger logger = LoggerFactory.getLogger(JsonConsumer.class);

	@KafkaListener(topics = "jsonTopic", groupId = "consumerId")
	public void consume(CustomerEntity message){
		logger.info(String.format("Data -> %s", message.getName()));
		repository.insert(message.getName(),message.getAge(),message.getNumber()).subscribe();
	}
}
