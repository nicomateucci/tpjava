package entities;

import java.io.Serializable;

public class Micro implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String patente;
	public Conductor conductor;
	public String marca;
	public java.sql.Date fechaUltimoCtrl;
	
	public Micro() {}
	public java.sql.Date getFechaUltimoCtrl() {
		return fechaUltimoCtrl;
	}
	public void setFechaUltimoCtrl(java.sql.Date fechaUltimoCtrl) {
		this.fechaUltimoCtrl = fechaUltimoCtrl;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public Conductor getConductor() {
		return conductor;
	}
	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

}
