package com.vanndeth.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CustomerDTO {
	private String customersName;
	private Long customersPhone;
	private String customersEmail;
	private LocalDateTime dateBecameCustomer;
	private String login;
	private String password;
	private String otherDetails;
	
	private String customerTypesCode;
}
