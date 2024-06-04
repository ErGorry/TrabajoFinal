package com.curso.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Hotel;
import com.curso.model.Reserva;
import com.curso.model.Vuelo;
@Controller
public class VistaReservaController {

	@Autowired
	RestTemplate template;

	private static final String URL_RESERVAS = "http://localhost:9000/reservas";

	@GetMapping("/reservas")
	public String inicio() {
		return "reservas/inicio";
	}

	@GetMapping("/reservas/list")
	public String reservasLista(Model model) {
		List<Reserva> listaReservas = Arrays.asList(template.getForObject(URL_RESERVAS, Reserva[].class));
		model.addAttribute("listaReservas", listaReservas);
		return "reservas/list";
	}
	
	@GetMapping("/reservas/{id}")
	public String detalleReserva(@PathVariable("id") int idReserva, Model model) {
		Reserva reserva = template.getForObject(URL_RESERVAS+"/"+idReserva, Reserva.class);
		Vuelo vuelo = template.getForObject("http://localhost:8000/vuelos/"+reserva.getIdVuelo(), Vuelo.class);
		Hotel hotel = template.getForObject("http://localhost:7000/hoteles/"+reserva.getIdHotel(), Hotel.class);
		model.addAttribute("reserva", reserva);
		model.addAttribute("vuelo", vuelo);
		model.addAttribute("hotel", hotel);
		return "reservas/detalle";
	}
	
	@GetMapping("/reservas/create")
	public String formReservas() {
		return "reservas/form";
	}
	
	@PostMapping("/reservas/nuevaReserva")
	public String crearReserva(@ModelAttribute Reserva reserva, Model model) {
		template.postForLocation(URL_RESERVAS, reserva);
		return reservasLista(model);
	}
}
