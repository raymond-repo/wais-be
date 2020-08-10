package com.baseline.wais.common.dto.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	private String username;
	
	private String password;
}
