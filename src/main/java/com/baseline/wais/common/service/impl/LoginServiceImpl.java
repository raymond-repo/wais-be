package com.baseline.wais.common.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.baseline.wais.common.entity.LoginEntity;
import com.baseline.wais.common.exception.BusinessFailureException;
import com.baseline.wais.common.repository.LoginRepository;
import com.baseline.wais.common.util.ObjectUtil;
import com.baseline.wais.common.util.StringUtil;

@Service
public class LoginServiceImpl implements UserDetailsService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		LoginEntity loginEntity = loginRepository.findByUsername(username);
		
		String password = "";
		
		if (ObjectUtil.isNull(loginEntity)) {
			
			if(StringUtil.isNotEqualIgnoreCase(username, "Admin")) {
				throw new BusinessFailureException(username + " not found", HttpStatus.NOT_FOUND);
			} else {
				password = StringUtil.bCryptPassword(username);
				
			}
		} else {
			password = loginEntity.getPassword();
		}
		
		return new User(username, password, new ArrayList<>());
	}
}
