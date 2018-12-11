package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import business.LogicPersona;
import business.LogicServicio;
import entities.Usuario;
import util.AppDataException;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet(description = "Server para manejar el login al sistema.", urlPatterns = { "/ServletLogin" })
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LogicPersona logPer = new LogicPersona();

		Usuario user = new Usuario();
		user.setNombreUsuario(request.getParameter("textUsuario"));
		user.setContrasena(request.getParameter("textContrasena"));
		try {
			user = logPer.getLogedUser(user);
			if(user != null) {
				if(user.esAdmin()) {
					System.out.println("Ingreso correcto como administrador");
					request.getSession().setAttribute("mensaje", null);
					LogicServicio logs = new LogicServicio();
					try {
						request.getSession().setAttribute("listaRecaudacionMes", logs.getRecaudacionPorMes());
					} catch (AppDataException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					response.sendRedirect("./pages/adminPage.jsp");
				}else {
					System.out.println("Ingreso correcto");
					ArrayList<Usuario> usuarios = logPer.getAllUsuarios();
					request.getSession().setAttribute("listaUsuarios", usuarios);
					request.getSession().setAttribute("mensaje", null);

					//Mostrar informe de destinos mas solicitados
					LogicServicio logics = new LogicServicio();
					String[][] datos = null;
					Calendar c1 = Calendar.getInstance();
					int ano= (c1.get(Calendar.YEAR));
					int mes = (c1.get(Calendar.MONTH));
					System.out.println("EL MES de hoy es " + mes);
					System.out.println("EL AÑO de hoy es " + ano);
					try {
						datos = logics.getDestinosByMesAno(mes, ano);
					} catch (AppDataException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					request.getSession().setAttribute("informeDestinos", datos);
					response.sendRedirect("./welcome.jsp");
				}
				request.getSession().setAttribute("usuarioLogeado", user);

			}else {
				request.getSession().setAttribute("mensaje", "Usuario incorrecto o inexistente");
				//request.setAttribute("mensaje", "Usuario incorrecto o inexistente");
				System.out.println("No se encontro al usuario");
				response.sendRedirect("./pages/loginUsuario.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
