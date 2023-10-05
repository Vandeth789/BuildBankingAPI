package com.vanndeth.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vanndeth.entity.CustomerType;
import com.vanndeth.service.CustomerTypeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customer-types")
public class CustomerTypeController {
	
	private final CustomerTypeService customerTypeService;
	
	@PostMapping("/")
	public ResponseEntity<?> createCustomerType(@RequestBody CustomerType customerType) {
		CustomerType newCustomerType = customerTypeService.create(customerType);
		return ResponseEntity.ok(newCustomerType);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerTypeById(@PathVariable("id") String id) {
		CustomerType customerTypeId = customerTypeService.getById(id);
		return ResponseEntity.ok(customerTypeId);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllCustomerType() {
		List<CustomerType> customerTypes = customerTypeService.get();
		return ResponseEntity.ok(customerTypes);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCustomerTypeById(@PathVariable("id") String id, CustomerType newCustomerType) {
		CustomerType updateCustomerType = customerTypeService.update(id, newCustomerType);
		return ResponseEntity.ok(updateCustomerType);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomerTypeById(@PathVariable String id) {
		customerTypeService.delete(id);
	}

}
