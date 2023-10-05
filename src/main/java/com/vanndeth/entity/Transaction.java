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
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	private LocalDateTime date;
	private Long amountOfTransaction;
	private String otherDetails;
	
	@ManyToOne
	@JoinColumn(name = "purchase_id")
	private CustomerPurchase purchaseId;
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account accountId;
	
	@ManyToOne
	@JoinColumn(name = "transaction_types_code")
	private TransactionType transactionTypesCode;
}
