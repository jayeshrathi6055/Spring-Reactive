package com.example.Customer.Models;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "person")
@EntityScan
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
	@Id
	@Column("id")
	private int id;
	@Column("name")
	private String name;
	@Column("age")
	private int age;
	@Column("number")
	private int number;
}
