package com.vanndeth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.vanndeth.dto.CustomerDTO;
import com.vanndeth.entity.Customer;
import com.vanndeth.entity.CustomerType;
import com.vanndeth.service.CustomerService;
import com.vanndeth.service.CustomerTypeService;

@Mapper(componentModel = "spring", uses = {CustomerTypeService.class, CustomerService.class})
public interface CustomerMapper {

	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	
	@Mapping(target = "customersId", ignore = true)
	Customer toCustomer(CustomerDTO customerDTO);
	
	
	/*
	default CustomerType toCustomerType(String customerTypesCode) {
		CustomerType customerType = new CustomerType();
		customerType.setCustomerTypesCode(customerTypesCode);
		return customerType;
	}
	*/
}
