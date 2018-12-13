package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.LogicServicio;
import util.AppDataException;

@WebServlet(description = "Servlet para mostrar informes al cliente.", urlPatterns = { "/ServletInformesCliente" })
public class ServletInformesCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletInformesCliente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LogicServicio logics = new LogicServicio();
		String[][] datos = null;
		/*Calendar c = Calendar.getInstance();
		Calendar c2 = new GregorianCalendar();
	    dia = Integer.toString(c.get(Calendar.DATE));
	    mes = Integer.toString(c.get(Calendar.MONTH));
	    annio = Integer.toString(c.get(Calendar.YEAR));*/
		try {
			 datos = logics.getDestinosByMesAno(Calendar.DATE, Calendar.YEAR);
		} catch (AppDataException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("informeDestinos", datos);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
