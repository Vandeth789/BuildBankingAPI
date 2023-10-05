package com.vanndeth.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vanndeth.entity.Merchant;
import com.vanndeth.service.MerchantService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/merchants")
@RequiredArgsConstructor
@RestController
public class MerchantController {


	private final MerchantService merchantService;
	
	@PostMapping("/")
	public ResponseEntity<?> createMerchant(@RequestBody Merchant merchant) {
		Merchant newMerchant = merchantService.create(merchant);
		return ResponseEntity.ok(newMerchant);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getMerchantById(@PathVariable("id") Long id){
		Merchant merchantId = merchantService.getById(id);
		return ResponseEntity.ok(merchantId);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<?> getAllMerchant(){
		List<Merchant> merchants = merchantService.get();
		return ResponseEntity.ok(merchants);
	}
}
