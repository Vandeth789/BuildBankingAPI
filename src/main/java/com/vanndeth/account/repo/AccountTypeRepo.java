package com.vanndeth.account.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vanndeth.entity.AccountType;

public interface AccountTypeRepo extends JpaRepository<AccountType, String>, JpaSpecificationExecutor<AccountType> {
	AccountType findByAccountTypesCode(String id);
}
