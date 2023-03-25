package com.example.Customer.Repository;

import com.example.Customer.Models.PersonEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends R2dbcRepository<PersonEntity, Integer> {
}
