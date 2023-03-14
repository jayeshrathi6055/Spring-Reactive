package com.example.Customer.Kafka;

import com.example.Customer.Models.CustomerEntity;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JsonProducer {
	private static final Logger logger = LoggerFactory.getLogger(StringProducer.class);
	private ReactiveKafkaProducerTemplate<String, CustomerEntity> sender;

	public void sendMessage(CustomerEntity data){
		logger.info(String.format("New Message - %s",data.getName()));
		sender.send("jsonTopic",data).subscribe();
	}
}
