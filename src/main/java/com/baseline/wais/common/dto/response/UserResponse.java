package com.baseline.wais.common.dto.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse implements Serializable {
	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String address;
	
	private String gender;
}
