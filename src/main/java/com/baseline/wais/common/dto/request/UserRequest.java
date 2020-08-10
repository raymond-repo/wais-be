package com.baseline.wais.common.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String address;
	
	private String gender;
	
	private String username;
	
	private String password;

}
