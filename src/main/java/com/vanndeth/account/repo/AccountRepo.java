package com.vanndeth.account.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vanndeth.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Long>{
	
}
