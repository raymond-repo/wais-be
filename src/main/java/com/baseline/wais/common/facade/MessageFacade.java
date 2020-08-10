package com.baseline.wais.common.facade;

import java.util.List;

import com.baseline.wais.common.dto.Message;
import com.baseline.wais.common.dto.response.VoidResponse;

public interface MessageFacade {

	String getShortMessage(String code);
	
	String getLongMessage(String code);
	
	Message findByCode(String code);

	List<Message> findAll();

	VoidResponse save(Message message);
}
