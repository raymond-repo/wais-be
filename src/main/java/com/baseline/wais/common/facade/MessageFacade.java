package com.baseline.wais.common.facade;

import java.util.List;

import com.baseline.wais.common.dto.MessageResponse;
import com.baseline.wais.common.dto.response.CommonResponse;

public interface MessageFacade {

	String getShortMessage(String code);
	
	String getLongMessage(String code);
	
	MessageResponse findByCode(String code);

	List<MessageResponse> findAll();

	CommonResponse save(MessageResponse message);
}
