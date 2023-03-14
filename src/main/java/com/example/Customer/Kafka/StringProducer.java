package com.example.Customer.Kafka;


import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StringProducer {
	private static final Logger logger = LoggerFactory.getLogger(StringProducer.class);
	private ReactiveKafkaProducerTemplate<String,String> sender;
	public void sendMessage(String message){
		logger.info(String.format("New Message - %s",message));
		sender.send("jrathi",message).subscribe();
	}
}
