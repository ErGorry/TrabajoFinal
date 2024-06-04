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

import com.curso.model.Hotel;

@Controller
public class VistaHotelesController {

	@Autowired
	RestTemplate template;

	private static final String URL_HOTELES = "http://localhost:7000/hoteles";

	@GetMapping("/hoteles")
	public String inicio() {
		return "hoteles/inicio";
	}

	@GetMapping("/hoteles/list")
	public String hotelesLista(Model model) {
		List<Hotel> listaHoteles = Arrays.asList(template.getForObject(URL_HOTELES, Hotel[].class));
		model.addAttribute("listaHoteles", listaHoteles);
		return "hoteles/list";
	}
	
	@GetMapping("/hoteles/create")
	public String formHoteles() {
		return "hoteles/form";
	}
	
	@PostMapping("/hoteles/nuevoHotel")
	public String crearHotel(@ModelAttribute Hotel hotel, Model model) {
		template.postForLocation(URL_HOTELES, hotel);
		return hotelesLista(model);
	}
}
