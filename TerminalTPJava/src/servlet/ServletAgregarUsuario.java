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
import javax.swing.JOptionPane;

import org.apache.taglibs.standard.lang.jpath.example.Person;

import business.LogicPersona;
import data.FactoryConexion;
import entities.Usuario;
import util.AppDataException;


/**
 * Servlet implementation class ServletAgregarPersona
 */
@WebServlet("/ServletAgregarPersona")
public class ServletAgregarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAgregarUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LogicPersona logPer = new LogicPersona();
		Usuario usu = new Usuario();
		
		String nom = request.getParameter("nombre");
		if(nom == "") {
			JOptionPane.showMessageDialog(null, "Ingreso en el if(nom == vacio");
			System.out.println("Ingreso al if");
			usu.setNombre(nom);
		}
		
		usu.setApellido(request.getParameter("apellido"));
		usu.setDni(request.getParameter("dni"));
		usu.setTipoDni(request.getParameter("tipoDni"));
		
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
		usu.setContrasena(request.getParameter("password"));
		usu.setEmail(request.getParameter("mail"));
		
		// Ejemplo de fecha dormateada a JAVA.SQL.DATE
		/*
		String startDate="23-05-2018";
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date date = sdf1.parse(startDate);
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());  
		*/
		try {
			try {
				logPer.add(usu);
			} catch (AppDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("test");
		response.sendRedirect("pages/AgregarPersona.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
