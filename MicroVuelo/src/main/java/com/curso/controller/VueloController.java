package com.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Vuelo;
import com.curso.service.VueloService;

/**
 * REST Controller de vuelo con sus diferentes EndPoints
 * 
 * @author Admin
 *
 */
@RestController
public class VueloController {

	@Autowired
	VueloService service;

	/**
	 * GETMAPPING ("vuelos")
	 * 
	 * @return lista completa de vuelos
	 */
	@GetMapping(value = "vuelos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> listar() {
		return service.listar();
	}

	/**
	 * GETMAPPING("vuelos/id")
	 * 
	 * @param idVuelo que se desea buscar
	 * @return El vuelo encontrado
	 */
	@GetMapping(value = "vuelos/{idVuelo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Vuelo> buscar(@PathVariable("idVuelo") int idVuelo) {
		return service.buscar(idVuelo);
	}

	/**
	 * POSTMAPPING("vuelos")
	 * 
	 * @param vuelo que queremos crear
	 */
	@PostMapping(value = "vuelos", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void crear(@RequestBody Vuelo vuelo) {
		service.crear(vuelo);
	}

	/**
	 * PUTMAPPING("vuelos")
	 * 
	 * @param vuelo que queremos actualizar
	 */
	@PutMapping(value = "vuelos", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody Vuelo vuelo) {
		service.actuaizar(vuelo);
	}

	/**
	 * DELETEMAPPING("vuelos")
	 * 
	 * @param idVuelo que queremos eliminar
	 * @return lista de vuelos actualizada
	 */
	@DeleteMapping(value = "vuelos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> eliminar(@PathVariable("idVuelo") int idVuelo) {
		return service.eliminar(idVuelo);
	}

	/**
	 * GETMAPPING("vuelos/disponibles/plazas")
	 * 
	 * @param plazas minimas
	 * @return lista de aviones con al menos YY plazas
	 */
	@GetMapping(value = "vuelos/disponibles/{idVuelo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> buscarDisponibles(@PathVariable("idVuelo") int plazas) {
		return service.buscarDisponibles(plazas);
	}

	/**
	 * PUTMAPPPING("vuelos/idVuelo/plazas")
	 * 
	 * @param idVuelo que queremos actualizar
	 * @param plazas  que queremos restar del avion
	 */
	@PutMapping(value = "vuelos/{idVuelo}/{plazas}")
	public void actualizarPlazas(@PathVariable("idVuelo") int idVuelo, @PathVariable("plazas") int plazas) {
		service.actualizarPlazas(plazas, idVuelo);
	}
}
