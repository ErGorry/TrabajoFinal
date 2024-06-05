package com.curso.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Hotel;

/**
 * Interfaz de acceso a datos con el CRUD ampliado de JpaRepository
 * 
 * @author Admin
 *
 */
public interface HotelDao extends JpaRepository<Hotel, Integer> {
	/**
	 * 
	 * @return Lista de hoteles disponibles
	 */
	List<Hotel> findByDisponibleTrue();

	/**
	 * 
	 * @param nombre del hotel
	 * @return hotel con el nombre
	 */
	Optional<Hotel> findByNombre(String nombre);
}
