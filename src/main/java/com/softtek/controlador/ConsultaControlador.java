package com.softtek.controlador;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softtek.dto.ConsultaDTO;
import com.softtek.dto.ConsultaListaExamenDTO;
import com.softtek.dto.ConsultaResumenDTO;
import com.softtek.modelo.Analitica;
import com.softtek.modelo.Consulta;
import com.softtek.servicio.impl.ConsultaServicioImpl;

@RestController
@RequestMapping("/consultas")
//@CrossOrigin(origins = "http://localhost:4200")

public class ConsultaControlador {
	@Autowired
	private ConsultaServicioImpl servicio;

	@Autowired
	private ModelMapper mapper;

	@GetMapping(value = "/listarResumen")
	public ResponseEntity<List<ConsultaResumenDTO>> listar() throws Exception {
		List<ConsultaResumenDTO> lista = servicio.listarResumen();

		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@GetMapping(value = "/generarReporte", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE) // APPLICATION_PDF_VALUE
																								// para visualizar
	public ResponseEntity<byte[]> generarReporte() {
		byte[] data = null;
		data = servicio.generarReporte();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody ConsultaListaExamenDTO dtoRequest) throws Exception {

		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Consulta c = mapper.map(dtoRequest, Consulta.class);
		// Consulta c = mapper.map(dtoRequest.getConsulta(), Consulta.class);
		List<Analitica> examenes = mapper.map(dtoRequest.getLstExamen(), new TypeToken<List<Analitica>>() {
		}.getType());

		Consulta obj = servicio.registrarTransaccional(c, examenes);
		ConsultaDTO dtoResponse = mapper.map(obj, ConsultaDTO.class);
		// localhost:8080/Consultas/9
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dtoResponse.getIdConsulta()).toUri();
		return ResponseEntity.created(location).build();
	}
}
