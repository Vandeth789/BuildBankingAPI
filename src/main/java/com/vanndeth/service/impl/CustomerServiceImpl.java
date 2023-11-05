package com.vanndeth.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vanndeth.account.repo.CustomerRepo;
import com.vanndeth.entity.Customer;
import com.vanndeth.exception.ResourceNotFoundException;
import com.vanndeth.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
	
	private final CustomerRepo customerRepo;
	
	@Override
	public Customer create(Customer customer) {
		Customer newCustomer = customerRepo.save(customer);
		return newCustomer;
	}

	@Override
	public Customer getById(Long id) {
		return customerRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", id));
	}

	@Override
	public List<Customer> get() {
		List<Customer> customers = customerRepo.findAll();
		return customers;
	}

}
