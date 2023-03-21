package com.example.Customer.Kafka;

import com.example.Customer.Models.CustomerEntity;
import com.example.Customer.Repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;


@Service
public class JsonProducer {
	private static final Logger logger = LoggerFactory.getLogger(JsonProducer.class);
	private ReactiveKafkaProducerTemplate<String, CustomerEntity> sender;
	@Autowired
	private CustomerRepository repository;

	public JsonProducer(ReactiveKafkaProducerTemplate<String, CustomerEntity> sender) {
		this.sender = sender;
	}

	public void sendMessage(CustomerEntity data){
		logger.info(String.format("New Message - %s",data.toString()));
		sender.send("jsonTopic",data).subscribe();
	}
}
