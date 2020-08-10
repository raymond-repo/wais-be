package com.baseline.wais.common.facade;

import java.util.List;

import com.baseline.wais.common.dto.request.UserRequest;
import com.baseline.wais.common.dto.response.UserResponse;
import com.baseline.wais.common.dto.response.VoidResponse;

public interface UserFacade {
	
	List<UserResponse> findAll();
	
	UserResponse findById(Integer id);
	
	VoidResponse save(UserRequest userEntity);
	
	VoidResponse delete(Integer id);
}
