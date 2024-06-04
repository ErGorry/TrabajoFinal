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
 * @author Admin
 *
 */
@RestController
public class ReservaController {

	@Autowired
	ReservaService service;

	@GetMapping(value = "reservas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> listar() {
		return service.listar();
	}

	@GetMapping(value = "reservas/{idReserva}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Reserva> buscar(@PathVariable("idReserva") int idReserva) {
		return service.buscar(idReserva);
	}

	@PostMapping(value = "reservas", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void crear(@RequestBody Reserva reserva) {
		service.crear(reserva);
	}

	@PutMapping(value = "reservas", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody Reserva reserva) {
		service.actualizar(reserva);
	}

	@DeleteMapping(value = "reservas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> eliminar(int idReserva) {
		return service.eliminar(idReserva);
	}

	@GetMapping(value = "reservas/hotel/{nombreHotel}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> buscarPorNombreHotel(@PathVariable("nombreHotel") String nombreHotel) {
		return service.findByNombreHotel(nombreHotel);
	}

}
