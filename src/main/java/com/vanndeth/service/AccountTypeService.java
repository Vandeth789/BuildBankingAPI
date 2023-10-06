package com.vanndeth.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.vanndeth.entity.AccountType;

public interface AccountTypeService {
	AccountType create(AccountType accountType);
	AccountType getById(String id);
	List<AccountType> get();
	AccountType update(String id, AccountType accountTypeUpdate);
	Page<AccountType> gets(Map<String, String> params);
}
