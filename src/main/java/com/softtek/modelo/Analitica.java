package com.softtek.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "analiticas")
public class Analitica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAnalitica;

	@Column(name = "descripcion", nullable = true, length = 150)
	private String descripcion;

	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	public Analitica() {
		// TODO Auto-generated constructor stub
	}

	public Analitica(Integer idAnalitica, String descripcion, String nombre) {
		super();
		this.idAnalitica = idAnalitica;
		this.descripcion = descripcion;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Analitica [idAnalitica=" + idAnalitica + ", descripcion=" + descripcion + ", nombre=" + nombre + "]";
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
