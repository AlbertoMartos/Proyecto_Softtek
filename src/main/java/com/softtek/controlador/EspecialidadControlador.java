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

import com.softtek.dto.EspecialidadDTO;
import com.softtek.exception.ModeloNotFoundException;
import com.softtek.modelo.Especialidad;
import com.softtek.servicio.IEspecialidadServicio;

@RestController
@RequestMapping("/especialidades")
//@CrossOrigin(origins = "http://localhost:4200")
public class EspecialidadControlador {

	@Autowired
	private IEspecialidadServicio servicio;

	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<List<EspecialidadDTO>> listar() throws Exception {
		List<EspecialidadDTO> lista = servicio.listar().stream().map(x -> mapper.map(x, EspecialidadDTO.class))
				.collect(Collectors.toList());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EspecialidadDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Especialidad objeto = servicio.listarPorId(id);

		if (objeto == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		EspecialidadDTO dtoResponse = mapper.map(servicio.registrar(objeto), EspecialidadDTO.class);
		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<EspecialidadDTO> registrar(@RequestBody EspecialidadDTO m) throws Exception {
		Especialidad objeto = mapper.map(m, Especialidad.class);
		Especialidad obj = servicio.registrar(objeto);
		EspecialidadDTO dtoResponse = mapper.map(obj, EspecialidadDTO.class);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dtoResponse.getIdEspecialidad()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<EspecialidadDTO> modificar(@RequestBody Especialidad m) throws Exception {
		Especialidad medicoRequest = mapper.map(m, Especialidad.class);
		Especialidad medicoConsultado = servicio.listarPorId(medicoRequest.getIdEspecialidad());

		if (medicoConsultado == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + medicoConsultado.getIdEspecialidad());
		}

		Especialidad BBDD = servicio.modificar(medicoRequest);
		EspecialidadDTO medicoResponse = mapper.map(BBDD, EspecialidadDTO.class);
		return new ResponseEntity<>(medicoResponse, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Especialidad objeto = servicio.listarPorId(id);
		if (objeto == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		servicio.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
