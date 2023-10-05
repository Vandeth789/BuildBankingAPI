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
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	private String accountsName;
	private LocalDateTime dateOpened;
	private String otherAccountDetails;
	
	@ManyToOne
	@JoinColumn(name = "account_types_code")
	private AccountType accountTypesCode;
	
	@ManyToOne
	@JoinColumn(name = "customers_id")
	private Customer customersId;
}
