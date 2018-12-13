package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.LogicDestino;
import business.LogicServicio;
import entities.Destino;
import entities.Servicio;
import util.AppDataException;
import util.NoDestinoException;
import util.NoServiceException;

/**
 * Servlet implementation class ServletBuscarServicios
 */
@WebServlet("/ServletBuscarServicios")
public class ServletBuscarServicios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletBuscarServicios() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Destino origen = null;
		Destino destino = null;
		ArrayList<Servicio> ss = null;
		LogicDestino logd = new LogicDestino();

		String orig = request.getParameter("textOrigen");
		String dest = request.getParameter("textDestino");
		try {
			origen = logd.getByNombre(orig);
			destino = logd.getByNombre(dest);
			//System.out.println(origen.getLocalidad());
			//System.out.println(destino.getLocalidad());
			LogicServicio logSer = new LogicServicio();
			ss = logSer.getAllByDestinos(origen, destino);

			request.getSession().setAttribute("mensaje", null);
			request.getSession().setAttribute("desOrigen",origen);
			request.getSession().setAttribute("desLlegada",destino);
			request.getSession().setAttribute("serviciosEcontrados", ss);
			response.sendRedirect("pages/listarServiciosEcontrados.jsp");

		} catch (NoDestinoException e) {
			request.getSession().setAttribute("mensaje", e.getMessage());
			//System.out.println("No se encontro origen")/destino;
			response.sendRedirect("index.jsp#services");
		} catch (NoServiceException e) {

			request.getSession().setAttribute("mensaje", e.getMessage());
			//System.out.println("No se encontro servicio");
			response.sendRedirect("index.jsp#services");

			//e.printStackTrace();
		}catch (AppDataException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
