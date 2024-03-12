package com.baseline.wais.common.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.baseline.wais.common.constant.BusinessConstant;
import com.baseline.wais.common.dto.request.UserRequest;
import com.baseline.wais.common.dto.response.UserResponse;
import com.baseline.wais.common.entity.LoginEntity;
import com.baseline.wais.common.entity.UserEntity;
import com.baseline.wais.common.exception.BusinessFailureException;
import com.baseline.wais.common.repository.UserRepository;
import com.baseline.wais.common.service.UserService;
import com.baseline.wais.common.util.ObjectUtil;
import com.baseline.wais.common.util.StringUtil;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger lOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<UserResponse> findAll() {
		List<UserResponse> users = new ArrayList<>();
		
		if(!CollectionUtils.isEmpty((Collection<?>) userRepository.findAll())) {
			for(UserEntity userEntity : userRepository.findAll()) {
				UserResponse user = new UserResponse();
				ObjectUtil.mapObject(userEntity, user);
				users.add(user);
			}
		} else {
			String errMsg = "";
			lOGGER.error(errMsg);
			throw new BusinessFailureException(errMsg, HttpStatus.NOT_FOUND);
		}
		
		return users;
	}

	@Override
	public void save(UserRequest user) {
		UserEntity userEntity = new UserEntity();
		ObjectUtil.mapObject(user, userEntity);
		
		LoginEntity loginEntity = new LoginEntity();
		loginEntity.setUsername(user.getUsername());
		loginEntity.setPassword(StringUtil.bCryptPassword(user.getPassword()));
		userEntity.setLoginCredentials(loginEntity);
		
		try {
			userRepository.save(userEntity);
		} catch(Exception ex) {
			throw new BusinessFailureException(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}

	@Override
	public UserResponse findById(Integer id) {
		UserResponse user = null;
		Optional<?> optional = userRepository.findById(null);
		if(optional.isPresent()) {
			UserEntity userEntity = (UserEntity)optional.get();
			user = new UserResponse();
			ObjectUtil.mapObject(userEntity, user);
		}
		return user;
	}

	@Override
	public void delete(Integer id) {
		userRepository.deleteById(null);
	}
}
