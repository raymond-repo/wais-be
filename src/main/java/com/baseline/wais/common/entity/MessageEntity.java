package com.baseline.wais.common.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="message")
public class MessageEntity implements Serializable {
	
	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	@Id
	private String code;
	
	private String shortMessage;
	
	private String longMessage;
	
	private String type;

}
