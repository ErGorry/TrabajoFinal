package com.curso.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Vuelo;

/**
 * Vistas del REST de vuelos
 * 
 * @author Admin
 *
 */
@Controller
public class VistaVuelosController {

	@Autowired
	RestTemplate template;
	// Ruta del REST de vuelos
	private static final String URL_VUELOS = "http://localhost:8000/vuelos";

	@GetMapping("/vuelos")
	public String vuelosInicio() {
		return "vuelos/inicio";
	}

	@GetMapping("/vuelos/list")
	public String vuelosLista(Model model) {
		List<Vuelo> listaVuelos = Arrays.asList(template.getForObject(URL_VUELOS, Vuelo[].class));
		model.addAttribute("listaVuelos", listaVuelos);
		return "vuelos/list";
	}

	@GetMapping("vuelos/create")
	public String formVuelos() {
		return "vuelos/form";
	}

	@PostMapping("vuelos/nuevoVuelo")
	public String crearVuelo(@ModelAttribute Vuelo vuelo, Model model) {
		template.postForLocation(URL_VUELOS, vuelo);
		return vuelosLista(model);
	}
}
