package com.curso.service;

import java.util.List;
import java.util.Optional;

import com.curso.model.Vuelo;

/**
 * Interfaz con la firma de los metodos que se deben implementar
 * 
 * @author Admin
 *
 */
public interface VueloService {

	List<Vuelo> listar();

	Optional<Vuelo> buscar(int idVuelo);

	void crear(Vuelo vuelo);

	void actuaizar(Vuelo vuelo);

	List<Vuelo> eliminar(int idVuelo);

	List<Vuelo> buscarDisponibles(int plazas);

	void actualizarPlazas(int reservadas, int idVuelo);
}
