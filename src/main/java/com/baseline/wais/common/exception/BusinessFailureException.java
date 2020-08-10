package com.baseline.wais.common.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BusinessFailureException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private final String message;
	
	private final HttpStatus status;
}
