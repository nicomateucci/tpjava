package entities;

public class Usuario extends Persona {

	public Usuario(String dni) {
		super(dni);
		// TODO Auto-generated constructor stub
	}
	public String nombreUsuario;
	public String contrasena;
	public String email;
	
	public Usuario() {}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContraseña(String c) {
		this.contrasena = c;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
