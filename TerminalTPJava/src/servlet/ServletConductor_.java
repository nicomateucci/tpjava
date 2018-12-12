package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.LogicPersona;
import entities.Conductor;
import util.AppDataException;

/**
 * Servlet implementation class ServletConductor_
 */
@WebServlet("/ServletConductor")
public class ServletConductor_ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletConductor_() {
		super();
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
				ArrayList<Conductor> cc = logicp.getAllConductores();
				request.getSession().setAttribute("listaConductores", cc);
				response.sendRedirect("pages/conductores_adminPage.jsp");

			} else if(tipo.equals("alta")){

				request.getSession().setAttribute("tipo", "alta");
				response.sendRedirect("pages/conductores_adminPage.jsp");

			}else if (tipo.equals("modifica")){

				request.getSession().setAttribute("tipo", "modifica");
				ArrayList<Conductor> cc = logicp.getAllConductores();
				request.getSession().setAttribute("listaConductores", cc);
				response.sendRedirect("pages/conductores_adminPage.jsp");

			}else if (tipo.equals("baja")){

				request.getSession().setAttribute("tipo", "baja");
				ArrayList<Conductor> cc = logicp.getAllConductores();
				request.getSession().setAttribute("listaConductores", cc);
				response.sendRedirect("pages/conductores_adminPage.jsp");
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

		
		
		String tipo = (String) request.getSession().getAttribute("tipo");
		
	if(tipo.equals("alta")) {
		LogicPersona logPer = new LogicPersona();
		Conductor con = new Conductor();
		con.setNombre(request.getParameter("nombre"));
		con.setApellido(request.getParameter("apellido"));
		con.setDni(request.getParameter("dni"));
		con.setTipoDni(request.getParameter("tipoDni"));
		con.setContacto(request.getParameter("contacto"));


		//----------Parseo de fecha
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		java.sql.Date sqlDate = null;
		try {
			date = format.parse(request.getParameter("fecha"));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		sqlDate = new java.sql.Date(date.getTime());  

		con.setFechaNacimiento(sqlDate);

		date = null;
		sqlDate = null;
		try {
			date = format.parse(request.getParameter("fecha2"));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		sqlDate = new java.sql.Date(date.getTime());  

		con.setFechaInicio(sqlDate);
		//----------------------------------------

		// Ejemplo de fecha dormateada a JAVA.SQL.DATE
		/*
		String startDate="23-05-2018";
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date date = sdf1.parse(startDate);
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());  
		 */
		try {
			try {
				logPer.add(con);
			} catch (AppDataException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}else if(tipo.equals("modifica")) {
		LogicPersona logicPer = new LogicPersona();
		String dni = (String) request.getParameter("dni");
		String nombre = (String)(request.getParameter("nombre"));
		String apellido = (String)(request.getParameter("apellido"));
		String tipodni = (String)(request.getParameter("tipoDni"));
		String contacto = (String)(request.getParameter("contacto"));
		
		Conductor conductorUpdate = null;	
		try {
			conductorUpdate = (Conductor)logicPer.getByDni(dni);
		} catch (AppDataException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		conductorUpdate.setTipoDni(tipodni);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		java.sql.Date sqlDate = null;
		String f= request.getParameter("fecha");
		if(f != "") {
			//----------Parseo de fecha
			try {
				date = format.parse(request.getParameter("fecha"));
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			sqlDate = new java.sql.Date(date.getTime());  
			java.sql.Date fecha = sqlDate;
			conductorUpdate.setFechaNacimiento(fecha);
		}	
		String f2= request.getParameter("fecha2");
		if(f2 != "") {
			date = null;
			sqlDate = null;
			try {
				date = format.parse(request.getParameter("fecha2"));
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			sqlDate = new java.sql.Date(date.getTime());  
			java.sql.Date fecha2 = sqlDate;
			conductorUpdate.setFechaInicio(fecha2);
		}
		if(nombre != "") {
			conductorUpdate.setNombre(nombre);
		}
		if(apellido != "") {
			conductorUpdate.setApellido(apellido);
		}		
		if(contacto != "") {
			conductorUpdate.setContacto(contacto);
		}		

		try {
			logicPer.update(conductorUpdate);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}else if(tipo.equals("baja")) {
		LogicPersona logicPer = new LogicPersona();
		String dni = (String) request.getParameter("dni");
		Conductor c = new Conductor(dni);
		try {
			logicPer.delete(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		response.sendRedirect("ServletConductor?tipo=consulta");
	}

}
