package com.vanndeth.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class CustomerPurchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long purchaseId;
	private LocalDateTime date;
	private Long quantity;
	private String otherDetail;
	
	@ManyToOne
	@JoinColumn(name = "customers_id")
	private Customer customersId;
	
	@ManyToOne
	@JoinColumn(name = "product_and_services_code")
	private  ProductAndService productAndServicesCode;
}
