package com.vanndeth.service;
import java.util.List;

import com.vanndeth.entity.Account;

public interface AccountService {
	public Account create(Account account);
	public Account getById(Long id);
	public List<Account> get();
}
