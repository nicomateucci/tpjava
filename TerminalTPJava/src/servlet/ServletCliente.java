package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.LogicPersona;
import entities.Conductor;
import entities.Usuario;
import util.AppDataException;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LogicPersona logicp = new LogicPersona();
		try {
			ArrayList<Usuario> uu = logicp.getAllUsuarios();
			//Destino[] miarray = new Destino[dd.size()];
			//dd.toArray( arregloDestinos[dd.size()]);
			request.getSession().setAttribute("listaUsuarios", uu);
			request.getSession().setAttribute("nombre", "Nicomateucci");
			//miarray = dd.toArray(miarray);
			//request.getRequestDispatcher("pages/default_adminPage.jsp").forward(request, response);
			
			response.sendRedirect("pages/clientes_adminPage.jsp");
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

}
