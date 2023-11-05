package com.vanndeth.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vanndeth.dto.CustomerDTO;
import com.vanndeth.entity.Customer;
import com.vanndeth.mapper.CustomerMapper;
import com.vanndeth.service.CustomerService;

import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;

@RequestMapping("/customers")
@RequiredArgsConstructor
@RestController
public class CustomerController {
	private final CustomerService customerService;
	private final CustomerMapper customerMapper;
	
	@RolesAllowed("ADMIN")
	@PostMapping("/")
	public ResponseEntity<?> createCustomer(@RequestBody CustomerDTO customerDTO) {
		Customer customer = customerMapper.toCustomer(customerDTO);
		customer = customerService.create(customer);
		return ResponseEntity.ok(customer);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable("id") Long id) {
		Customer customerId = customerService.getById(id);
		return ResponseEntity.ok(customerId);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<?> getAllCustomer() {
		List<Customer> customers = customerService.get();
		return ResponseEntity.ok(customers);
	}
	
}
