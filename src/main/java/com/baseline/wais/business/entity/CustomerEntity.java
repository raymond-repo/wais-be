package com.baseline.wais.business.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="T_CUSTOMER")
public class CustomerEntity implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String fullname;
	
	private String email;
	
	private String gender;
	
	private String telno;
}
