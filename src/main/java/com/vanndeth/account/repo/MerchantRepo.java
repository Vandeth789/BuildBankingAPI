package com.vanndeth.account.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vanndeth.entity.Merchant;

public interface MerchantRepo extends JpaRepository<Merchant, Long>{

}
