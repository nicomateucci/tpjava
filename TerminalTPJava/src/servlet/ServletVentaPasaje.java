package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.LogicMicro;
import business.LogicServicio;
import entities.Butaca;
import entities.Micro;
import entities.MicroCama;
import entities.Servicio;
import util.AppDataException;

@WebServlet("/ServletVentaPasaje")
public class ServletVentaPasaje extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletVentaPasaje() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Servicio ser = null;
		LogicServicio logs = new LogicServicio();
		int id = Integer.parseInt(request.getParameter("idServicio"));
		try {
			ser = logs.getServicioParaVenta(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("servicio", ser);
		request.getSession().setAttribute("estadoventa", "SELECCIONARMICRO");
		response.sendRedirect("pages/ventaPasaje.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("estadoventa").equals("SELECCIONARMICRO")) {
			LogicMicro logicm = new LogicMicro();
			String patente = (String) request.getParameter("patente");
			Servicio ser = (Servicio) request.getSession().getAttribute("servicio");			
			Micro mic = null;
			Micro m = null;
			try {
				if(logicm.esCama(patente)) {
					mic = new MicroCama(patente);
					m = logicm.getByPatente(mic);
				}else{
					mic = new Micro(patente);
					m = logicm.getByPatente(mic);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (AppDataException e) {
				e.printStackTrace();
			}
			if(m != null) {
				int num = ser.getMicros().indexOf(m);
				Butaca[] but = ser.getMicros().get(num).getButacas();
				request.getSession().setAttribute("pasajeros", but);
				request.getSession().setAttribute("estadoventa", "SELECCIONARBUTACA");
				response.sendRedirect("pages/ventaPasaje.jsp");
			}

		}
		if(request.getSession().getAttribute("estadoventa").equals("SELECCIONARBUTACA")) {



		}

	}


}
