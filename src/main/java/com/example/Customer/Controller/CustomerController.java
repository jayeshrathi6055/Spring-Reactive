package com.example.Customer.Controller;

import com.example.Customer.Dto.CustomerDto;
import com.example.Customer.Services.CustomerService;
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
	public Flux<CustomerDto> getAll(){
		return service.allCustomer();
	}

	@GetMapping("/getPerson/{id}")
	public Mono<CustomerDto> getPerson(@PathVariable String id){
		return service.getCustomer(Integer.parseInt(id.trim()));
	}

	@GetMapping("/rangeInAge")
	public Flux<CustomerDto> ageInRange(@RequestParam int min, @RequestParam int max){
		return service.getCustomerInRange(min, max);
	}

	@DeleteMapping("/deletePerson/{id}")
	public Mono<Void> deletePerson(@PathVariable String id){
		return service.deleteCustomer(Integer.parseInt(id));
	}

	@PostMapping("/createPerson")
	public Mono<CustomerDto> createPerson(@RequestBody Mono<CustomerDto> customerDto){
		return service.saveCustomer(customerDto);
	}
	@PutMapping("/updatePerson/{id}")
	public Mono<CustomerDto> updatePerson(@RequestBody Mono<CustomerDto> customerDtoMono, @PathVariable String id){
		return service.updateCustomer(customerDtoMono,Integer.parseInt(id));
	}
}
