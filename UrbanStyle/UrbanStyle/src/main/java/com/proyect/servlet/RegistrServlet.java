package com.proyect.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyect.business.RegistroService;
import com.proyect.business.impl.RegistroServiceImpl;
import com.proyect.model.Registro;

/**
 * Servlet implementation class RegistrServlet
 */
public class RegistrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dni = request.getParameter("txtdni");
		String nomape = request.getParameter("txtnomape");
		String correo = request.getParameter("txtcorreo");
		String contraseña = request.getParameter("txtcontra");

		Registro reg_cliente = new Registro();
		reg_cliente.setDni(dni);
		reg_cliente.setNom_apll(nomape);
		reg_cliente.setCorreo(correo);
		reg_cliente.setContraseña(contraseña);

		RegistroService service = new RegistroServiceImpl();
		int value = service.insertRegistro(reg_cliente);
		if(value == 1){
			System.out.println("Registro Exitoso");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			request.setAttribute("mensaje", "Ocurrio un problema");
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
