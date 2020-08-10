package com.baseline.wais.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baseline.wais.common.dto.request.LoginRequest;
import com.baseline.wais.common.dto.response.LoginResponse;
import com.baseline.wais.common.facade.LoginFacade;

@RestController
@RequestMapping
public class LoginController {

	@Autowired
	private LoginFacade loginFacade;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
		LoginResponse loginResponse = loginFacade.authinticateLogin(loginRequest);
		
		return ResponseEntity.ok(loginResponse);
	}
}
