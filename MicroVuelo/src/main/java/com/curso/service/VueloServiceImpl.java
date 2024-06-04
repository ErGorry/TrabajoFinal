package com.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.VueloDao;
import com.curso.model.Vuelo;
/**
 * Metodos CRUD implementados mediante el acceso a datos
 * @author Admin
 *
 */
@Service
public class VueloServiceImpl implements VueloService {

	@Autowired
	VueloDao dao;
	@Override
	public List<Vuelo> listar() {
		
		return dao.findAll();
	}

	@Override
	public Optional<Vuelo> buscar(int idVuelo) {

		return dao.findById(idVuelo);
	}

	@Override
	public void crear(Vuelo vuelo) {
		
		dao.save(vuelo);
	}

	@Override
	public void actuaizar(Vuelo vuelo) {
		
		dao.save(vuelo);
	}

	@Override
	public List<Vuelo> eliminar(int idVuelo) {
		dao.deleteById(idVuelo);
		return listar();
	}

	@Override
	public List<Vuelo> buscarDisponibles(int plazas) {
		
		return dao.findByPlazasDisponiblesGreaterThanEqual(plazas);
	}

	@Override
	public void actualizarPlazas(int reservadas, int idVuelo) {
		
		dao.actualizaPlazasDisponibles(reservadas, idVuelo);
	}

}
