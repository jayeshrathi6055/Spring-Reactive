package com.example.Customer.Repository;

import com.example.Customer.Models.CustomerEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends R2dbcRepository<CustomerEntity,Integer> {
}
