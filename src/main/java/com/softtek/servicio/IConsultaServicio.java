package com.softtek.servicio;

import java.util.List;

import com.softtek.dto.ConsultaResumenDTO;
import com.softtek.modelo.Analitica;
import com.softtek.modelo.Consulta;

public interface IConsultaServicio extends ICRUD<Consulta, Integer> {

	Consulta registrarTransaccional(Consulta consulta, List<Analitica> examenes) throws Exception;

	List<ConsultaResumenDTO> listarResumen();

	byte[] generarReporte();
}
