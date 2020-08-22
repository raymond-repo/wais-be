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

import com.baseline.wais.common.dto.response.CommonResponse;
import com.baseline.wais.common.util.DateTimeUtil;

@RestControllerAdvice
public class BusinessFailureExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<Object> handleBusinessFailureException(BusinessFailureException invalidFieldException) {

		CommonResponse errResponse = new CommonResponse();
		errResponse.setTimestamp(DateTimeUtil.getCurrentDateTime());
		errResponse.setMessage(invalidFieldException.getMessage());
	
		return new ResponseEntity<>(errResponse, invalidFieldException.getStatus());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> errors = new LinkedHashMap<>();
		ex.getBindingResult().getFieldErrors().stream().forEach(x -> {
			errors.put(x.getField(), x.getDefaultMessage());
		});

		CommonResponse errResponse = new CommonResponse();
		errResponse.setTimestamp(DateTimeUtil.getCurrentDateTime());
		errResponse.setMessage(errors);

		return new ResponseEntity<>(errResponse, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		CommonResponse errResponse = new CommonResponse();
		errResponse.setTimestamp(DateTimeUtil.getCurrentDateTime());
		errResponse.setMessage(ex.getMessage());
		
		return new ResponseEntity<>(errResponse, HttpStatus.METHOD_NOT_ALLOWED);
	}
}
