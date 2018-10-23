package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import util.ControladorCorreo;
import util.Correo;

/**
 * Servlet implementation class ServletEmail
 */
@WebServlet(description = "Servlet que maneja el envio de un email de un usuario del sistema.", urlPatterns = { "/ServletEmail" })
public class ServletEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEmail() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Correo c = new Correo();
		
		c.setPassword("soqxxwlvmwmajjho");
		c.setUsuarioCorreo("nico.mateucci@gmail.com");
		/*
		String nombre = request.getParameter("nombre");
		String telefono = request.getParameter("telefono");
		String mail = request.getParameter("email");*/
		
		c.setAsunto("Mail de prueba de javax.mail");
		c.setMensaje("Espero que anda y lrpmaospdhcwaoisucfnkawrsxfnkazsyebgfxsaunfgxasugxfn");
		//c.setAsunto("Datos usuario: " + nombre + " " + telefono + " " + mail + ".");
		//c.setMensaje(request.getParameter("mensaje"));
		c.setDestino("nico-mateucci@hotmail.com");
		/*
		c.setNombreArchivo("nombreArchivo.zip");
		c.setRutaArchivo("/home/nico/Escritorio/mail.jar.zip");*/
		//gbygbkuygb
		ControladorCorreo ctr = new ControladorCorreo();
		if (ctr.enviarCorreo(c)){
			JOptionPane.showMessageDialog(null, "Correo enviado correctamente");
			System.out.println("Correo enviado con exito");
			response.sendRedirect("/index.html");
		}else {
			JOptionPane.showMessageDialog(null, "Hubo un error al enviar el correo, intente nuevamente!");
			System.out.println("Correo con error");
			response.sendRedirect("/index.html");
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
