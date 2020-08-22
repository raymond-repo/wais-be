package com.baseline.wais.common.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseHandler implements Serializable {
	
	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	private String status;

	private Object result;

	public ResponseHandler(Object result) {
		this.status = "SUCCESS";
		this.result = result;
	}
}
