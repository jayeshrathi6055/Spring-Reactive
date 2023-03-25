package com.example.Customer.Controller;

import com.example.Customer.Models.Person;
import com.example.Customer.Repository.AddressRepository;
import com.example.Customer.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PersonController {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private AddressRepository addressRepository;

	@GetMapping("/customers")
	public Flux<Person> allCustomer(){
		var customer = personRepository.findAll();
		var address = addressRepository.findAll();
		return customer.zipWith(address,(c,a)->new Person(c,a));
	}
	@GetMapping("/customers/{id}")
	public Mono<Person> getCustomer(@PathVariable String id){
		var customer = personRepository.findById(Integer.parseInt(id.trim()));
		var address = addressRepository.findById(Integer.parseInt(id.trim()));
		return customer.zipWith(address,(c,a)->new Person(c,a));
	}
	@PostMapping("/create")
	public Mono<Person> create(@RequestBody Person p){
		return personRepository.save(p.getPersonEntity()).zipWith(addressRepository.save(p.getAddressEntity()),(c,a)->new Person(c,a));
	}
	@PutMapping("/update")
	public Mono<Person> update(@RequestBody Person p){
		return personRepository.save(p.getPersonEntity()).zipWith(addressRepository.save(p.getAddressEntity()),(c,a)->new Person(c,a));
	}
}
