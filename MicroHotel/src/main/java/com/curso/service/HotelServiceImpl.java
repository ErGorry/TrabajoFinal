package com.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.HotelDao;
import com.curso.model.Hotel;

/**
 * Clase Service que implementa los metodos de acceso a datos
 * 
 * @author Admin
 *
 */
@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelDao dao;

	@Override
	public List<Hotel> listar() {

		return dao.findAll();
	}

	@Override
	public Optional<Hotel> buscar(Integer idHotel) {

		return dao.findById(idHotel);
	}

	@Override
	public void crear(Hotel hotel) {

		dao.save(hotel);
	}

	@Override
	public void actualizar(Hotel hotel) {

		dao.save(hotel);
	}

	@Override
	public List<Hotel> eliminar(Integer idHotel) {
		dao.deleteById(idHotel);
		return listar();
	}

	@Override
	public Optional<Hotel> buscarPorNombre(String nombre) {

		return dao.findByNombre(nombre);
	}

	@Override
	public List<Hotel> listarDisponibles() {

		return dao.findByDisponibleTrue();
	}

}
