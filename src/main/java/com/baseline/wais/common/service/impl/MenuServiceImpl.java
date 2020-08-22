package com.baseline.wais.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baseline.wais.common.dto.SubMenu;
import com.baseline.wais.common.dto.response.MenuResponse;
import com.baseline.wais.common.entity.MenuEntity;
import com.baseline.wais.common.entity.SubMenuEntity;
import com.baseline.wais.common.repository.MenuRepository;
import com.baseline.wais.common.service.MenuService;
import com.baseline.wais.common.util.ObjectUtil;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Override
	public List<MenuResponse> listofMenu() {
		List<MenuEntity> listOfMenu = menuRepository.findAll();

		List<MenuResponse> menuResponseList = new ArrayList<>();
		for (MenuEntity menuEntity : listOfMenu) {

			MenuResponse menuResponse = new MenuResponse();
			menuResponse.setName(menuEntity.getName());
			menuResponse.setPath(menuEntity.getPath());

			List<SubMenu> subMenuList = new ArrayList<>();
			for (SubMenuEntity subMenuEntity : menuEntity.getSubmenu()) {
				SubMenu subMenu = new SubMenu();
				subMenu.setName(subMenuEntity.getName());
				subMenu.setPath(subMenuEntity.getPath());
				
				subMenuList.add(subMenu);
			}
			
			menuResponse.setSubmenu(subMenuList);
			
			menuResponseList.add(menuResponse);

		}

		return menuResponseList;
	}

	@Override
	public void save(MenuResponse menuResponse) {
		MenuEntity menuEntity = new MenuEntity();
		menuEntity.setName(menuResponse.getName());
		menuEntity.setPath(menuResponse.getPath());
		
		List<SubMenuEntity> subMenuEntityList = new ArrayList<>();
//		for (SubMenu subMenu : menuResponse.getSubmenu()) {
//			SubMenuEntity subMenuEntity = new SubMenuEntity();
//			subMenuEntity.setName(subMenu.getName());
//			subMenuEntity.setPath(subMenu.getPath());
//			subMenuEntityList.add(subMenuEntity);
//		}
		
		
		ObjectUtil.mapObject(menuResponse.getSubmenu(), subMenuEntityList);

		menuEntity.setSubmenu(subMenuEntityList);
		menuRepository.save(menuEntity);
	}
	

}
