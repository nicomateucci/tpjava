package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.LogicServicio;
import entities.Destino;
import entities.Micro;
import entities.Servicio;
import entities.Usuario;
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
					request.getSession().setAttribute("micro", micro);
					request.getSession().setAttribute("estadoventa", "SELECCIONARBUTACA");
					response.sendRedirect("pages/ventaPasaje.jsp");
				}
			}
			if( !(micro instanceof Micro) ){
				PrintWriter out = response.getWriter();  
				response.setContentType("text/html");  
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Como no se encontro el micro ingresado, lo redirigiremos de nuevo a la pagina.')");  
				out.println("</script>");
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
			}else {
				dni = user.getDni();
			}
			request.getSession().setAttribute("dni", dni);
			try {
				logics.addPasajero(servicio.getIdServicio(), dni, mic.getPatente(), butaca);
			} catch (AppDataException e) {
				e.printStackTrace();
			}
			request.getSession().setAttribute("estadoventa", "IMPRIMIRBOLETO");
			response.sendRedirect("pages/impresionBoleto/impresionBoleto.jsp");
			break;

		case "IMPRIMIRBOLETO":

			user = (Usuario) request.getSession().getAttribute("usuarioLogeado");
			if(user == null) {
				response.sendRedirect("index.html");
			}else {
				response.sendRedirect("welcome.jsp");
			}
			break;
		}
	}
}


