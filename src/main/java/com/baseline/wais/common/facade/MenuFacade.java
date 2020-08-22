package com.baseline.wais.common.facade;

import java.util.List;

import com.baseline.wais.common.dto.response.MenuResponse;

public interface MenuFacade {
	
	List<MenuResponse> listOfMenu();

	void save(MenuResponse menuResponse);
}
