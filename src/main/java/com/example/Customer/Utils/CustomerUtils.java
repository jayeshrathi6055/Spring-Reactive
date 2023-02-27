package com.example.Customer.Utils;
import com.example.Customer.Dto.CustomerDto;
import com.example.Customer.Models.CustomerEntity;
import org.springframework.beans.BeanUtils;

public class CustomerUtils {
	public static CustomerDto entityToDto(CustomerEntity customerEntity){
		CustomerDto c = new CustomerDto();
		BeanUtils.copyProperties(customerEntity, c);
		return c;
	}
	public static CustomerEntity dtoToEntity(CustomerDto customerDto){
		CustomerEntity c = new CustomerEntity();
		BeanUtils.copyProperties(customerDto, c);
		return c;
	}
}
