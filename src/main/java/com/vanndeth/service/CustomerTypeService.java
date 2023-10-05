package com.vanndeth.service;

import java.util.List;

import com.vanndeth.entity.CustomerType;

public interface CustomerTypeService {
	CustomerType create(CustomerType customerType);
	CustomerType getById(String id);
	List<CustomerType> get();
	CustomerType update(String id, CustomerType customerTypeUpdate);
	void delete(String id);

}
