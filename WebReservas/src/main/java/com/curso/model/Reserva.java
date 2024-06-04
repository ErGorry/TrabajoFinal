package com.curso.model;

import java.util.Objects;

/**
 * Entidad de persistencia Reserva de la BBDD
 * 
 * @author Admin
 *
 */
public class Reserva {

	private Integer idReserva;
	private String nombreCliente;
	private String dni;
	private Integer numeroPersonas;
	private Integer idVuelo;
	private Integer idHotel;

	public Reserva() {
	}

	public Reserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public Reserva(Integer idReserva, Integer idVuelo, Integer idHotel) {
		this.idReserva = idReserva;
		this.idVuelo = idVuelo;
		this.idHotel = idHotel;
	}

	public Reserva(String nombreCliente, String dni, Integer numeroPersonas) {
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.numeroPersonas = numeroPersonas;
	}

	public Reserva(String nombreCliente, String dni, Integer numeroPersonas, Integer idVuelo, Integer idHotel) {
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.numeroPersonas = numeroPersonas;
		this.idVuelo = idVuelo;
		this.idHotel = idHotel;
	}

	public Reserva(Integer idReserva, String nombreCliente, String dni, Integer numeroPersonas, Integer idVuelo,
			Integer idHotel) {
		this.idReserva = idReserva;
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.numeroPersonas = numeroPersonas;
		this.idVuelo = idVuelo;
		this.idHotel = idHotel;
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getNumeroPersonas() {
		return numeroPersonas;
	}

	public void setNumeroPersonas(Integer numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

	public Integer getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(Integer idVuelo) {
		this.idVuelo = idVuelo;
	}

	public Integer getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idReserva);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(idReserva, other.idReserva);
	}

}
