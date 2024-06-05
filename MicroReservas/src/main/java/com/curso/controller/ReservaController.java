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

import com.curso.model.Reserva;
import com.curso.service.ReservaService;

/**
 * REST Controller con los EndPoints de reserva
 * 
 * @author Admin
 *
 */
@RestController
public class ReservaController {

	@Autowired
	ReservaService service;

	/**
	 * GETMAPPING ("reservas")
	 * 
	 * @return lista de todas las reservas
	 */
	@GetMapping(value = "reservas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> listar() {
		return service.listar();
	}

	/**
	 * GETMAPPING("reservas/id")
	 * 
	 * @param idReserva de la reserva
	 * @return reservas con ese id
	 */
	@GetMapping(value = "reservas/{idReserva}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Reserva> buscar(@PathVariable("idReserva") int idReserva) {
		return service.buscar(idReserva);
	}

	/**
	 * POSTMAPPING("reservas")
	 * 
	 * @param reserva que debe ser creada
	 */
	@PostMapping(value = "reservas", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void crear(@RequestBody Reserva reserva) {
		service.crear(reserva);
	}

	/**
	 * PUTMAPPING("reservas")
	 * 
	 * @param reserva que debe ser actualizada
	 */
	@PutMapping(value = "reservas", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody Reserva reserva) {
		service.actualizar(reserva);
	}

	/**
	 * DELETEMAPPING ("reservas/id")
	 * 
	 * @param idReserva de la reserva que se desea eliminar
	 * @return lista de reservas actualizada
	 */
	@DeleteMapping(value = "reservas/{idReserva}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> eliminar(@PathVariable("idReserva") int idReserva) {
		return service.eliminar(idReserva);
	}

	/**
	 * GETMAPPING("reservas/hotel/nombre")
	 * 
	 * @param nombreHotel nombre del hotel del que queremos buscar las reservas
	 * @return lista de reservas en ese hotel
	 */
	@GetMapping(value = "reservas/hotel/{nombreHotel}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> buscarPorNombreHotel(@PathVariable("nombreHotel") String nombreHotel) {
		return service.findByNombreHotel(nombreHotel);
	}

}
