package com.softtek.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.modelo.ConsultaExamen;
import com.softtek.repo.IConsultaExamenRepo;
import com.softtek.servicio.IConsultaExamenServicio;

@Service
public class ConsultaExamenServicioImpl implements IConsultaExamenServicio {

	@Autowired
	private IConsultaExamenRepo repo;

	@Override
	public List<ConsultaExamen> listarExamenesPorConsulta(Integer idconsulta) {
		return repo.listarExamenesPorConsulta(idconsulta);
	}
}
