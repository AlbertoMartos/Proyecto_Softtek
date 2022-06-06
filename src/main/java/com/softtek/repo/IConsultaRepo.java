package com.softtek.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.softtek.modelo.Consulta;

public interface IConsultaRepo extends IGenericRepo<Consulta, Integer> {

	@Query(value = "select * from consultaAgrupadasFecha()", nativeQuery = true)
	List<Object[]> getConsultas();

}
