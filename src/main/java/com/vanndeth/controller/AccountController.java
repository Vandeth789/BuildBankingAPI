package com.vanndeth.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vanndeth.dto.AccountDTO;
import com.vanndeth.entity.Account;
import com.vanndeth.mapper.AccountMapper;
import com.vanndeth.service.AccountService;

import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AccountController {
	private final AccountService accountService;
	private final AccountMapper accountMapper;

	// @RolesAllowed("ADMIN") or below
	@PreAuthorize("hasAuthority('account:write')")
	@PostMapping("/")
	public ResponseEntity<?> createAccount(@RequestBody AccountDTO accountDTO) {
		Account account = accountMapper.toAccount(accountDTO);
		Account newAccount = accountService.create(account);
		return ResponseEntity.ok(newAccount);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable("id") Long id) {
		Account accountId = accountService.getById(id);
		return ResponseEntity.ok(accountId);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllAccount() {
		List<Account> accounts = accountService.get();
		return ResponseEntity.ok(accounts);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateAccountById(@PathVariable("id") Long id, @RequestBody Account account){
		Account accountUpdated = accountService.update(id, account);
		return ResponseEntity.ok(accountUpdated);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAccountById(@PathVariable("id") Long id) {
		accountService.delete(id);
	}
	
}
