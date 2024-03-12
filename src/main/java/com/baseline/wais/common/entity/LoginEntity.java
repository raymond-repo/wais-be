package com.baseline.wais.common.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Document(collection = "Login_Credentials")
public class LoginEntity implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ObjectId id;
	
	private String username;
	
	private String password;
	
}
