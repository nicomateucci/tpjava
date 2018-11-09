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
import business.LogicServicio;
import entities.Conductor;
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
			String tipo = (String) request.getParameter("tipo");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
