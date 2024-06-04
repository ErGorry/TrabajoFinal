package com.curso.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Modelo de entidad con persistencia en la BBDD
 * 
 * @author Admin
 *
 */
@Entity
public class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVuelo;
	@Column(name = "empresa")
	private String empresa;
	@Column(name = "fecha_vuelo")
	private LocalDate fechaVuelo;
	@Column(name = "precio")
	private Double precio;
	@Column(name = "plazas_disponibles")
	private Integer plazasDisponibles;

	public Vuelo() {
	}

	public Vuelo(Integer idVuelo) {
		this.idVuelo = idVuelo;
	}

	public Vuelo(String empresa, LocalDate fechaVuelo, Double precio, Integer plazasDisponibles) {
		this.empresa = empresa;
		this.fechaVuelo = fechaVuelo;
		this.precio = precio;
		this.plazasDisponibles = plazasDisponibles;
	}

	public Vuelo(Integer idVuelo, String empresa, LocalDate fechaVuelo, Double precio, Integer plazasDisponibles) {
		this.idVuelo = idVuelo;
		this.empresa = empresa;
		this.fechaVuelo = fechaVuelo;
		this.precio = precio;
		this.plazasDisponibles = plazasDisponibles;
	}

	public Integer getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(Integer idVuelo) {
		this.idVuelo = idVuelo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public LocalDate getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(LocalDate fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getPlazasDisponibles() {
		return plazasDisponibles;
	}

	public void setPlazasDisponibles(Integer plazasDisponibles) {
		this.plazasDisponibles = plazasDisponibles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idVuelo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		return Objects.equals(idVuelo, other.idVuelo);
	}

}
