package com.baseline.wais.business.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baseline.wais.base.controller.AbstractWaisController;
import com.baseline.wais.common.dto.ResponseHandler;
import com.baseline.wais.common.dto.request.LoginRequest;

@RequestMapping("customer")
public class CustomerController extends AbstractWaisController {
	
	@PostMapping("/login")
	public ResponseHandler login(@RequestBody LoginRequest loginRequest) {
		
		return new ResponseHandler(null);
	}
}