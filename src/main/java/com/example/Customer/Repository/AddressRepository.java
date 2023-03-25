package com.example.Customer.Repository;

import com.example.Customer.Models.AddressEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AddressRepository extends R2dbcRepository<AddressEntity, Integer> {

}
