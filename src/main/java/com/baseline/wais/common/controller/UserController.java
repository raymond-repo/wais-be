package com.baseline.wais.common.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baseline.wais.base.controller.AbstractWaisController;
import com.baseline.wais.common.dto.ResponseHandler;
import com.baseline.wais.common.dto.request.UserRequest;
import com.baseline.wais.common.facade.UserFacade;

@RestController
@RequestMapping("user")
public class UserController extends AbstractWaisController {

	@Autowired
	private UserFacade userFacade;
	
	@GetMapping("/findAll")
	public ResponseHandler findAll() {
		return new ResponseHandler(userFacade.findAll());
	}
	
	@GetMapping("/findById")
	public ResponseHandler findById(@RequestParam Integer id) {
		return new ResponseHandler(userFacade.findById(id));
	}
	
	@PostMapping("/save")
	public ResponseHandler save(@RequestBody @Valid UserRequest user) {
		return new ResponseHandler(userFacade.save(user));
	}
	
	@DeleteMapping("/delete")
	public ResponseHandler delete(@RequestParam Integer id) {
		return new ResponseHandler(userFacade.delete(id));
	}
}
