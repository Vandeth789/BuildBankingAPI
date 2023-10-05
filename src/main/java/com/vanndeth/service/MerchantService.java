package com.vanndeth.service;

import java.util.List;

import com.vanndeth.entity.Merchant;

public interface MerchantService {
	Merchant create(Merchant merchant);
	Merchant getById(Long id);
	List<Merchant> get();

}
