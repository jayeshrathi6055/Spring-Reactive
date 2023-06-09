package com.example.Customer.Kafka;

import com.example.Customer.Models.CustomerEntity;
import com.example.Customer.Models.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class kafkaController {
	private StringProducer producer;

	public kafkaController(StringProducer producer) {
		this.producer = producer;
	}

	@GetMapping("/publish")
	public void publish(@RequestParam String message){
		producer.sendMessage(message);
	}
}
