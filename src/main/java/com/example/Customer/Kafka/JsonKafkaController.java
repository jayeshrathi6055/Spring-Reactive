package com.example.Customer.Kafka;

import com.example.Customer.Models.CustomerEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class JsonKafkaController {
	private JsonProducer sender;


	@PostMapping("/jsonPublish")
	public void jsonPublish(@RequestBody CustomerEntity data){
		System.out.println(data.getName());
		sender.sendMessage(data);
	}
}
