package com.vanndeth.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException {

	public <T> ResourceNotFoundException(String resource, T id) {
		super(HttpStatus.NOT_FOUND, resource + " with id " + id + " not found...!");
	}

}
