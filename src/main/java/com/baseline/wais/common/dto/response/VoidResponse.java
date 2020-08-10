package com.baseline.wais.common.dto.response;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import com.baseline.wais.common.util.DateTimeUtil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoidResponse implements Serializable {
	
	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	private String timestamp;
	
	private String message;
	
	private HttpStatus status;
	
	public VoidResponse(String message) {
		this.timestamp = DateTimeUtil.getCurrentDateTime();
		this.message = message;
		this.status = HttpStatus.OK;
	}
}
