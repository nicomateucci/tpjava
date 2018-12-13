package util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import entities.Usuario;

/**
 * Servlet Filter implementation class FiltroRoot
 */
@WebFilter(description = "Rechazar peticiones de usuario sin clave.", 
urlPatterns = { "/pages/destinos_adminPage.jsf","/pages/destinos_adminPage.jsp",
		"/pages/micros_adminPage.jsf","/pages/micros_adminPage.jsp",
		"/pages/servicios_adminPage.jsf","/pages/servicios_adminPage.jsp",
		"/pages/clientes_adminPage.jsf","/pages/clientes_adminPage.jsp",
		"/pages/conductores_adminPage.jsf","/pages/conductores_adminPage.jsp",
		"/pages/adminPage.jsf","/pages/adminPage.jsp"})
public class FiltroRoot implements Filter {

	public FiltroRoot() {
	}

	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpSession s = ((HttpServletRequest) request).getSession();
		Usuario u = (Usuario) s.getAttribute("usuarioLogeado");
		if( u != null && u.esAdmin()) {
			chain.doFilter(request, response);
		}else {
			((HttpServletResponse) response).sendRedirect("../index.jsp");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
