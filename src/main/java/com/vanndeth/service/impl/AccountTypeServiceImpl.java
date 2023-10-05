package com.vanndeth.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vanndeth.account.repo.AccountTypeRepo;
import com.vanndeth.entity.AccountType;
import com.vanndeth.exception.ApiException;
import com.vanndeth.exception.ResourceNotFoundException;
import com.vanndeth.service.AccountTypeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountTypeServiceImpl implements AccountTypeService {

	private final AccountTypeRepo accountTypeRepo;

	@Override
	public AccountType create(AccountType accountType) {
		AccountType accountTypes = accountTypeRepo.save(accountType);
		return accountTypes;
	}

	@Override
	public AccountType getById(String id) {
		return accountTypeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account Type", id));
	}

	@Override
	public List<AccountType> get() {
		List<AccountType> accountTypes = accountTypeRepo.findAll();
		return accountTypes;
	}

	@Override
	public AccountType update(String id, AccountType accountTypeUpdate) {
		AccountType accountType = getById(id);
//		accountType.setAccountTypesCode(accountTypeUpdate.getAccountTypesCode());
		accountType.setAccountTypesDescription(accountTypeUpdate.getAccountTypesDescription());
		return accountTypeRepo.save(accountType);
	}

}
