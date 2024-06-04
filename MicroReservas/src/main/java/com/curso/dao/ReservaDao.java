package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Reserva;

/**
 * Interfaz con el CRUD ampliado de JpaRepository de acceso a datos
 * 
 * @author Admin
 *
 */
public interface ReservaDao extends JpaRepository<Reserva, Integer> {

	List<Reserva> findByIdHotel(int idHotel);
}
