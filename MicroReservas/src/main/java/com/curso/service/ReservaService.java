package com.curso.service;

import java.util.List;
import java.util.Optional;

import com.curso.model.Reserva;

/**
 * Interfaz con la firma de los metodos que se deben implementar para el acceso
 * a datos
 * 
 * @author Admin
 *
 */
public interface ReservaService {

	List<Reserva> listar();

	Optional<Reserva> buscar(int idReserva);

	void crear(Reserva reserva);

	void actualizar(Reserva reserva);

	List<Reserva> eliminar(int idReserva);

	List<Reserva> findByNombreHotel(String nombreHotel);
}
