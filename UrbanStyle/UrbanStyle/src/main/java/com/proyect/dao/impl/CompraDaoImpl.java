package com.proyect.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Connection;
import com.proyect.config.Conectar;
import com.proyect.model.Carrito;
import com.proyect.model.Compra;

public class CompraDaoImpl {

	Connection con;
	Conectar cn = new Conectar();
	PreparedStatement ps;
	ResultSet rs;
	int r = 0;
	
	public int GenerarCompra(Compra compra ) {
		int idcompras;
		String sql="INSERT INTO compras(idRegistro,idPago,FechaCompras,Monto,Estado)values(?,?,?,?,?)";
		try {
			con =cn.conectarMySQL();
			ps =con.prepareStatement(sql);
			ps.setInt(1, compra.getCliente().getId());
			ps.setInt(2, compra.getIdpago());
			ps.setString(3, compra.getFecha());
			ps.setDouble(4, compra.getMonto());
			ps.setString(5, compra.getEstado());
			r=ps.executeUpdate();
			
			
			sql="Select @@IDENTITY AS idCompras";
			rs = ps.executeQuery(sql);
			rs.next();
			idcompras = rs.getInt("idCompras");
			rs.close();
			
			for (Carrito detalle : compra.getDetallecompras()) {
				sql="INSERT INTO detalle_compras(idProducto,idCompras,Cantidad,PrecioCompra)values(?,?,?,?)";
				ps=con.prepareStatement(sql);
				ps.setInt(1, detalle.getIdProducto());
				ps.setInt(2, idcompras);
				ps.setInt(3, detalle.getCantidad());
				ps.setDouble(4, detalle.getPrecio());
				r=ps.executeUpdate();
			}
			
		} catch (Exception e) {
		}
		return r;
	}
}
