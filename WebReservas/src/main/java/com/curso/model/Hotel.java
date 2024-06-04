package com.curso.model;

/**
 * Objeto Hotel de transferencia de datos
 * 
 * @author Admin
 *
 */
public class Hotel {

	private int idHotel;
	private String nombre;
	private String categoria;
	private double precio;
	private boolean disponible;

	public Hotel() {
	}

	public Hotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public Hotel(String nombre, String categoria, double precio, boolean disponible) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.disponible = disponible;
	}

	public Hotel(int idHotel, String nombre, String categoria, double precio, boolean disponible) {
		this.idHotel = idHotel;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.disponible = disponible;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
}
