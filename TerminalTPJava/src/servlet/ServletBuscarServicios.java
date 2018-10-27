package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import business.LogicDestino;
import business.LogicServicio;
import entities.Destino;
import entities.Servicio;
import util.AppDataException;

/**
 * Servlet implementation class ServletBuscarServicios
 */
@WebServlet(description = "Servlet para buscar servicios en la base de datos segun destino de origen, llegada y fecha.", urlPatterns = { "/ServletBuscarServicios" })
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
					des = request.getParameter("textDestino");
					LogicServicio logSer = new LogicServicio();
					
					//Linea para agregar en el metodo que tambien acepta una fecha como parametro;
					//java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
					
					ss = logSer.getAllByDestinos(d, d2);
					if(!ss.isEmpty()) {
						for(int i = 0; i < ss.size(); i++){
						JOptionPane.showMessageDialog(null, "Encontramos " + ss.size() + " servicio/s numero " + ss.get(i).getIdServicio() + " para la fecha " + ss.get(i).getFechaServicio() + " y la hora " + ss.get(i).getHoraServicio());
						}
						response.sendRedirect("./index.html");
					}else {
						JOptionPane.showMessageDialog(null, "Aun no tenemos servicios para su viaje. En breve ampliaremos nuestros recorridos. Nos vemos luego!.");
						response.sendRedirect("./index.html");
					}
						

				}else {
					JOptionPane.showMessageDialog(null, "Aun no tenemos servicio para el destino ingresado. En breve ampliaremos nuestros recorridos. Nos vemos luego!.");
					response.sendRedirect("./index.html");
				}

			}else {
				JOptionPane.showMessageDialog(null, "Aun no tenemos servicio para el origen ingresado. En breve ampliaremos nuestros recorridos. Nos vemos luego!.");
				response.sendRedirect("./index.html");
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
