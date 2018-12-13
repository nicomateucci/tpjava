package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.LogicPersona;
import business.LogicServicio;
import entities.Destino;
import entities.Micro;
import entities.Servicio;
import entities.Usuario;
import util.AppDataException;
import util.NoServiceException;

@WebServlet("/ServletVentaPasaje")
public class ServletVentaPasaje extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletVentaPasaje() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Servicio serv = null;
		LogicServicio logs = new LogicServicio();
		ArrayList<Servicio> ss = (ArrayList<Servicio>) request.getSession().getAttribute("serviciosEcontrados");
		int id = Integer.parseInt(request.getParameter("idServicio"));
		
		try {
			serv = (Servicio) logs.getById(id);
			
			request.getSession().setAttribute("mensaje", null);
			if(ss.contains(serv)) {
				request.getSession().setAttribute("servicio", serv);
				request.getSession().setAttribute("estadoventa", "SELECCIONARMICRO");
				ArrayList<Micro> mm = serv.getMicros()	;
				request.getSession().setAttribute("listaMicros", mm);
				System.out.println("servicios: " + serv.getIdServicio());
				response.sendRedirect("pages/ventaPasaje.jsp");
			}
			else {
				request.getSession().setAttribute("mensaje", "servicio no encontrado para la lista");
				System.out.println("servicio no encontrado para la lista");
				request.getSession().setAttribute("serviciosEcontrados", ss);
				response.sendRedirect("pages/listarServiciosEcontrados.jsp");
			
			}
		} catch (AppDataException e) {
			e.printStackTrace();
		} catch (NoServiceException e) {
			request.getSession().setAttribute("mensaje", e.getMessage());
			request.getSession().setAttribute("serviciosEcontrados", ss);
			response.sendRedirect("pages/listarServiciosEcontrados.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*try {
			ser = logs.getServicioParaVenta(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("servicio", ser);
		request.getSession().setAttribute("estadoventa", "SELECCIONARMICRO");
		ArrayList<Micro> mm = ser.getMicros()	;
		request.getSession().setAttribute("listaMicros", mm);
		response.sendRedirect("pages/ventaPasaje.jsp");*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LogicPersona logp = null;
		Servicio ser = null;
		String estado = (String) request.getSession().getAttribute("estadoventa");
		switch (estado) {
		case "SELECCIONARMICRO":
			String patente = (String) request.getParameter("patente").toUpperCase();
			ser = (Servicio) request.getSession().getAttribute("servicio");	
			Micro micro = null;
			for(Micro m: ser.getMicros()) {
				if(m.getPatente().equals(patente) ) {
					micro = m; //Hago este asignacion para conocer el micro encontrado afuera del foreach.
					request.getSession().setAttribute("micro", m);
					request.getSession().setAttribute("estadoventa", "SELECCIONARBUTACA");
					response.sendRedirect("pages/ventaPasaje.jsp");
				}
			}
			if( !(micro instanceof Micro) ){
				//No encontro el micro ingresado, redirige al mismo lugar.
				response.sendRedirect("pages/ventaPasaje.jsp");
			}
			break;

		case "SELECCIONARBUTACA":

			int numButaca = Integer.parseInt(request.getParameter("numButaca"));
			request.getSession().setAttribute("numButaca", numButaca);
			request.getSession().setAttribute("estadoventa", "PAGARBOLETO");
			response.sendRedirect("pages/detallesPagoTarjeta/mostrarTarjeta.jsp");
			break;

		case "PAGARBOLETO":

			String dni = null;
			LogicServicio logics= new LogicServicio();
			Usuario user = (Usuario) request.getSession().getAttribute("usuarioLogeado");
			Micro mic = (Micro) request.getSession().getAttribute("micro");
			Servicio servicio = (Servicio) request.getSession().getAttribute("servicio");
			int butaca = (int) request.getSession().getAttribute("numButaca");

			//Calculo del precio del boleto
			//****************************************************************

			Double precioOrigen = null, precioLlegada = null, precioSinAumento, aumentoMicro, aumentoDestino, precioFinal;
			Destino desLlegada = null;
			Destino desOrigenSinPrecio = (Destino) request.getSession().getAttribute("desOrigen");
			Destino desLlegadaSinPrecio = (Destino) request.getSession().getAttribute("desLlegada");
			for(Destino d: servicio.getDestinos()) {
				if(d.getLocalidad().equals(desOrigenSinPrecio.getLocalidad())){
					precioOrigen = d.getPrecioDestino();
				}
				if(d.getLocalidad().equals(desLlegadaSinPrecio.getLocalidad() )){
					precioLlegada = d.getPrecioDestino();
					desLlegada = d;
				}
			}
			precioSinAumento = precioLlegada - precioOrigen;
			// 35 / 100= 0.35
			aumentoMicro = precioSinAumento * (mic.getAumento() / 100);
			aumentoDestino = precioSinAumento * (desLlegada.getPorcentajeAumento() / 100);
			precioFinal = precioSinAumento + aumentoDestino + aumentoMicro;
			request.getSession().setAttribute("precio", precioFinal);

			//Fin calculo del precio **********************************************

			if(user == null) {
				dni = (String) request.getParameter("dniPasajero");
				Usuario u = new Usuario(dni);
				logp = new LogicPersona();
				try {
					logp.add(u);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (AppDataException e) {
					e.printStackTrace();
				}
			}else {
				dni = user.getDni();
			}
			request.getSession().setAttribute("dni", dni);
			try {
				logics.addPasajero(servicio.getIdServicio(), dni, mic.getPatente(), butaca, desOrigenSinPrecio.getIdDestino(), desLlegadaSinPrecio.getIdDestino(), precioFinal);
			} catch (AppDataException e) {
				e.printStackTrace();
			}
			request.getSession().setAttribute("estadoventa", "IMPRIMIRBOLETO");
			response.sendRedirect("pages/impresionBoleto/impresionBoleto.jsp");
			break;

		case "IMPRIMIRBOLETO":

			user = (Usuario) request.getSession().getAttribute("usuarioLogeado");
			if(user == null) {
				response.sendRedirect("index.jsp");
			}else {
				//Para que actualice la estadistica de destinos despues de la venta de uno, deberia usar AJAX en welcome.jsp
				response.sendRedirect("welcome.jsp");
			}
			break;
		}
	}
}


