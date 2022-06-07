package com.softtek.dto;

import javax.validation.constraints.NotNull;

public class ConsultaResumenDTO {

	private Integer cantidad;

	@NotNull
	private String fecha;

	public ConsultaResumenDTO(Integer cantidad, @NotNull String fecha) {
		super();
		this.cantidad = cantidad;
		this.fecha = fecha;
	}

	public ConsultaResumenDTO() {
		super();
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "ConsultaDTO [cantidad=" + cantidad + ", fecha=" + fecha + "]";
	}

}
