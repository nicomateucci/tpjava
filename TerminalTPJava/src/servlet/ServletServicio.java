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
import business.LogicPersona;
import business.LogicServicio;
import entities.Conductor;
import entities.Destino;
import entities.Micro;
import entities.MicroCama;
import entities.Servicio;
import util.AppDataException;

/**
 * Servlet implementation class ServletServicio
 */
@WebServlet("/ServletServicio")
public class ServletServicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletServicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LogicServicio logics = new LogicServicio();
		try {
			//String tipo = (String) request.getParameter("tipo");
			String tipo = "alta";
			if(tipo.equals("consulta")) {
				request.getSession().setAttribute("tipo", "consulta");

				ArrayList<Servicio> ss = logics.getDetalles();
				//int cantServicios = ss.size();
				//boolean refuerzos[] = null;


				/*for (int i = 0; i < cantServicios; i++){
				refuerzos[i] = logics.getTieneRefuerzo(ss.get(i));
			}*/


				//request.getSession().setAttribute("arregloRefuerzos", refuerzos);
				request.getSession().setAttribute("listaServicios", ss);
				response.sendRedirect("pages/servicios_adminPage.jsp");
			} else if(tipo.equals("alta")){
				request.getSession().setAttribute("tipo", "alta");

				request.getSession().setAttribute("estadoServicio", "CARGAID");

				Servicio ser = new Servicio();
				request.getSession().setAttribute("servicio", ser);

				response.sendRedirect("pages/servicios_adminPage.jsp");
			}else if (tipo.equals("baja")){
				request.getSession().setAttribute("tipo", "baja");

				response.sendRedirect("pages/servicios_adminPage.jsp");
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

		LogicDestino logicd = new LogicDestino();
		LogicPersona logicc = new LogicPersona();
		LogicMicro logicm = new LogicMicro();
		Servicio ser = (Servicio) request.getSession().getAttribute("servicio");
		ArrayList<Destino> dd = null;
		ArrayList<Micro> mm = null;
		ArrayList<Conductor> cc= null;

		//5 estados de la carga del servicio: CARGAID, CARGADESTINO, CARGAMICRO, CARGACONDCUTOR, SERVICIOAGREGADO
		//4 estados de la varga de destinos: CARGADESTINOCANTIDAD, CARGADESTINOORIGEN, CARGADESTINOSIGUIENTE, CARGADESTINOFIN
		String estado = (String) request.getSession().getAttribute("estadoServicio");
		switch (estado) {
		case "CARGAID":

			//----------Parseo de fecha
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = null;
			java.sql.Date sqlDate = null;
			try {
				date = format.parse(request.getParameter("fechaServicio"));
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			sqlDate = new java.sql.Date(date.getTime());  

			ser.setFechaServicio(sqlDate);
			ser.setHoraServicio(request.getParameter("horaServicio"));

			try {
				dd = logicd.getAll();
			} catch (AppDataException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getSession().setAttribute("listaDestinos", dd);
			request.getSession().setAttribute("estadoServicio", "CARGADESTINO");
			request.getSession().setAttribute("contadorDestinos", 0);
			String tipoDestino = request.getParameter("tipoServicio");
			if(tipoDestino.equals("ServicioNormal")) {

				request.getSession().setAttribute("estadoCargaDestino", "CARGADESTINOCANTIDAD");
			} else {
				request.getSession().setAttribute("estadoCargaDestino", "CARGADESTINOORIGEN");
				request.getSession().setAttribute("cantDestinos", 2);
			}
			response.sendRedirect("pages/servicios_adminPage.jsp");
			break;
		case "CARGADESTINO":

			String estadoCargaDestino = (String) request.getSession().getAttribute("estadoCargaDestino");
			Destino d = null;

			if(estadoCargaDestino.equals("CARGADESTINOCANTIDAD")) {
				int cantDestinos = Integer.parseInt(request.getParameter("cantDestinos"));
				request.getSession().setAttribute("cantDestinos", cantDestinos);
				try {
					dd = logicd.getAll();
				} catch (AppDataException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.getSession().setAttribute("listaDestinos", dd);
				request.getSession().setAttribute("estadoCargaDestino", "CARGADESTINOORIGEN");

				response.sendRedirect("pages/servicios_adminPage.jsp");
			}

			if(estadoCargaDestino.equals("CARGADESTINOORIGEN")) {
				request.getSession().setAttribute("contadorDestinos", 1);
				try {
					dd = logicd.getAll();
				} catch (AppDataException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.getSession().setAttribute("listaDestinos", dd);
				int idDestino = Integer.parseInt(request.getParameter("idDestino"));
				Destino d2 = new Destino(idDestino);
				try {
					d = logicd.getById(d2);
				} catch (AppDataException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				d.setOrdenDestino(1);
				d.setPrecioDestino(0.0);
				ser.addDestino(d);


				if((int) request.getSession().getAttribute("cantDestinos") == 2) {
					request.getSession().setAttribute("estadoCargaDestino", "CARGADESTINOFIN");
				}else {
					request.getSession().setAttribute("estadoCargaDestino", "CARGADESTINOSIGUIENTE");
				}
				response.sendRedirect("pages/servicios_adminPage.jsp");
			}
			if(estadoCargaDestino.equals("CARGADESTINOSIGUIENTE")) {
				int contador = (int) request.getSession().getAttribute("contadorDestinos");
				request.getSession().setAttribute("contadorDestinos", contador++);
				try {
					dd = logicd.getAll();
				} catch (AppDataException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.getSession().setAttribute("listaDestinos", dd);
				int idDestino = Integer.parseInt(request.getParameter("idDestino"));
				Double precio = Double.parseDouble(request.getParameter("precio"));
				Destino d2 = new Destino(idDestino);
				try {
					d = logicd.getById(d2);
				} catch (AppDataException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				d.setPrecioDestino(precio);
				d.setOrdenDestino(contador);
				ser.addDestino(d);

				if(contador == (int) request.getSession().getAttribute("cantDestinos") - 1) {
					request.getSession().setAttribute("estadoCargaDestino", "CARGADESTINOFIN");
				}
				response.sendRedirect("pages/servicios_adminPage.jsp");
			}
			if(estadoCargaDestino.equals("CARGADESTINOFIN")) {


				int contador = (int) request.getSession().getAttribute("contadorDestinos");
				contador++;
				request.getSession().setAttribute("contadorDestinos", contador);
				int idDestino = Integer.parseInt( request.getParameter("idDestino"));
				Double precio = Double.parseDouble(request.getParameter("precio"));
				if((int) request.getSession().getAttribute("cantDestinos") == 2) {
					//------------------------------------------------------------------------
					//Tengo que agregar el if por el caso de que se ingrese un Destino Directo


					Destino des = new Destino(idDestino);

					try {
						d = logicd.getById(des);
					} catch (AppDataException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					d.setPrecioDestino(precio);
					d.setOrdenDestino(contador);
					ser.addDestino(d);
				}
				try {
					mm = logicm.getAll();
				} catch (AppDataException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.getSession().setAttribute("listaMicros", mm);

				request.getSession().setAttribute("estadoServicio", "CARGAMICRO");
				response.sendRedirect("pages/servicios_adminPage.jsp");
			}

			break;
		case "CARGAMICRO":

			String patente = request.getParameter("patenteMicro");
			try {
				if(logicm.esCama(patente)) {
					MicroCama m = new MicroCama();
					m.setPatente(patente);
					ser.addMicro(logicm.getByPatente(m));
				}else{
					Micro m = new Micro();
					m.setPatente(patente);
					ser.addMicro(logicm.getByPatente(m));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (AppDataException e) {
				e.printStackTrace();
			}
			patente = request.getParameter("patenteRefuerzo");
			if(patente != "") {
				try {
					if(logicm.esCama(patente)) {
						MicroCama m = new MicroCama();
						m.setPatente(patente);
						ser.addMicro(logicm.getByPatente(m));
					}else{
						Micro m = new Micro();
						m.setPatente(patente);
						ser.addMicro(logicm.getByPatente(m));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (AppDataException e) {
					e.printStackTrace();
				}
			}
			try {
				cc = logicc.getAllConductores();
			} catch (AppDataException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getSession().setAttribute("listaConductores", cc);
			request.getSession().setAttribute("estadoServicio", "CARGACONDUCTOR");
			response.sendRedirect("pages/servicios_adminPage.jsp");
			break;
		case "CARGACONDUCTOR":

			Conductor c = new Conductor();
			
			String dni = request.getParameter("dni");
			try {
				c = (Conductor) logicc.getByDni(dni);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			ser.getMicros().get(0).addConductor(c);


			dni = request.getParameter("dni2");
			try {
				c = (Conductor) logicc.getByDni(dni);
			} catch (Exception e) {
				e.printStackTrace();
			}
			dni = request.getParameter("dniRef");
			try {
				c = (Conductor) logicc.getByDni(dni);
			} catch (Exception e) {
				e.printStackTrace();
			}
			dni = request.getParameter("dniRef2");
			try {
				c = (Conductor) logicc.getByDni(dni);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("Id servicio, fechaServicio, horaServicio, tipo servicio" + ser.getIdServicio() + ser.getFechaServicio() + ser.getHoraServicio() + request.getParameter("tipoServicio"));
			break;
		}
	}
}


