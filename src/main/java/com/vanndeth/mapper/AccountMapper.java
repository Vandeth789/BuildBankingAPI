package com.vanndeth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.vanndeth.dto.AccountDTO;
import com.vanndeth.entity.Account;
import com.vanndeth.service.AccountTypeService;
import com.vanndeth.service.CustomerService;
@Mapper(componentModel = "spring", uses = {AccountTypeService.class, CustomerService.class})
public interface AccountMapper {
	
	AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
	
	@Mapping(target = "accountId", ignore = true)
	@Mapping(target = "accountTypesCode", source = "accountTypesCode")
	@Mapping(target = "customersId", source = "customersId")
	Account toAccount(AccountDTO accountDTO);
	
	/*
	default AccountType toAccountType(String accountTypesCode) {
		AccountType accountType = new AccountType();
		accountType.setAccountTypesCode(accountTypesCode);
		return accountType;
	}
	
	default Customer toCustomer(Long customersId) {
		Customer customer = new Customer();
		customer.setCustomersId(customersId);
		return customer;
	}
	*/
}
