package com.example.Customer.Repository;

import com.example.Customer.Models.CustomerEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public interface CustomerRepository extends R2dbcRepository<CustomerEntity,Integer> {
	@Query("select * from person")
	Flux<CustomerEntity> getAll();

	@Query("select * from person where id=:1")
	Mono<CustomerEntity> getOne(int Id);

	@Query("delete from person where id=:Id")
	Mono<Void> del(@Param("Id") int Id);

	@Query(value = "insert into person (name, age, number) values (:1, :2, :3)")
	Mono<CustomerEntity> insert(String name, int age, int number);

	@Query(value = "update person set name=:1, age=:2, number=:3 where id = :4")
	Mono<CustomerEntity> update(String name, int age, int number, int id);
}
