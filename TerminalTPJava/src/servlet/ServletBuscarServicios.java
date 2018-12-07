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

		Destino d = null;
		Destino d2 = null;
		ArrayList<Servicio> ss = null;
		LogicDestino logd = new LogicDestino();

		String des = request.getParameter("textOrigen");
		try {
			if((d = logd.getByNombre(des)) != null) {
				des = request.getParameter("textDestino");
				if((d2 = logd.getByNombre(des)) != null) {
					LogicServicio logSer = new LogicServicio();
					
					//Linea para agregar en el metodo que tambien acepta una fecha como parametro;
					//java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
					
					ss = logSer.getAllByDestinos(d, d2);
					if(!ss.isEmpty()) {
						request.getSession().setAttribute("desOrigen",d);
						request.getSession().setAttribute("desLlegada",d2);
						request.getSession().setAttribute("serviciosEcontrados", ss);
						response.sendRedirect("pages/listarServiciosEcontrados.jsp");
						
					}else {
						PrintWriter out = response.getWriter();  
						response.setContentType("text/html");  
						out.println("<script type=\"text/javascript\">");  
						out.println("alert('Aun no tenemos servicios para su viaje. En breve ampliaremos nuestros recorridos. Nos vemos luego!.');");  
						out.println("</script>");
						response.sendRedirect("./index.html");
					}
						

				}else {
					PrintWriter out = response.getWriter();  
					response.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Aun no tenemos servicio para el destino ingresado. En breve ampliaremos nuestros recorridos. Nos vemos luego!.');");  
					out.println("</script>");
					response.sendRedirect("./index.html");
				}

			}else {
				PrintWriter out = response.getWriter();  
				response.setContentType("text/html");  
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Aun no tenemos servicio para el origen ingresado. En breve ampliaremos nuestros recorridos. Nos vemos luego!.');");  
				out.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.include(request, response);
				//response.sendRedirect("./index.html");
			}
		} catch (AppDataException e) {
			e.printStackTrace();
		} catch (SQLException e) {

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
