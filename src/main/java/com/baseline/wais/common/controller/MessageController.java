package com.baseline.wais.common.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.baseline.wais.base.controller.AbstractWaisController;
import com.baseline.wais.common.dto.MessageResponse;
import com.baseline.wais.common.dto.ResponseHandler;
import com.baseline.wais.common.facade.MessageFacade;

@RequestMapping("message")
public class MessageController extends AbstractWaisController {
	
	@Autowired
	public MessageFacade messageFacade;
	
	@GetMapping("/findAll")
	public ResponseHandler findAll() {
		return new ResponseHandler(messageFacade.findAll());
	}
	
	@GetMapping("/findByCode")
	public ResponseHandler findByCode(@RequestParam String code) {
		return new ResponseHandler(messageFacade.findByCode(code));
	}
	
	@PostMapping("/save")
	public ResponseHandler save(@RequestBody @Valid MessageResponse message, Errors errors) {
		return new ResponseHandler(messageFacade.save(message));
	}
}
