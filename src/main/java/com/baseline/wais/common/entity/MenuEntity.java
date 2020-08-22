package com.baseline.wais.common.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="T_MENU")
public class MenuEntity implements Serializable {
	
	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String path;
	
	@OneToMany(targetEntity = SubMenuEntity.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "menu_id", referencedColumnName = "id")
	private List<SubMenuEntity> submenu;

}
