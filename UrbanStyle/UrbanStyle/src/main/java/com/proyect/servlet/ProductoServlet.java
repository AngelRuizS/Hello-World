package com.proyect.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyect.config.Fecha;
import com.proyect.dao.impl.CompraDaoImpl;
import com.proyect.dao.impl.ProductoDaoImpl;
import com.proyect.model.Carrito;
import com.proyect.model.Cliente;
import com.proyect.model.Compra;
import com.proyect.model.Pago;
import com.proyect.model.Producto;

/**
 * Servlet implementation class ProductoServlet
 */
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    
    ProductoDaoImpl pdao= new ProductoDaoImpl();
    Producto p = new Producto();
    List<Producto> productos=new ArrayList<>();
    
    List<Carrito> listacarrito = new ArrayList<>();
    
    int item;
    double totalpagar = 0.0;
    int cantidad=1;	
    
    int idp;
    Carrito car;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion=request.getParameter("accion");
		productos=pdao.listar();
		switch(accion) {
		case "Comprar":
			totalpagar = 0.0;
			idp=Integer.parseInt(request.getParameter("id"));
			p=pdao.listarId(idp);
			item=item+1;
			car= new Carrito();
			car.setItem(item);
			car.setIdProducto(p.getId());
			car.setNombre(p.getNombre());
			car.setDescripcion(p.getDescripcion());
			car.setPrecio(p.getPrecio());
			car.setCantidad(cantidad);
			car.setSubtotal(cantidad*p.getPrecio());
			listacarrito.add(car);
			for(int i=0; i<listacarrito.size();i++) {
				totalpagar = totalpagar + listacarrito.get(i).getSubtotal(); 
			}
			request.setAttribute("totalpagar", totalpagar	);
			request.setAttribute("carrito", listacarrito);
			request.setAttribute("producto", listacarrito.size());
			request.getRequestDispatcher("Carrito.jsp").forward(request, response);
		break;
		case "AgregarCarrito":
			int pos = 0;
			cantidad=1;
			idp=Integer.parseInt(request.getParameter("id"));
			p=pdao.listarId(idp);
			if(listacarrito.size()>0) {
				for(int i=0; i < listacarrito.size(); i++) {
					if(idp==listacarrito.get(i).getIdProducto()) {
						pos=i;
					}
				}
				if(idp==listacarrito.get(pos).getIdProducto()) {
					cantidad=listacarrito.get(pos).getCantidad() + cantidad;
					double subtotal=listacarrito.get(pos).getPrecio() * cantidad;
					listacarrito.get(pos).setCantidad(cantidad);
					listacarrito.get(pos).setSubtotal(subtotal);
				} else {
					item=item+1;
					car= new Carrito();
					car.setItem(item);
					car.setIdProducto(p.getId());
					car.setNombre(p.getNombre());
					car.setDescripcion(p.getDescripcion());
					car.setPrecio(p.getPrecio());
					car.setCantidad(cantidad);
					car.setSubtotal(cantidad*p.getPrecio());
					listacarrito.add(car);
				}
			}else {
			item=item+1;
			car= new Carrito();
			car.setItem(item);
			car.setIdProducto(p.getId());
			car.setNombre(p.getNombre());
			car.setDescripcion(p.getDescripcion());
			car.setPrecio(p.getPrecio());
			car.setCantidad(cantidad);
			car.setSubtotal(cantidad*p.getPrecio());
			listacarrito.add(car);
			}
			request.setAttribute("producto", listacarrito.size());
			request.getRequestDispatcher("ProductoServlet?accion=home").forward(request, response);
			break;
		case "Delete":
			int idproducto=Integer.parseInt(request.getParameter("idp"));
			for (int i = 0; i < listacarrito.size(); i++) {
				if(listacarrito.get(i).getIdProducto()==idproducto) {
					listacarrito.remove(i);
				}
				request.getRequestDispatcher("ProductoServlet?accion=Delete").forward(request, response);
			}
			break;
		case "ActualizarCantidad":
			int idpro = Integer.parseInt(request.getParameter("idp"));
			int cant = Integer.parseInt(request.getParameter("cantidad"));
			for (int i = 0; i < listacarrito.size(); i++) {
				if(listacarrito.get(i).getIdProducto()==idpro) {
					listacarrito.get(i).setCantidad(cant);
					double st=listacarrito.get(i).getPrecio()*cant;
					listacarrito.get(i).setSubtotal(st);
				}
			}
			break;
        case "Carrito":
			totalpagar = 0.0;
			request.setAttribute("carrito", listacarrito);
			for(int i=0; i<listacarrito.size();i++) {
				totalpagar = totalpagar + listacarrito.get(i).getSubtotal(); 
			}
			request.setAttribute("totalpagar", totalpagar);
			request.getRequestDispatcher("Carrito.jsp").forward(request, response);
			
			break;	
        case"GenerarCompra":
        	Cliente cliente = new Cliente();
        	cliente.setId(53);
        	CompraDaoImpl dao = new CompraDaoImpl(); 
        	Compra compra = new Compra(cliente, 19, Fecha.FechaBD(),totalpagar, "Cancelado", listacarrito);
        	int res = dao.GenerarCompra(compra);
        	if(res!=0&&totalpagar>0) {
        		request.getRequestDispatcher("mensaje.jsp").forward(request, response);
        	}else {
        		request.getRequestDispatcher("error.jsp").forward(request, response);
        	}
        	break;
			default:
				request.setAttribute("productos", productos);
				request.getRequestDispatcher("Principal.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
}
