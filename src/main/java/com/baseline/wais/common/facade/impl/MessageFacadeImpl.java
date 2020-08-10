package com.baseline.wais.common.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baseline.wais.common.constant.BusinessConstant;
import com.baseline.wais.common.dto.Message;
import com.baseline.wais.common.dto.response.VoidResponse;
import com.baseline.wais.common.facade.MessageFacade;
import com.baseline.wais.common.service.MessageService;

@Component
public class MessageFacadeImpl implements MessageFacade {

	@Autowired
	private MessageService messageService;

	@Override
	public String getShortMessage(String code) {
		return messageService.getShortMessage(code);
	}

	@Override
	public String getLongMessage(String code) {
		return messageService.getLongMessage(code);
	}

	@Override
	public Message findByCode(String code) {
		return messageService.findByCode(code);
	}

	@Override
	public List<Message> findAll() {
		return messageService.findAll();
	}

	@Override
	public VoidResponse save(Message message) {
		messageService.save(message);
		return new VoidResponse(
				String.format(
						getShortMessage(BusinessConstant.SUCCESS_0001)
						, "Message"));
	}

}
