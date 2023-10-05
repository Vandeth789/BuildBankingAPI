package com.vanndeth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class AccountType {
	@Id
	private String accountTypesCode;
	private String accountTypesDescription;	
}
