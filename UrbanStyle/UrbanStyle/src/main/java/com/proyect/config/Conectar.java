package com.proyect.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar {
	
	private static String driver = "com.mysql.jdbc.Driver";
	private static String database = "urbanstyle";
	private static String host = "localhost";
	private static String port = "3306";
	private static String url = "jdbc:mysql://"+host+":"+port+"/"+database+"?characterEncoding=latin1";
    private static String username = "cibertec";	
	private static String password = "Computacion_27";
	
	public Connection conectarMySQL(){
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
			if (conn != null) {
				System.out.println("Conexión Satisfactoria");
			}else {
				System.out.println("Conexión no Satisfactoria");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
