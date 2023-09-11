package com.proyect.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyect.dao.impl.RegistroDaoImpl;
import com.proyect.model.Registro;

/**
 * Servlet implementation class ValidarServlet
 */
public class ValidarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RegistroDaoImpl rdao = new RegistroDaoImpl();
	Registro reg = new Registro();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		if(accion.equalsIgnoreCase("Ingresar")) {
			String correo=request.getParameter("txtcorreo");
			String contraseña=request.getParameter("txtcontra");
			reg = rdao.validar(correo, contraseña);
			if(reg.getCorreo()!=null) {
				request.setAttribute("usuario", reg);
				request.getRequestDispatcher("ProductoServlet?accion=Principal").forward(request, response);
			}else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
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
		
	}

}
