package com.proyect.business.impl;

import com.proyect.business.RegistroService;
import com.proyect.dao.RegistroDao;
import com.proyect.dao.impl.RegistroDaoImpl;
import com.proyect.model.Registro;

public class RegistroServiceImpl implements RegistroService{
	
	private RegistroDao dao = new RegistroDaoImpl();

	@Override
	public int insertRegistro(Registro registro) {
		return dao.insertRegistro(registro);
	}

}
