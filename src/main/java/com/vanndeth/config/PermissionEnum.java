package com.vanndeth.config;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PermissionEnum {
	ACCOUNT_WRITE("account:write"),
	ACCOUNT_READ("account:read"),
	CUSTOMER_WRITE("customer:write"),
	CUSTOMER_READ("customer:read");
	private String description;
	
	
	/*
	private PermissionEnum(String description) {
		this.description = description;
	}
	*/

}
