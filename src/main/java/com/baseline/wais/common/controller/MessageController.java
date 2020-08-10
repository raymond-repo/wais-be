package com.baseline.wais.common.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baseline.wais.common.dto.Message;
import com.baseline.wais.common.dto.response.VoidResponse;
import com.baseline.wais.common.facade.MessageFacade;

@RestController
@RequestMapping("message")
public class MessageController {
	
	@Autowired
	public MessageFacade messageFacade;
	
	@GetMapping("/findAll")
	public List<Message> findAll() {
		return messageFacade.findAll();
	}
	
	@GetMapping("/findByCode")
	public Message findByCode(@RequestParam String code) {
		return messageFacade.findByCode(code);
	}
	
	@PostMapping("/save")
	public VoidResponse save(@RequestBody @Valid Message message, Errors errors) {
		return messageFacade.save(message);
	}
}
