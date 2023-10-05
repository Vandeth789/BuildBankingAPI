package com.vanndeth.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vanndeth.account.repo.AccountRepo;
import com.vanndeth.entity.Account;
import com.vanndeth.exception.ApiException;
import com.vanndeth.exception.ResourceNotFoundException;
import com.vanndeth.service.AccountService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService{
	public final AccountRepo accountRepo;

	
	@Override
	public Account create(Account account) {
		return accountRepo.save(account);
	}


	@Override
	public Account getById(Long id) {
		/*
		Optional<Account> accountId = accountRepo.findById(id);
		if(accountId.isPresent()) {
			return accountId.get();
		}
		throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Account with id %d not found...!".formatted(id));
//		throw new HttpClientErrorException(HttpStatus.NOT_FOUND, String.format("Account with id %d not found...!", id));
		*/
//		return accountRepo.findById(id).orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Account with id %d not found...!".formatted(id)));
		return accountRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account", id));
	}


	@Override
	public List<Account> get() {
		List<Account> accounts = accountRepo.findAll();
		return accounts;
	}

}
