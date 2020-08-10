package com.baseline.wais.common.service;

import java.util.List;

import com.baseline.wais.common.dto.request.UserRequest;
import com.baseline.wais.common.dto.response.UserResponse;

public interface UserService {

	List<UserResponse> findAll();
	
	UserResponse findById(Integer id);
	
	void save(UserRequest userEntity);
	
	void delete(Integer id);
}
