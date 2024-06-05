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
 * 
 * @author Admin
 *
 */
@RestController
public class HotelController {

	@Autowired
	HotelService service;

	/**
	 * GETMAPPING ("hoteles")
	 * 
	 * @return Lista con todos los hoteles formato JSON
	 */
	@GetMapping(value = "hoteles", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> listar() {
		return service.listar();
	}

	/**
	 * GETMAPPING ("hoteles/id")
	 * 
	 * @param idHotel que se desea buscar
	 * @return Hotel encontrado en formato JSON
	 */
	@GetMapping(value = "hoteles/{idHotel}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Hotel> buscarPorId(@PathVariable("idHotel") Integer idHotel) {
		return service.buscar(idHotel);
	}

	/**
	 * POSTMAPPING ("hoteles")
	 * 
	 * @param hotel que sera creado
	 */
	@PostMapping(value = "hoteles", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void crear(@RequestBody Hotel hotel) {
		service.crear(hotel);
	}

	/**
	 * PUTMAPPING ("hoteles")
	 * 
	 * @param hotel que sera actualizado
	 */
	@PutMapping(value = "hoteles", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody Hotel hotel) {
		service.actualizar(hotel);
	}

	/**
	 * DELETEMAPPING ("hoteles/id")
	 * 
	 * @param idHotel que se desea eliminar
	 * @return lista actualizada de hoteles en formato JSON
	 */
	@DeleteMapping(value = "hoteles/{idHotel}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> eliminar(@PathVariable("idHotel") Integer idHotel) {
		return service.eliminar(idHotel);
	}

	/**
	 * GETMAPPING ("hoteles/disponibles")
	 * 
	 * @return Lista con los hoteles disponibles en formato JSON
	 */
	@GetMapping(value = "hoteles/disponibles", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> listarDisponibles() {
		return service.listarDisponibles();
	}

	/**
	 * GETMAPPING ("hoteles/nombre/nombre")
	 * 
	 * @param nombre del hotel a buscar
	 * @return Hotel en formato JSON
	 */
	@GetMapping(value = "hoteles/nombre/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Hotel> buscarPorNombre(@PathVariable("nombre") String nombre) {
		return service.buscarPorNombre(nombre);
	}
}
