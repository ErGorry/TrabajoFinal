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
	/**
	 * Busca las reservas con ese id de hotel
	 * 
	 * @param idHotel Id del hotel
	 * @return lista de reservas
	 */
	List<Reserva> findByIdHotel(int idHotel);
}
