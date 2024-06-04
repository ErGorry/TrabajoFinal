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

import com.curso.model.Hotel;
import com.curso.service.HotelService;
/**
 * REST Controller de Hoteles con sus diferentes EndPoints
 * @author Admin
 *
 */
@RestController
public class HotelController {

	@Autowired
	HotelService service;

	@GetMapping(value = "hoteles", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> listar() {
		return service.listar();
	}

	@GetMapping(value = "hoteles/{idHotel}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Hotel> buscarPorId(@PathVariable("idHotel") Integer idHotel) {
		return service.buscar(idHotel);
	}

	@PostMapping(value = "hoteles", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void crear(@RequestBody Hotel hotel) {
		service.crear(hotel);
	}

	@PutMapping(value = "hoteles", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody Hotel hotel) {
		service.actualizar(hotel);
	}

	@DeleteMapping(value = "hoteles/{idHotel}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> eliminar(@PathVariable("idHotel") Integer idhotel) {
		return service.eliminar(idhotel);
	}

	@GetMapping(value = "hoteles/disponibles", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> listarDisponibles() {
		return service.listarDisponibles();
	}

	@GetMapping(value = "hoteles/nombre/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Hotel> buscarPorNombre(@PathVariable("nombre") String nombre) {
		return service.buscarPorNombre(nombre);
	}
}
