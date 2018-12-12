package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.swing.JOptionPane;

import business.LogicDestino;
import entities.Destino;
import entities.DestinoDirecto;
import util.AppDataException;

@WebServlet(description = "Servlet que maneja SOLO Destinos en la base de datos.", urlPatterns = { "/ServletDestino" })
public class ServletDestino extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletDestino() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LogicDestino logicd = new LogicDestino();
		try {
			String tipo = (String) request.getParameter("tipo");
			if(tipo.equals("consulta")) {

				request.getSession().setAttribute("tipo", "consulta");
				ArrayList<Destino> dd = logicd.getAll();
				request.getSession().setAttribute("listaDestinos", dd);
				response.sendRedirect("pages/destinos_adminPage.jsp");

			} else if(tipo.equals("alta")){

				request.getSession().setAttribute("tipo", "alta");
				response.sendRedirect("pages/destinos_adminPage.jsp");

			}else if (tipo.equals("modifica")){

				request.getSession().setAttribute("tipo", "modifica");
				ArrayList<Destino> dd = logicd.getAll();
				request.getSession().setAttribute("listaDestinos", dd);
				response.sendRedirect("pages/destinos_adminPage.jsp");

			}else if (tipo.equals("baja")){

				request.getSession().setAttribute("tipo", "baja");
				ArrayList<Destino> dd = logicd.getAll();
				request.getSession().setAttribute("listaDestinos", dd);
				response.sendRedirect("pages/destinos_adminPage.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (AppDataException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LogicDestino logd = new LogicDestino();
		String tipo = (String) request.getSession().getAttribute("tipo");
		String tipoDestino = request.getParameter("tipoDestino");
		if(tipo.equals("alta")) {
			if(tipoDestino.equals("DestinoDirecto")) {
				DestinoDirecto des = new DestinoDirecto();
				des.setLocalidad(request.getParameter("localidad"));
				double por = Double.parseDouble(request.getParameter("aumento"));
				des.setPorcentajeAumento(por);
				try {
					logd.insert(des);
				} catch (AppDataException e) {
					e.printStackTrace();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			} else {
				Destino des = new Destino();
				des.setLocalidad(request.getParameter("localidad"));
				try {
					logd.insert(des);
				} catch (AppDataException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}else if(tipo.equals("modifica")) {
			LogicDestino logicd = new LogicDestino();
			int id = Integer.parseInt(request.getParameter("idDestino"));
			String loc = (String) request.getParameter("localidad");
			double por = Double.parseDouble(request.getParameter("aumento"));
			Destino d = new Destino(id);
			Destino destinoUpdate = null;
			try {
				destinoUpdate = logicd.getById(d);
			} catch (AppDataException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(loc  != ""){
				destinoUpdate.setLocalidad(loc);
			}
			
			if(por != 0.0) {
				((DestinoDirecto) destinoUpdate).setPorcentajeAumento(por);
			}
			try {
				logicd.update(destinoUpdate);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if(tipo.equals("baja")) {
			LogicDestino logicd = new LogicDestino();
			int id = Integer.parseInt(request.getParameter("idDestino"));
			Destino d = new Destino(id);
			try {
				logicd.delete(d);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("ServletDestino?tipo=consulta");

	}
}
