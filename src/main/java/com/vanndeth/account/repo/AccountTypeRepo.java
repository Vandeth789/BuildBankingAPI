package com.vanndeth.account.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vanndeth.entity.AccountType;

public interface AccountTypeRepo extends JpaRepository<AccountType, String> {
	AccountType findByAccountTypesCode(String id);
}
