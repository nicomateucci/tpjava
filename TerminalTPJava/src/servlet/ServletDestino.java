package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.LogicDestino;
import entities.Destino;
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
			ArrayList<Destino> dd = logicd.getAll();
			//Destino[] miarray = new Destino[dd.size()];
			//dd.toArray( arregloDestinos[dd.size()]);
			request.getSession().setAttribute("listaDestinos", dd);
			request.getSession().setAttribute("nombre", "Nicomateucci");
			//miarray = dd.toArray(miarray);
			//request.getRequestDispatcher("pages/default_adminPage.jsp").forward(request, response);
			
			response.sendRedirect("pages/destinos_adminPage.jsp");
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
		// TODO Auto-generated method stub
		doGet(request, response);
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
