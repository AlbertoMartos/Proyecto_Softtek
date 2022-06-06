package com.softtek.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.modelo.Menu;
import com.softtek.repo.IGenericRepo;
import com.softtek.repo.IMenuRepo;
import com.softtek.servicio.IMenuServicio;

@Service
public class MenuServicioImpl extends CRUDImpl<Menu, Integer> implements IMenuServicio {

	@Autowired
	private IMenuRepo repo;

	@Override
	public List<Menu> listarMenuPorUsuario(String nombre) {
		// TODO Auto-generated method stub
		return repo.listarMenuPorUsuario(nombre);
	}

	@Override
	protected IGenericRepo<Menu, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

}
