package com.example.Customer.Controller;

import com.example.Customer.Dto.CustomerDto;
import com.example.Customer.Models.CustomerEntity;
import com.example.Customer.Repository.CustomerRepository;
import com.example.Customer.Services.CustomerService;
import com.example.Customer.Utils.CustomerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService service;

	@GetMapping("/allPerson")
	public Flux<CustomerEntity> getAll(){
		return service.allCustomer();
	}

	@GetMapping("/getPerson/{id}")
	public Mono<CustomerEntity> getPerson(@PathVariable String id){
		return service.getCustomer(Integer.parseInt(id.trim()));
	}

	@DeleteMapping("/deletePerson/{id}")
	public Mono<Void> deletePerson(@PathVariable String id){
		return service.deleteCustomer(Integer.parseInt(id));
	}

	@PostMapping("/createPerson")
	public Mono<CustomerEntity> createPerson(@RequestBody CustomerEntity customerEntity){
		return service.saveCustomer(customerEntity);
	}
	@PutMapping("/updatePerson/{id}")
	public Mono<CustomerEntity> updatePerson(@RequestBody CustomerEntity customerEntity, @PathVariable String id){
		return service.updateCustomer(customerEntity,Integer.parseInt(id));
	}
}
