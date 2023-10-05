package com.vanndeth.account.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vanndeth.entity.CustomerType;

public interface CustomerTypeRepo extends JpaRepository<CustomerType, String>{
	
}
