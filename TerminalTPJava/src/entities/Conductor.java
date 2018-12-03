package entities;

public class Conductor extends Persona{
	
	
	public Conductor() {}
	public Conductor(String dni) {
		super(dni);
		// TODO Auto-generated constructor stub
	}
	private java.sql.Date fechaInicio;
	private String contacto;
	
	public java.sql.Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(java.sql.Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

}
