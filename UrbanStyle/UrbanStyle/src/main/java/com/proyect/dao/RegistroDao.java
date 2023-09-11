package com.proyect.dao;

import com.proyect.model.Registro;

public interface RegistroDao  {
	
	public int insertRegistro(Registro registro);
	
	public int deleteRegistro(int Dni);

}
