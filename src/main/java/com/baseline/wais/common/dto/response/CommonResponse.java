package com.baseline.wais.common.dto.response;

import java.io.Serializable;

import com.baseline.wais.common.util.DateTimeUtil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse implements Serializable {
	
	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	private String timestamp;
	
	private Object message;
	
	public CommonResponse(String message) {
		this.timestamp = DateTimeUtil.getCurrentDateTime();
		this.message = message;
	}
}
