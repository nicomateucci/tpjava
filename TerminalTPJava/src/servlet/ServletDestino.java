package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import business.LogicDestino;
import entities.Destino;
import entities.DestinoDirecto;
import util.AppDataException;

/**
 * Servlet implementation class ServletDestino
 */
@WebServlet(description = "Servlet que maneja SOLO Destinos en la base de datos.", urlPatterns = { "/ServletDestino" })
public class ServletDestino extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDestino() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LogicDestino logicd = new LogicDestino();
		try {
			String tipo = (String) request.getParameter("tipo");
			if(tipo.equals("consulta")) {
				request.getSession().setAttribute("tipo", "consulta");

				ArrayList<Destino> dd = logicd.getAll();
				//Destino[] miarray = new Destino[dd.size()];
				//dd.toArray( arregloDestinos[dd.size()]);
				request.getSession().setAttribute("listaDestinos", dd);
				request.getSession().setAttribute("nombre", "Nicomateucci");
				//request.getRequestDispatcher("pages/default_adminPage.jsp").forward(request, response);

				response.sendRedirect("pages/destinos_adminPage.jsp");
			} else if(tipo.equals("alta")){
				request.getSession().setAttribute("tipo", "alta");

				response.sendRedirect("pages/destinos_adminPage.jsp");
			}else if (tipo.equals("baja")){
				request.getSession().setAttribute("tipo", "baja");

				response.sendRedirect("pages/destinos_adminPage.jsp");
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
		//JOptionPane.showMessageDialog(null, "Usted envio una peticion al Servlet Destino para agergar un nuevo destino. En breve le informaremos su solicitud.");
		LogicDestino logd = new LogicDestino();
		String tipoDestino = request.getParameter("tipoDestino");
		if(tipoDestino.equals("DestinoDirecto")) {
			DestinoDirecto des = new DestinoDirecto();
			des.setLocalidad(request.getParameter("localidad"));
			double por = Double.parseDouble(request.getParameter("aumento"));
			por = por / 100 + 1;
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
		response.sendRedirect("ServletDestino?tipo=consulta");
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doHead(HttpServletRequest, HttpServletResponse)
	 */
	protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doOptions(HttpServletRequest, HttpServletResponse)
	 */
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
