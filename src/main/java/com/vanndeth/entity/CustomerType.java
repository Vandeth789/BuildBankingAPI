package com.vanndeth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class CustomerType {
	@Id
	private String customerTypesCode;
	private String customerTypesDescription;
	
}
