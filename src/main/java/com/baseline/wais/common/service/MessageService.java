package com.baseline.wais.common.service;

import java.util.List;

import com.baseline.wais.common.dto.MessageResponse;

public interface MessageService {

	String getShortMessage(String code);

	String getLongMessage(String code);

	MessageResponse findByCode(String code);

	List<MessageResponse> findAll();

	void save(MessageResponse message);
}
