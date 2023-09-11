package com.proyect.model;


public class Carrito {

	int item;
	int idProducto;
	String nombre;
	String imagen;
	String descripcion;
	double precio;
	int cantidad;
	double subtotal;
	
	
	public Carrito() {
	}


	public Carrito(int item, int idProducto, String nombre, String imagen, String descripcion, double precio,
			int cantidad, double subtotal) {
		super();
		this.item = item;
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}


	public int getItem() {
		return item;
	}


	public void setItem(int item) {
		this.item = item;
	}


	public int getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}


	
	
	
}
