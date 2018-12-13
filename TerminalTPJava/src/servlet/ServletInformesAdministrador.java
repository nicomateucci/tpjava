package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.LogicServicio;
import util.AppDataException;

@WebServlet(name = "ServletInformesAdministrador", description = "Servlet para manejo de informes del usuario administracion", urlPatterns = { "/ServletInformesAdministrador" })
public class ServletInformesAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletInformesAdministrador() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LogicServicio logs = new LogicServicio();
		if(request.getParameter("tipoReporte").equals("recaudacionPorMes")) {
			try {
				request.getSession().setAttribute("listaRecaudacionMes", logs.getRecaudacionPorMes());
			} catch (AppDataException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}



	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
