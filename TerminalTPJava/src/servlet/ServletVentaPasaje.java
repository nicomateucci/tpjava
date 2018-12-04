package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

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
			String patente = (String) request.getParameter("patente").toUpperCase();
			Servicio ser = (Servicio) request.getSession().getAttribute("servicio");	
			Micro micro = null;
			for(Micro m: ser.getMicros()) {
				if(m.getPatente().equals(patente) ) {
					micro = m; //Hago este asignacion para conocer el micro encontrado afuera del foreach.
					Butaca[] but = micro.getButacas();
					request.getSession().setAttribute("pasajeros", but);
					request.getSession().setAttribute("estadoventa", "SELECCIONARBUTACA");
					response.sendRedirect("pages/ventaPasaje.jsp");
				}
			}
			if( ! (micro instanceof Micro) ){
				JOptionPane.showMessageDialog(null, "Como no se encontro el micro ingresado, lo redirigiremos de nuevo a la pagina. (Deberia ver el caso de que si encuentre el Micro, si este codigo se ejecuta igual.)");
				response.sendRedirect("pages/ventaPasaje.jsp");
			}
			
		}
		if(request.getSession().getAttribute("estadoventa").equals("IMPRIMIRBOLETO")) {
			
			
			JOptionPane.showMessageDialog(null, "Ingreso a la seccion de la IMPRESION del BOLETO");


		}

	}


}
