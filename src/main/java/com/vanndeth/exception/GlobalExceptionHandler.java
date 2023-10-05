package com.vanndeth.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<?> handlerApiException(ApiException e) {
		ErrorResponse errorResponse = new ErrorResponse(e.getHttpStatus(), e.getMessage());
		return ResponseEntity
				.status(e.getHttpStatus())
				.body(errorResponse);
	}

}
