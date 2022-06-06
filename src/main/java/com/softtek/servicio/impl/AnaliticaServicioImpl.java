package com.softtek.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.modelo.Analitica;
import com.softtek.repo.IAnaliticaRepo;
import com.softtek.repo.IGenericRepo;
import com.softtek.servicio.IAnaliticaServicio;

@Service
public class AnaliticaServicioImpl extends CRUDImpl<Analitica, Integer> implements IAnaliticaServicio {

	@Autowired
	private IAnaliticaRepo repo;

	@Override
	protected IGenericRepo<Analitica, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

}
