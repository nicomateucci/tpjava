package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import business.LogicPersona;
import entities.Usuario;

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
		// TODO Auto-generated method stub

		Usuario user = new Usuario();
		LogicPersona logPer = new LogicPersona();
		user.setNombreUsuario(request.getParameter("textUsuario"));
		user.setContrasena(request.getParameter("textContrasena"));
		try {
			Usuario userOk = logPer.getLogedUser(user);
			if(userOk != null) {
				if(userOk.esAdmin()) {
					System.out.println("Ingreso correcto como administrador");
					request.getSession().setAttribute("mensaje", null);
					response.sendRedirect("./pages/adminPage.jsp");
				}else {
					System.out.println("Ingreso correcto");
					ArrayList<Usuario> usuarios = logPer.getAllUsuarios();
					request.getSession().setAttribute("listaUsuarios", usuarios);
					request.getSession().setAttribute("mensaje", null);
					response.sendRedirect("./welcome.jsp");
				}
			request.getSession().setAttribute("usuarioLogeado", userOk);

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
