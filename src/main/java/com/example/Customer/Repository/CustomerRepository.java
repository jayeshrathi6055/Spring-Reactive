package com.example.Customer.Repository;

import com.example.Customer.Dto.CustomerDto;
import com.example.Customer.Models.CustomerEntity;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerRepository extends R2dbcRepository<CustomerEntity,Integer> {
//	@Query("select * from person")
//	Flux<CustomerDto> getAll();
//
//	@Query("select * from person where id=:Id")
//	Mono<CustomerDto> getOne(@Param("Id") int Id);

//	@Query(value = "update person p set p.name = :name, p.age = :age, p.number = :number where p.id = 1")
//	@Modifying()
//	@Transactional
//	void update(@Param("name") String name, @Param("age") int age, @Param("number") int number, @Param("Id") String Id);

//	@Query("delete from person where id=:Id")
//	Mono<Void> del(@Param("Id") int Id);
//
//	@Query(value = "insert into person (name, age, number) values (?0, ?1, ?2)")
//	Mono<CustomerDto> insert(String name, int age, int number);
//
//	@Query(value = "update table person set name=:name, age=:age, number=:number")
//	Mono<CustomerEntity> update(@Param("name") String name, @Param("age") int age, @Param("number") int number);
}
