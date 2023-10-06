package com.vanndeth.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vanndeth.dto.AccountTypeDTO;
import com.vanndeth.entity.AccountType;
import com.vanndeth.mapper.AccountTypeMapper;
import com.vanndeth.service.AccountTypeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/account-types")
@RestController
public class AccountTypeController {
	private final AccountTypeService accountTypeService;

	@PostMapping("/")
	public ResponseEntity<?> createAccountType(@RequestBody AccountType accountType) {
		AccountType newAccountType = accountTypeService.create(accountType);
		return ResponseEntity.ok(newAccountType);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getAccountTypeById(@PathVariable String id) {
		AccountType accountTypeId = accountTypeService.getById(id);
		return ResponseEntity.ok(accountTypeId);
	}

//	@GetMapping("/")
//	public ResponseEntity<?> getAllAccountTypes() {
//		List<AccountTypeDTO> accountTypeDTO = accountTypeService.get().stream()
//				.map(accountType -> AccountTypeMapper.INSTANCE.toAccountTypeDTO(accountType))
//				.collect(Collectors.toList());
//		return ResponseEntity.ok(accountTypeDTO);
//	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateAccountType(@PathVariable("id") String id,
			@RequestBody AccountTypeDTO accountTypeDTO) {
		AccountType accountType = AccountTypeMapper.INSTANCE.toAccountType(accountTypeDTO);
		AccountType accountTypeUpdated = accountTypeService.update(id, accountType);
		return ResponseEntity.ok(AccountTypeMapper.INSTANCE.toAccountTypeDTO(accountTypeUpdated));
	}

	@GetMapping
	public ResponseEntity<?> gets(@RequestParam Map<String, String> params) {
		List<AccountType> accountTypes = accountTypeService.gets(params);
		List<AccountTypeDTO> accountTypesDTO = accountTypes
				.stream()
				.map(accountType -> AccountTypeMapper.INSTANCE.toAccountTypeDTO(accountType))
				.collect(Collectors.toList());
		return ResponseEntity.ok(accountTypesDTO);
	}
}
