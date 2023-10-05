package com.vanndeth.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AccountDTO {
	private String accountsName;
	private LocalDateTime dateOpened;
	private String otherAccountDetails; 
	
	private String accountTypesCode;
	private Long customersId;
	
}
