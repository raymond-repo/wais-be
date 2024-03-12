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
	
	private String id;

	@NotBlank
	private String firstName;
	
	@NotBlank
	private String middleName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private String gender;
	
	@NotBlank
	private String role;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;

}
