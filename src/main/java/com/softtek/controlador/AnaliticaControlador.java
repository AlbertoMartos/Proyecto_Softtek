package com.softtek.controlador;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softtek.dto.AnaliticaDTO;
import com.softtek.exception.ModeloNotFoundException;
import com.softtek.modelo.Analitica;
import com.softtek.servicio.IAnaliticaServicio;

@RestController
@RequestMapping("/analiticas")
//@CrossOrigin(origins = "http://localhost:4200")
public class AnaliticaControlador {

	@Autowired
	private IAnaliticaServicio servicio;

	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<List<AnaliticaDTO>> listar() throws Exception {
		List<AnaliticaDTO> lista = servicio.listar().stream().map(x -> mapper.map(x, AnaliticaDTO.class))
				.collect(Collectors.toList());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AnaliticaDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Analitica objeto = servicio.listarPorId(id);

		if (objeto == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		AnaliticaDTO dtoResponse = mapper.map(servicio.registrar(objeto), AnaliticaDTO.class);
		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<AnaliticaDTO> registrar(@RequestBody AnaliticaDTO m) throws Exception {
		Analitica objeto = mapper.map(m, Analitica.class);
		Analitica obj = servicio.registrar(objeto);
		AnaliticaDTO dtoResponse = mapper.map(obj, AnaliticaDTO.class);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dtoResponse.getIdAnalitica()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<AnaliticaDTO> modificar(@RequestBody Analitica m) throws Exception {
		Analitica medicoRequest = mapper.map(m, Analitica.class);
		Analitica medicoConsultado = servicio.listarPorId(medicoRequest.getIdAnalitica());

		if (medicoConsultado == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + medicoConsultado.getIdAnalitica());
		}

		Analitica BBDD = servicio.modificar(medicoRequest);
		AnaliticaDTO medicoResponse = mapper.map(BBDD, AnaliticaDTO.class);
		return new ResponseEntity<>(medicoResponse, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Analitica objeto = servicio.listarPorId(id);
		if (objeto == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		servicio.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
