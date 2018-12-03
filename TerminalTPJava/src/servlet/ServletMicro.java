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

import business.LogicDestino;
import business.LogicMicro;
import entities.Butaca;
import entities.Destino;
import entities.DestinoDirecto;
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
				request.getSession().setAttribute("nombre", "Nicomateucci");

				response.sendRedirect("pages/micros_adminPage.jsp");
			} else if(tipo.equals("alta")){
				request.getSession().setAttribute("tipo", "alta");

				response.sendRedirect("pages/micros_adminPage.jsp");
			}else if (tipo.equals("baja")){
				request.getSession().setAttribute("tipo", "baja");

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

		LogicMicro logicm = new LogicMicro();
		String tipoMicro = request.getParameter("tipoMicro");
		Micro m = null;
		
		if(tipoMicro.equals("MicroCama")) {
			m = new MicroCama();
			double por = Double.parseDouble(request.getParameter("aumento"));
			por = por / 100 + 1;
			((MicroCama) m).setAumento(por);
		}else {
			m = new Micro();
		}
		System.out.println("El micro cargado es de la clase " + m.getClass());
		m.setPatente(request.getParameter("patente"));
		m.setMarca(request.getParameter("marca"));
		int num = Integer.parseInt(request.getParameter("cantButacas"));
		m.setButacas(num);
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
		response.sendRedirect("ServletMicro?tipo=consulta");
	}
}

