package com.vanndeth.account.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vanndeth.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
