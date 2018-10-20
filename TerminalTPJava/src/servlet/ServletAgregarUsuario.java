package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.lang.jpath.example.Person;

import business.LogicPersona;
import data.FactoryConexion;
import entities.Usuario;


/**
 * Servlet implementation class ServletAgregarPersona
 */
@WebServlet("/ServletAgregarPersona")
public class ServletAgregarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAgregarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//stmt = cn.createStatement();
		//stmt.executeUpdate("insert into Persona(dni, nombre, apellido, tipoDni, fechaNac, fechaInicio, contacto) values('39159489', 'Juan', 'Pullaro','DNI','1997-06-24','2016-06-24','asdf')");
		LogicPersona logPer = new LogicPersona();

		
		Usuario usu = new Usuario();
		
		usu.setNombre(request.getParameter("nombre"));
		usu.setApellido(request.getParameter("apellido"));
		usu.setDni(request.getParameter("dni"));
		usu.setTipoDni(request.getParameter("tipoDni"));
		
		
		//----------Parseo de fecha
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		java.sql.Date sqlDate = null;
		try {
			date = format.parse(request.getParameter("fecha"));
			sqlDate = new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		usu.setFechaNacimiento(sqlDate);
		//----------------------------------------
		
		usu.setNombreUsuario(request.getParameter("nombreU"));
		usu.setContraseña(request.getParameter("password"));
		usu.setEmail(request.getParameter("mail"));
		
		// Ejemplo de fecha dormateada a JAVA.SQL.DATE
		/*
		String startDate="23-05-2018";
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date date = sdf1.parse(startDate);
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());  
		*/
		try {
			logPer.add(usu);
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
