package com.baseline.wais.common.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baseline.wais.common.constant.BusinessConstant;
import com.baseline.wais.common.dto.MessageResponse;
import com.baseline.wais.common.dto.response.CommonResponse;
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
	public MessageResponse findByCode(String code) {
		return messageService.findByCode(code);
	}

	@Override
	public List<MessageResponse> findAll() {
		return messageService.findAll();
	}

	@Override
	public CommonResponse save(MessageResponse message) {
		messageService.save(message);
		return new CommonResponse(
				String.format(
						getShortMessage(BusinessConstant.SUCCESS_0001)
						, "Message"));
	}

}
