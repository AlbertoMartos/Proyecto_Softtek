package com.softtek.servicio.impl;

import java.util.List;
import java.util.Optional;

import com.softtek.repo.IGenericRepo;

public abstract class CRUDImpl<T, ID> {

	protected abstract IGenericRepo<T, ID> getRepo();

	public T registrar(T t) throws Exception {
		return getRepo().save(t);
	}

	public T modificar(T t) throws Exception {
		return getRepo().save(t);
	}

	public List<T> listar() throws Exception {
		// TODO Auto-generated method stub
		return getRepo().findAll();
	}

	public T listarPorId(ID id) throws Exception {
		// TODO Auto-generated method stub
		Optional<T> t1 = getRepo().findById(id);
		return t1.isPresent() ? t1.get() : null;
	}

	public void eliminar(ID id) throws Exception {
		// TODO Auto-generated method stub
		getRepo().deleteById(id);
	}
}
