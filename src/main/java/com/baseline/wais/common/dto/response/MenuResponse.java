package com.baseline.wais.common.dto.response;

import java.io.Serializable;
import java.util.List;

import com.baseline.wais.common.dto.SubMenu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuResponse implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String path;
	
	private List<SubMenu> submenu;

}
