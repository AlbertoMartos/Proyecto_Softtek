package com.softtek.servicio;

import java.util.List;

import com.softtek.modelo.ConsultaExamen;

public interface IConsultaExamenServicio {

	List<ConsultaExamen> listarExamenesPorConsulta(Integer idconsulta);
}
