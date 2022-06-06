package com.softtek.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.modelo.Especialidad;
import com.softtek.repo.IEspecialidadRepo;
import com.softtek.repo.IGenericRepo;
import com.softtek.servicio.IEspecialidadServicio;

@Service
public class EspecialidadServicioImpl extends CRUDImpl<Especialidad, Integer> implements IEspecialidadServicio {

	@Autowired
	private IEspecialidadRepo repo;

	@Override
	protected IGenericRepo<Especialidad, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

}
