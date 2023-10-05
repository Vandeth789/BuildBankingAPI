package com.vanndeth.service;

import java.util.List;

import com.vanndeth.entity.Customer;

public interface CustomerService {
	Customer create(Customer customer);
	Customer getById(Long id);
	List<Customer> get();
}
