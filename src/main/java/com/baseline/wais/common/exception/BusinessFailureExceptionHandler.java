package com.baseline.wais.common.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.baseline.wais.common.dto.response.ErrorResponse;
import com.baseline.wais.common.util.DateTimeUtil;

@RestControllerAdvice
public class BusinessFailureExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<Object> handleNullPointerException(BusinessFailureException invalidFieldException) {

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setTimestamp(DateTimeUtil.getCurrentDateTime());
		errorResponse.setError(invalidFieldException.getMessage());
		errorResponse.setStatus(invalidFieldException.getStatus());
	
		return new ResponseEntity<>(errorResponse, invalidFieldException.getStatus());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> errors = new LinkedHashMap<>();
		ex.getBindingResult().getFieldErrors().stream().forEach(x -> {
			errors.put(x.getField(), x.getDefaultMessage());
		});

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setTimestamp(DateTimeUtil.getCurrentDateTime());
		errorResponse.setError(errors);
		errorResponse.setStatus(status.value());

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setTimestamp(DateTimeUtil.getCurrentDateTime());
		errorResponse.setError(ex.getMessage());
		errorResponse.setStatus(status.value());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.METHOD_NOT_ALLOWED);
	}
}
