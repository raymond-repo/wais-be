package com.baseline.wais.common.facade;

import java.util.List;

import com.baseline.wais.common.dto.request.UserRequest;
import com.baseline.wais.common.dto.response.UserResponse;
import com.baseline.wais.common.dto.response.CommonResponse;

public interface UserFacade {
	
	List<UserResponse> findAll();
	
	UserResponse findById(Integer id);
	
	CommonResponse save(UserRequest userEntity);
	
	CommonResponse delete(Integer id);
}
