package com.proyect.config;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Fecha {

	public static Calendar calendar = Calendar.getInstance();
	private static String fecha;
	
	public Fecha() {
		
	}
	public static String Fecha() {
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
		fecha = sdf.format(calendar.getTime());
		return fecha;
	}
	
	public static String FechaBD() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		fecha = sdf.format(calendar.getTime());
		return fecha;
	}
}
