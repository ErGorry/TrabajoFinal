package com.curso.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Hotel;
/**
 * Interfaz de acceso a datos con el CRUD ampliado de JpaRepository
 * @author Admin
 *
 */
public interface HotelDao extends JpaRepository<Hotel, Integer> {

	List<Hotel> findByDisponibleTrue();

	Optional<Hotel> findByNombre(String nombre);
}
