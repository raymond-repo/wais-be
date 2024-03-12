package com.baseline.wais.common.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document(collection = "User_Details")
public class UserEntity implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ObjectId id;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String email;
	
	private String address;
	
	private String gender;
	
	private String status;
	
	private String role;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private LoginEntity loginCredentials;

}
