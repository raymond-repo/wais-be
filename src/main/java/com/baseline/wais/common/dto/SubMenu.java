package com.baseline.wais.common.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubMenu implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String path;

}
