package entities;

public class Conductor extends Persona{
	
	public java.sql.Date fechaInicio;
	public String contacto;
	
	
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
