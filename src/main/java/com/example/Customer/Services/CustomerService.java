package com.example.Customer.Services;

import com.example.Customer.Dto.CustomerDto;
import com.example.Customer.Models.CustomerEntity;
import com.example.Customer.Repository.CustomerRepository;
import com.example.Customer.Utils.CustomerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;


@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repository;

	public Flux<CustomerEntity> allCustomer(){
		return repository.findAll();
	}

	public Mono<CustomerEntity> getCustomer(int id){
		return repository.findById(id);
	}

	public Mono<CustomerEntity> saveCustomer(CustomerEntity pe){
		return repository.save(pe);
	}

	public Mono<CustomerEntity> updateCustomer(CustomerEntity pe, int id){
		repository.deleteById(id);
		pe.setId(id);
		return repository.save(pe);
	}

	public Mono<Void> deleteCustomer(int id){
		return repository.deleteById(id);
	}
}
