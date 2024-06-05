package com.curso.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.dao.ReservaDao;
import com.curso.model.Hotel;
import com.curso.model.Reserva;
import com.curso.model.Vuelo;

/**
 * Servicio que conecta el acceso a datos, tambien se conecta con los
 * microservicios de hotel y vuelo
 * 
 * @author Admin
 *
 */
@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	ReservaDao dao;
	@Autowired
	RestTemplate template;
	// URL CRUD de hoteles
	private static final String URL_HOTEL = "http://localhost:7000/hoteles";
	// URL CRUD de vuelos
	private static final String URL_VUELO = "http://localhost:8000/vuelos";

	@Override
	public List<Reserva> listar() {

		return dao.findAll();
	}

	@Override
	public Optional<Reserva> buscar(int idReserva) {

		return dao.findById(idReserva);
	}

	/**
	 * Metodo que intenta registrar una reserva. Primero comprueba las plazas de
	 * avion y si es pertienente reduce esas plazas y crea la reserva
	 */
	@Override
	public void crear(Reserva reserva) {
		boolean vueloDisponible = false;
		System.out.println(reserva);
		List<Vuelo> listaVuelos = Arrays.asList(
				template.getForObject(URL_VUELO + "/disponibles/" + reserva.getNumeroPersonas(), Vuelo[].class));
		for (Vuelo vuelo : listaVuelos) {
			if (vuelo.getIdVuelo() == reserva.getIdVuelo()) {
				vueloDisponible = true;
				template.put(URL_VUELO + "/" + vuelo.getIdVuelo() + "/" + reserva.getNumeroPersonas(), null);
			}
		}
		if (vueloDisponible) {
			dao.save(reserva);
		}
	}

	@Override
	public void actualizar(Reserva reserva) {

		dao.save(reserva);
	}

	@Override
	public List<Reserva> eliminar(int idReserva) {
		dao.deleteById(idReserva);
		return listar();
	}

	/**
	 * Metodo que busca las reservas asociadas a un hotel segun su nombre
	 */
	@Override
	public List<Reserva> findByNombreHotel(String nombreHotel) {
		Hotel hotel = template.getForObject(URL_HOTEL + "/nombre/" + nombreHotel, Hotel.class);

		return dao.findByIdHotel(hotel.getIdHotel());
	}

}
