package com.curso.service;

import java.util.List;
import java.util.Optional;

import com.curso.model.Hotel;
/**
 * Interfaz service con los metodos que se implementaran
 * @author Admin
 *
 */
public interface HotelService {

	List<Hotel> listar();

	Optional<Hotel> buscar(Integer idHotel);

	void crear(Hotel hotel);

	void actualizar(Hotel hotel);

	List<Hotel> eliminar(Integer idHotel);

	Optional<Hotel> buscarPorNombre(String nombre);
	
	List<Hotel> listarDisponibles();
}
