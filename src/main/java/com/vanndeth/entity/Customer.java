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
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customersId;
	private String customersName;
	private Long customersPhone;
	private String customersEmail;
	private LocalDateTime dateBecameCustomer;
	private String login;
	private String password;
	private String otherDetails;
	
	@ManyToOne
	@JoinColumn(name = "customer_types_code")
	private CustomerType customerTypesCode;
	
}
