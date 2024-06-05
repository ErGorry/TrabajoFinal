package com.curso.model;

/**
 * Objeto de Transferencia de datos para Reserva, se usa en el formulario previo
 * de reserva
 * 
 * @author Admin
 *
 */
public class PedidoReserva {
	private String nombreCliente;
	private String dni;
	private Integer numeroPersonas;

	public PedidoReserva() {
	}

	public PedidoReserva(String nombreCliente, String dni, Integer numeroPersonas) {
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.numeroPersonas = numeroPersonas;
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

}
