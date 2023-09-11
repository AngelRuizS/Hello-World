package com.proyect.model;

public class Cliente {

	private int id;
	private String dni;
	private String nombre;
	private String correo;
	private String password;
	
	public Cliente() {
		
	}

	public Cliente(int id, String dni, String nombre, String correo, String password) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.correo = correo;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
