package com.example.Customer.Services;

import com.example.Customer.Dto.CustomerDto;
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
	private CustomerRepository repo;

//	Get Method
	public Flux<CustomerDto> allCustomer(){
		return repo.findAll().map(CustomerUtils::entityToDto);
	}
	public Mono<CustomerDto> getCustomer(int id){
		return repo.findById(id).map(CustomerUtils::entityToDto);
	}
	public Flux<CustomerDto> getCustomerInRange(int min, int max){
		return repo.findAll().filter(i -> i.getAge()>min && i.getAge()<max).map(CustomerUtils::entityToDto);
	}

//	Create Method
	public Mono<CustomerDto> saveCustomer(Mono<CustomerDto> customerDtoMono){
//		.doOnNext(e->e.setId((int)Math.floor(Math.random() * (100 - 1 + 1) + 1)))
		return customerDtoMono.map(CustomerUtils::dtoToEntity).flatMap(repo::save).map(CustomerUtils::entityToDto);
	}

//	Update Method
	public Mono<CustomerDto> updateCustomer(Mono<CustomerDto> customerDtoMono, int id){
		return repo.findById(id).flatMap(c -> customerDtoMono.map(CustomerUtils::dtoToEntity).doOnNext(e -> e.setId(id)))
				.flatMap(repo::save).map(CustomerUtils::entityToDto);
	}

//	Delete Method
	public Mono<Void> deleteCustomer(int id){
		return repo.deleteById(id);
	}
}
