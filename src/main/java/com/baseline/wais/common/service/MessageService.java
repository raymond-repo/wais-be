package com.baseline.wais.common.service;

import java.util.List;

import com.baseline.wais.common.dto.Message;

public interface MessageService {

	String getShortMessage(String code);

	String getLongMessage(String code);

	Message findByCode(String code);

	List<Message> findAll();

	void save(Message message);
}
