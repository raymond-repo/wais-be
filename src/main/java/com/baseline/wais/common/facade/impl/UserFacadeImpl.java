package com.baseline.wais.common.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baseline.wais.common.constant.BusinessConstant;
import com.baseline.wais.common.dto.request.UserRequest;
import com.baseline.wais.common.dto.response.CommonResponse;
import com.baseline.wais.common.dto.response.UserResponse;
import com.baseline.wais.common.facade.UserFacade;
import com.baseline.wais.common.service.MessageService;
import com.baseline.wais.common.service.UserService;

@Component
public class UserFacadeImpl implements UserFacade {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageService messageService;

	@Override
	public List<UserResponse> findAll() {
		return userService.findAll();
	}

	@Override
	public UserResponse findById(Integer id) {
		return userService.findById(id);
	}

	@Override
	public CommonResponse save(UserRequest userEntity) {
		
		userService.save(userEntity);
		
		return new CommonResponse("Successfuly Created");
	}

	@Override
	public CommonResponse delete(Integer id) {
		userService.delete(id);
		return new CommonResponse(messageService.getShortMessage(BusinessConstant.SUCCESS_0002));
	}
}
