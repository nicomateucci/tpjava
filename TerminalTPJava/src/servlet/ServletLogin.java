package servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
					//JOptionPane.showMessageDialog(null, "Usted ingreso como administrador"); Tuve problemas con mostrar paneles desde el servidor.
					PrintWriter out = response.getWriter();  
					response.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Esta en la pagina impresion del boleto')");  
					out.println("</script>");
					System.out.println("Ingreso correcto como administrador");
					response.sendRedirect("./pages/adminPage.jsp");
				}else {
					//JOptionPane.showMessageDialog(null, "Ingreso correcto");
					System.out.println("Ingreso correcto");
					response.sendRedirect("./welcome.jsp");
				}
			request.getSession().setAttribute("usuarioLogeado", userOk);

			}else {
				//JOptionPane.showMessageDialog(null, "No se encontro es usuario ingresado");
				PrintWriter out = response.getWriter();  
				response.setContentType("text/html");  
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('No se encontro el usuario ingresado')");  
				out.println("</script>");
				System.out.println("No se encontro al usuario");
				response.sendRedirect("./pages/LoginUsuario.html");
			}


		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
