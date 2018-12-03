package entities;

public class Usuario extends Persona {

	public Usuario(String dni) {
		super(dni);
		// TODO Auto-generated constructor stub
	}
	private String nombreUsuario;
	private String contrasena;
	private String email;
	
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
	public void setContrasena(String c) {
		this.contrasena = c;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
