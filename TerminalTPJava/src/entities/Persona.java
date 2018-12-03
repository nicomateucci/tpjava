package entities;

public class Persona {
	
	private String dni;
	private String nombre;
	private String apellido;
	private String tipoDni;
	private java.sql.Date fechaNacimiento;
	private boolean esAdmin;
	
	public Persona() {}
	public Persona(String dni) {
		this.setDni(dni);
	}
	public boolean getEsAdmin() {
		return esAdmin;
	}
	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTipoDni() {
		return tipoDni;
	}
	public void setTipoDni(String tipoDni) {
		this.tipoDni = tipoDni;
	}
	public java.sql.Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(java.sql.Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public boolean esAdmin() {
		if(this.getEsAdmin()){
			return true;
		}else {
			return false;
		}
	}

}
