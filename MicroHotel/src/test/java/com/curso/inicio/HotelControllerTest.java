package com.curso.inicio;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.curso.model.Hotel;
import com.curso.service.HotelService;

@SpringBootTest
@AutoConfigureMockMvc
class HotelControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private HotelService service;

	@BeforeEach
	public void setup() {
		Hotel hotel = new Hotel("test", "test", 1, false);
		when(service.buscar(1).orElse(null)).thenReturn(hotel);
		when(service.listar()).thenReturn(Arrays.asList(hotel));
	}

	@Test
	public void crearTest() throws Exception {
		doNothing().when(service).crear(any(Hotel.class));
		mockMvc.perform(post("/hoteles").contentType(MediaType.APPLICATION_JSON)
				.content("{\"nombre\":\"test\", \"categoria\":\"test\", \"precio\":1, \"disponible\":false}"))
				.andExpect(status().isOk());
	}

	@Test
	public void actualizarTest() throws Exception {
		doNothing().when(service).actualizar(any(Hotel.class));
		mockMvc.perform(put("/hoteles").contentType(MediaType.APPLICATION_JSON)
				.content("{\"nombre\":\"test\", \"categoria\":\"test\", \"precio\":1, \"disponible\":false}"))
				.andExpect(status().isOk());
	}

	@Test
	public void eliminarTest() throws Exception {
		doNothing().when(service).eliminar(null);
		mockMvc.perform(delete("/hoteles/1")).andExpect(status().isOk());
	}

	@Test
	public void listarTest() throws Exception {
		mockMvc.perform(get("/hoteles")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].nombre", is("test"))).andExpect(jsonPath("$[0].categoria", is("test")));
	}

	@Test
	public void getClienteByIdTest() throws Exception {
		mockMvc.perform(get("/hoteles/1")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.nombre", is("test"))).andExpect(jsonPath("$.categoria", is("test")));

	}

}
