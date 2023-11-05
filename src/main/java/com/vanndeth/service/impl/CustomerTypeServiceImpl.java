package com.vanndeth.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vanndeth.account.repo.CustomerTypeRepo;
import com.vanndeth.entity.CustomerType;
import com.vanndeth.exception.ResourceNotFoundException;
import com.vanndeth.service.CustomerTypeService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
	private final CustomerTypeRepo customerTypeRepo;
	
	@Override
	public CustomerType create(CustomerType customerType) {
		CustomerType newCustomerType = customerTypeRepo.save(customerType);
		return newCustomerType;
	}

	@Override
	public CustomerType getById(String id) {
		return customerTypeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer Type", id));
	}

	@Override
	public List<CustomerType> get() {
		List<CustomerType> customerTypes = customerTypeRepo.findAll();
		return customerTypes;
	}

	@Override
	public CustomerType update(String id, CustomerType customerTypeUpdate) {
		Optional<CustomerType> customerTypeId = customerTypeRepo.findById(id);
		CustomerType customerTypeToUpdate = customerTypeId.get();
		if(customerTypeId.isPresent()) {
			customerTypeToUpdate.setCustomerTypesCode(customerTypeUpdate.getCustomerTypesCode());
			customerTypeToUpdate.setCustomerTypesDescription(customerTypeUpdate.getCustomerTypesDescription());
			customerTypeRepo.save(customerTypeToUpdate);
		}
		return customerTypeToUpdate;
	}

	@Override
	public void delete(String id) {
		customerTypeRepo.deleteById(id);
	}

}
