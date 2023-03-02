package com.example.Customer.Services;

import com.example.Customer.Models.CustomerEntity;
import com.example.Customer.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repository;

	public Flux<CustomerEntity> allCustomer(){
		return repository.getAll();
	}

	public Mono<CustomerEntity> getCustomer(int id){
		return repository.getOne(id);
	}

	public Mono<CustomerEntity> saveCustomer(CustomerEntity pe){
		return repository.insert(pe.getName(),pe.getAge(),pe.getNumber());
	}

	public Mono<CustomerEntity> updateCustomer(CustomerEntity pe, int id){
		return repository.update(pe.getName(),pe.getAge(),pe.getNumber(), id);
	}

	public Mono<Void> deleteCustomer(int id){
		return repository.del(id);
	}
}
