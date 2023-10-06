package com.vanndeth.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vanndeth.account.repo.AccountTypeRepo;
import com.vanndeth.entity.AccountType;
import com.vanndeth.exception.ResourceNotFoundException;
import com.vanndeth.service.AccountTypeService;
import com.vanndeth.service.utils.PageUtil;
import com.vanndeth.specification.AccountTypeFilter;
import com.vanndeth.specification.AccountTypeSpec;

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

	@Override
	public Page<AccountType> gets(Map<String, String> params) {
		AccountTypeFilter filter = new AccountTypeFilter();
		
		int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;
		if(params.containsKey(PageUtil.PAGE_LIMIT)) {
			pageLimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
		}
		
		int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
		if(params.containsKey(PageUtil.PAGE_NUMBER)) {
			pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
		}
		
		AccountTypeSpec spec = new AccountTypeSpec(filter);
		Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);
		Page<AccountType> page = accountTypeRepo.findAll(spec, pageable);
		
		return page;
	}

}
