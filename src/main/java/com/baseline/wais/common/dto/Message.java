package com.baseline.wais.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

	private String code;
	
	private String shortMessage;
	
	private String longMessage;
	
	private String type;
}
