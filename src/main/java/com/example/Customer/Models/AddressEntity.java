package com.example.Customer.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addr")
public class AddressEntity {
	@Id
	@Column("address_id")
	@GeneratedValue
	private int address_id;
	private String location;
	@Column("zipcode")
	private String zipCode;
}
