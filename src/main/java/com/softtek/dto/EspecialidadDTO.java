package com.softtek.dto;

import javax.validation.constraints.NotNull;

public class EspecialidadDTO {

	private Integer idEspecialidad;

	@NotNull
	private String descripcion;

	@NotNull
	private String nombre;

	public EspecialidadDTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EspecialidadDTO [idEspecialidad=" + idEspecialidad + ", descripcion=" + descripcion + ", nombre="
				+ nombre + "]";
	}

	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
