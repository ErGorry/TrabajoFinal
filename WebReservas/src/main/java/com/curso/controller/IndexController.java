package com.curso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * Pagina de inicio
 * @author Admin
 *
 */
@Controller
public class IndexController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/inicio")
	public String inicio() {
		return "index";
	}
}
