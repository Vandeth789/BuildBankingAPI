package com.vanndeth.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.vanndeth.account.repo.MerchantRepo;
import com.vanndeth.entity.Merchant;
import com.vanndeth.service.MerchantService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MerchantServiceImpl implements MerchantService {

	private final MerchantRepo merchantRepo;

	@Override
	public Merchant create(Merchant merchant) {
		return merchantRepo.save(merchant);
	}

	@Override
	public Merchant getById(Long id) {
		return merchantRepo.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, String.format("Merchant with id %d not found...!", id)));
	}

	@Override
	public List<Merchant> get() {
		List<Merchant> merchants = merchantRepo.findAll();
		return merchants;
	}
	

}
