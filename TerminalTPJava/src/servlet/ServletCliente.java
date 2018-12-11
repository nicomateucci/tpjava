package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.LogicPersona;
import entities.Conductor;
import entities.Destino;
import entities.Usuario;
import util.AppDataException;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LogicPersona logicp = new LogicPersona();
		try {
			String tipo = (String) request.getParameter("tipo");
			if(tipo.equals("consulta")) {
				
				request.getSession().setAttribute("tipo", "consulta");
				ArrayList<Usuario> uu = logicp.getAllUsuarios();
				request.getSession().setAttribute("listaUsuarios", uu);
				response.sendRedirect("pages/clientes_adminPage.jsp");
				
			} else if(tipo.equals("alta")){

				request.getSession().setAttribute("tipo", "alta");
				response.sendRedirect("pages/destinos_adminPage.jsp");

			}else if (tipo.equals("modifica")){

				request.getSession().setAttribute("tipo", "modifica");
				ArrayList<Usuario> uu = logicp.getAllUsuarios();
				request.getSession().setAttribute("listaUsuarios", uu);
				response.sendRedirect("pages/clientes_adminPage.jsp");

			}else if (tipo.equals("baja")){

				request.getSession().setAttribute("tipo", "baja");
				ArrayList<Usuario> uu = logicp.getAllUsuarios();
				request.getSession().setAttribute("listaUsuarios", uu);
				response.sendRedirect("pages/clientes_adminPage.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (AppDataException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LogicPersona logPer = new LogicPersona();
		Usuario usu = new Usuario();

		usu.setNombre(request.getParameter("nombre"));
		usu.setApellido(request.getParameter("apellido"));
		usu.setDni(request.getParameter("dni"));
		usu.setTipoDni(request.getParameter("tipoDni"));

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		java.sql.Date sqlDate = null;
		try {
			date = format.parse(request.getParameter("fecha"));
			sqlDate = new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		usu.setFechaNacimiento(sqlDate);
		//----------------------------------------

		usu.setNombreUsuario(request.getParameter("nombreU"));
		usu.setContrasena(request.getParameter("password"));
		usu.setEmail(request.getParameter("mail"));

		// Ejemplo de fecha dormateada a JAVA.SQL.DATE
		/*
		String startDate="23-05-2018";
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date date = sdf1.parse(startDate);
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());  
		 */
		try {
			try {
				logPer.add(usu);
			} catch (AppDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("index.jsp");
	}

}
