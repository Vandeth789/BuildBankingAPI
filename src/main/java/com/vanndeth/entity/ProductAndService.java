package com.vanndeth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class ProductAndService {
	@Id
	private String productAndServicesCode;
	private String productsAndServicesDescription;
	
	@ManyToOne
	@JoinColumn(name = "merchant_id")
	private Merchant merchantId;
}
