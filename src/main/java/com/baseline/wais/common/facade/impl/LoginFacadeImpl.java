package com.baseline.wais.common.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.baseline.wais.common.dto.request.LoginRequest;
import com.baseline.wais.common.dto.response.LoginResponse;
import com.baseline.wais.common.exception.BusinessFailureException;
import com.baseline.wais.common.facade.LoginFacade;
import com.baseline.wais.common.service.AuthorizationService;

@Component
public class LoginFacadeImpl implements LoginFacade {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AuthorizationService authorizationService;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public LoginResponse authinticateLogin(LoginRequest loginRequest) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new BusinessFailureException(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());

		return new LoginResponse(authorizationService.generateToken(userDetails));
	}

}
