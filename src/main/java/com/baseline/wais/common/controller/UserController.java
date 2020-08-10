package com.baseline.wais.common.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baseline.wais.common.dto.request.UserRequest;
import com.baseline.wais.common.dto.response.UserResponse;
import com.baseline.wais.common.dto.response.VoidResponse;
import com.baseline.wais.common.facade.UserFacade;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserFacade userFacade;
	
	@GetMapping("/findAll")
	public List<UserResponse> findAll() {
		return userFacade.findAll();
	}
	
	@GetMapping("/findById")
	public UserResponse findById(@RequestParam Integer id) {
		return userFacade.findById(id);
	}
	
	@PostMapping("/save")
	public VoidResponse save(@RequestBody @Valid UserRequest user) {
		return userFacade.save(user);
	}
	
	@DeleteMapping("/delete")
	public VoidResponse delete(@RequestParam Integer id) {
		return userFacade.delete(id);
	}
}
