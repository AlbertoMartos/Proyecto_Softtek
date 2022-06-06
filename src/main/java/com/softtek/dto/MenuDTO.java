package com.softtek.dto;

import java.util.List;

public class MenuDTO {

	private Integer IdMenu;
	private String icono;
	private String nombre;
	private String url;
	private List<RolDTO> roles;

	public MenuDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdMenu() {
		return IdMenu;
	}

	public void setIdMenu(Integer idMenu) {
		IdMenu = idMenu;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<RolDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<RolDTO> roles) {
		this.roles = roles;
	}

}
