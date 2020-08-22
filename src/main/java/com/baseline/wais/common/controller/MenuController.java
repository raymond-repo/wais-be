package com.baseline.wais.common.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baseline.wais.common.dto.ResponseHandler;
import com.baseline.wais.common.dto.response.MenuResponse;
import com.baseline.wais.common.facade.MenuFacade;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	public MenuFacade menuFacade;
	
	@GetMapping("/findAll")
	public ResponseHandler findAll() {
		return new ResponseHandler(menuFacade.listOfMenu());
	}
	
	@PostMapping("/save")
	public ResponseHandler save(@RequestBody @Valid MenuResponse menu) {
		menuFacade.save(menu);
		return new ResponseHandler(null);
	}
}
