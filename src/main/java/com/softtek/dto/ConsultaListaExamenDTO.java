package com.softtek.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

public class ConsultaListaExamenDTO {

	@NotNull
	private ConsultaResumenDTO consulta;

	@NotNull
	private List<AnaliticaDTO> lstExamen;

	public ConsultaResumenDTO getConsulta() {
		return consulta;
	}

	public void setConsulta(ConsultaResumenDTO consulta) {
		this.consulta = consulta;
	}

	public List<AnaliticaDTO> getLstExamen() {
		return lstExamen;
	}

	public void setLstExamen(List<AnaliticaDTO> lstExamen) {
		this.lstExamen = lstExamen;
	}

	@Override
	public String toString() {
		return "ConsultaListaExamenDTO [consulta=" + consulta + ", lstExamen=" + lstExamen + "]";
	}

}
