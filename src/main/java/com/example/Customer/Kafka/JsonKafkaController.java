package com.example.Customer.Kafka;

import com.example.Customer.Models.CustomerEntity;
import com.example.Customer.Models.Person;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class JsonKafkaController {
	private JsonProducer sender;

	@PostMapping("/jsonPublish")
	public void jsonPublish(@RequestBody CustomerEntity data){
		System.out.println(data.getName());
		sender.sendMessage(data);
	}
	@PostMapping("/kafkaPerson")
	public Mono<Person> person(@RequestBody Person p){
		return sender.sendPerson(p);
	}
}
