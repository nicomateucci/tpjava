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

import business.LogicMicro;
import entities.Micro;
import entities.MicroCama;
import util.AppDataException;

/**
 * Servlet implementation class ServletMicro_
 */
@WebServlet("/ServletMicro")
public class ServletMicro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletMicro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LogicMicro logicm = new LogicMicro();
		try {
			String tipo = (String) request.getParameter("tipo");
			if(tipo.equals("consulta")) {

				request.getSession().setAttribute("tipo", "consulta");
				ArrayList<Micro> mm = logicm.getAll();
				request.getSession().setAttribute("listaMicros", mm);
				response.sendRedirect("pages/micros_adminPage.jsp");

			} else if(tipo.equals("alta")){

				request.getSession().setAttribute("tipo", "alta");
				response.sendRedirect("pages/micros_adminPage.jsp");

			}else if (tipo.equals("modifica")){

				request.getSession().setAttribute("tipo", "modifica");
				ArrayList<Micro> mm = logicm.getAll();
				request.getSession().setAttribute("listaMicros", mm);
				response.sendRedirect("pages/micros_adminPage.jsp");

			}else if (tipo.equals("baja")){

				request.getSession().setAttribute("tipo", "baja");
				ArrayList<Micro> mm = logicm.getAll();
				request.getSession().setAttribute("listaMicros", mm);
				response.sendRedirect("pages/micros_adminPage.jsp");
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
		LogicMicro logicm = new LogicMicro();	
		String tipoMicro = request.getParameter("tipoMicro");

		if(tipoMicro.equals("MicroCama")) {
			MicroCama m = new MicroCama();
			double por = Double.parseDouble(request.getParameter("aumento"));
			((MicroCama) m).setAumento(por);
			m.setPatente(request.getParameter("patente"));
			m.setMarca(request.getParameter("marca"));
			//----------Parseo de fecha
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = null;
			java.sql.Date sqlDate = null;
			try {
				date = format.parse(request.getParameter("fechaControl"));
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			sqlDate = new java.sql.Date(date.getTime());  
			m.setFechaUltimoCtrl(sqlDate);

			try {
				logicm.insert(m);
			} catch (AppDataException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			Micro m = new Micro();
			m.setPatente(request.getParameter("patente"));
			m.setMarca(request.getParameter("marca"));
			//----------Parseo de fecha
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = null;
			java.sql.Date sqlDate = null;
			try {
				date = format.parse(request.getParameter("fechaControl"));
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			sqlDate = new java.sql.Date(date.getTime());  
			m.setFechaUltimoCtrl(sqlDate);

			try {
				logicm.insert(m);
			} catch (AppDataException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}else if(tipo.equals("modifica")) {
		LogicMicro logicm = new LogicMicro();
		Micro m = new Micro();
		Micro microUpdate = null;
		m.setPatente(request.getParameter("patente"));
		try {
			microUpdate = logicm.getByPatente(m);
		} catch (AppDataException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		double por = Double.parseDouble(request.getParameter("aumento"));
		if(por != 0.0) {
			((MicroCama) microUpdate).setAumento(por);
		}
		String marca = request.getParameter("marca");
		if(marca  != ""){
			microUpdate.setMarca(marca);
		}
		String fecha = request.getParameter("fechaControl");
		if(fecha != ""){
			//----------Parseo de fecha
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = null;
			java.sql.Date sqlDate = null;
			try {
				date = format.parse(request.getParameter("fechaControl"));
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			sqlDate = new java.sql.Date(date.getTime());  
			microUpdate.setFechaUltimoCtrl(sqlDate);
		}
		
		try {
			logicm.update(microUpdate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}else if(tipo.equals("baja")) {
		LogicMicro logicm = new LogicMicro();
		Micro m = new Micro();
		m.setPatente(request.getParameter("patente"));
		Micro micDel =null;
		try {
			micDel = logicm.getByPatente(m);
		} catch (AppDataException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			logicm.delete(micDel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		response.sendRedirect("ServletMicro?tipo=consulta");
	}

}