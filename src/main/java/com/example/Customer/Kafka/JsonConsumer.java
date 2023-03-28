package com.example.Customer.Kafka;

import com.example.Customer.Models.CustomerEntity;
import com.example.Customer.Models.Person;
import com.example.Customer.Repository.AddressRepository;
import com.example.Customer.Repository.CustomerRepository;
import com.example.Customer.Repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class JsonConsumer {
	@Autowired
	private CustomerRepository repository;
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private AddressRepository addressRepository;

	private ReactiveKafkaConsumerTemplate<String, Flux<CustomerEntity>> consumer;
	private static final Logger logger = LoggerFactory.getLogger(JsonConsumer.class);

	public JsonConsumer(ReactiveKafkaConsumerTemplate<String, Flux<CustomerEntity>> consumer) {
		this.consumer = consumer;
	}

	@KafkaListener(topics = "jsonTopic", groupId = "consumerId")
	public void consume(CustomerEntity message){
		logger.info(String.format("Data -> %s", message.toString()));
		if(message.getId()==0){
			repository.insert(message.getName(),message.getAge(),message.getNumber()).subscribe();
		}else {
			repository.update(message.getName(),message.getAge(), message.getNumber(), message.getId()).subscribe();
		}
	}

	@KafkaListener(topics = "database", groupId = "consumerId")
	public void person(Person p){
		logger.info(String.format("Consume Message is - %s",p.toString()));
		personRepository.save(p.getPersonEntity()).zipWith(addressRepository.save(p.getAddressEntity()),(c,a)->new Person(c,a)).subscribe();
	}
}
