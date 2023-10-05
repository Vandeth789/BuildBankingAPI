package com.vanndeth.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ApiException extends RuntimeException{
	private final HttpStatus httpStatus;
	private final String message;
}
