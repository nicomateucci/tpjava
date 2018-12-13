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

import entities.Usuario;
import jdk.incubator.http.HttpResponse;

/**
 * Servlet Filter implementation class FiltroNormalUser
 */
@WebFilter(
		description = "Rechazar conexiones a welcome.jsp si no hay un usuario logeado.", 
		urlPatterns = { 
				"/welcome.jsp", 
				"/welcome.jsf"
		})
public class FiltroNormalUser implements Filter {

	/**
	 * Default constructor. 
	 */
	public FiltroNormalUser() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpSession s = ((HttpServletRequest) request).getSession();
		Usuario u = (Usuario) s.getAttribute("usuarioLogeado");
		if( u != null ) {
			chain.doFilter(request, response);
		}else {
			((HttpServletResponse) response).sendRedirect("index.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
