package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.FactoryConexion;


/**
 * Servlet implementation class ServletAgregarPersona
 */
@WebServlet("/ServletAgregarPersona")
public class ServletAgregarPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAgregarPersona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		FactoryConexion fc = FactoryConexion.getInstancia();
		
		java.sql.Connection cn = fc.getConn();

		java.sql.Statement stmt = null;

		try {
			stmt = cn.createStatement();
			stmt.executeUpdate("insert into Persona(dni, nombre, apellido, tipoDni, fechaNac, fechaInicio, contacto) values('39159489', 'Juan', 'Pullaro','DNI','1997-06-24','2016-24-06','')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
