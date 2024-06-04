package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.curso.model.Vuelo;

/**
 * Interfaz de acceso a datos con el CRUD ampliado de JpaRepository
 * 
 * @author Admin
 *
 */
public interface VueloDao extends JpaRepository<Vuelo, Integer> {

	/**
	 * Metodo para obtener los aviones con plazas disponibles
	 * 
	 * @param plazas Las plazas que se solicitan desde la reserva
	 * @return Los aviones que tienen suficientes plazas para hacer la reserva
	 * 
	 */
	List<Vuelo> findByPlazasDisponiblesGreaterThanEqual(int plazas);

	/**
	 * Metodo que sustrae las plazas que se reservan de un vuelo
	 * 
	 * @param reservadas plazas que constan en la reserva
	 * @param idVuelo    vuelo seleccionado en la reserva
	 */
	@Transactional
	@Modifying
	@Query(value = "UPDATE Vuelo v SET v.plazasDisponibles = v.plazasDisponibles - ?1 WHERE v.idVuelo = ?2")
	void actualizaPlazasDisponibles(int reservadas, int idVuelo);
}
