package com.proyect.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.proyect.config.Conectar;
import com.proyect.dao.RegistroDao;
import com.proyect.model.Registro;

public class RegistroDaoImpl implements RegistroDao{
	
	Conectar cn = new Conectar();
	Connection con; 
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public int insertRegistro(Registro registro) {
		
		int value = 0;
		
		try {
			con = cn.conectarMySQL();
			String sql = "INSERT INTO Registro VALUES (null,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, registro.getDni());
			ps.setString(2, registro.getNom_apll());
			ps.setString(3, registro.getCorreo());
			ps.setString(4, registro.getContraseña());
			
			value = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return value;
	}
	
	public Registro validar(String correo, String contraseña) {
		Registro rg = new Registro();
		String sql = "select * from registro where Email=? and Password=?";
		try {
			con = cn.conectarMySQL();
			ps = con.prepareStatement(sql);
			ps.setString(1, correo);
			ps.setString(2, contraseña);
			rs=ps.executeQuery();
			while(rs.next()){
				rg.setCorreo(rs.getString("Email"));
				rg.setContraseña(rs.getString("Password"));
			}
		} catch (Exception e) {
		}
		return rg;
	}

	@Override
	public int deleteRegistro(int Dni) {
		// TODO Auto-generated method stub
		return 0;
	}

}
