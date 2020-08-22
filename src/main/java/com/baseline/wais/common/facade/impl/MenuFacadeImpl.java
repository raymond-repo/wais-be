package com.baseline.wais.common.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baseline.wais.common.dto.response.MenuResponse;
import com.baseline.wais.common.facade.MenuFacade;
import com.baseline.wais.common.service.MenuService;

@Component
public class MenuFacadeImpl implements MenuFacade {
	
	@Autowired
	private MenuService menuService;

	@Override
	public List<MenuResponse> listOfMenu() {
		return menuService.listofMenu();
	}

	@Override
	public void save(MenuResponse menuResponse) {
		menuService.save(menuResponse);
	}

}
