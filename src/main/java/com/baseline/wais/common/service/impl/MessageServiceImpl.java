package com.baseline.wais.common.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.baseline.wais.common.dto.MessageResponse;
import com.baseline.wais.common.entity.MessageEntity;
import com.baseline.wais.common.exception.BusinessFailureException;
import com.baseline.wais.common.repository.MessageRepository;
import com.baseline.wais.common.service.MessageService;
import com.baseline.wais.common.util.ObjectUtil;
import com.baseline.wais.common.util.StringUtil;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Override
	public MessageResponse findByCode(String code) {

		Optional<MessageEntity> optional = messageRepository.findById(code);
		MessageResponse message = null;
		if (optional.isPresent()) {
			MessageEntity messageEntity = optional.get();
			message = new MessageResponse();
			ObjectUtil.mapObject(messageEntity, message);
		}
		return message;
	}

	@Override
	public String getShortMessage(String code) {

		String shortMessage = messageRepository.getShortMessageByCode(code);

		if (StringUtil.isNull(shortMessage)) {
			throw new BusinessFailureException(StringUtil.concat("Short message for ", code, " not found"), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return shortMessage;
	}

	@Override
	public String getLongMessage(String code) {
		String longMessage = messageRepository.getLongMessageByCode(code);

		if (StringUtil.isNull(longMessage)) {
			
			throw new BusinessFailureException(StringUtil.concat("Long message for ", code, "not found"), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return longMessage;
	}

	@Override
	public List<MessageResponse> findAll() {
		Iterable<MessageEntity> messageEntities = messageRepository.findAll();

		List<MessageResponse> messages = new ArrayList<>();
		for (MessageEntity messageEntity : messageEntities) {
			MessageResponse message = new MessageResponse();
			BeanUtils.copyProperties(messageEntity, message);
			messages.add(message);
		}

		return messages;
	}

	@Override
	public void save(MessageResponse message) {
		MessageEntity messageEntity = new MessageEntity();
		BeanUtils.copyProperties(message, messageEntity);
		messageRepository.save(messageEntity);
	}

}
