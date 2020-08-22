package com.baseline.wais.common.service;

import java.util.List;

import com.baseline.wais.common.dto.response.MenuResponse;

public interface MenuService {
	
	List<MenuResponse> listofMenu();
	
	void save(MenuResponse menuResponse);
}
