package com.proyect.model;

public class Registro {
	
	private String id, Dni, nom_apll, correo, contraseña;
	
	public Registro() {
		
	}
	
  
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public String getNom_apll() {
		return nom_apll;
	}

	public void setNom_apll(String nom_apll) {
		this.nom_apll = nom_apll;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	

}
