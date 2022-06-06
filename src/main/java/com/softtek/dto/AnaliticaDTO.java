package com.softtek.dto;

import javax.validation.constraints.NotNull;

public class AnaliticaDTO {

	private Integer idAnalitica;

	@NotNull
	private String descripcion;

	@NotNull
	private String nombre;

	public AnaliticaDTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AnaliticaDTO [idAnalitica=" + idAnalitica + ", descripcion=" + descripcion + ", nombre=" + nombre + "]";
	}

	public Integer getIdAnalitica() {
		return idAnalitica;
	}

	public void setIdAnalitica(Integer idAnalitica) {
		this.idAnalitica = idAnalitica;
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
