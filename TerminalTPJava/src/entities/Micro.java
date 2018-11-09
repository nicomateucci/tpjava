package entities;

import java.io.Serializable;
import java.util.ArrayList;
import entities.Usuario;;

public class Micro implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public String patente;
	public ArrayList<Conductor> conductores;
	public Butaca[] pasajeros;
	public String marca;
	public java.sql.Date fechaUltimoCtrl;
	
	public Micro() {
		conductores = new ArrayList<Conductor>();
	}
	
	
	public ArrayList<Conductor> getConductores() {
		return conductores;
	}

	public void addConductor(Conductor con) {
		
		conductores.add(con);
	}
	public void setPasajeros(int numButacas) {
		
		pasajeros = new Butaca[numButacas];
		
	}
	public void setPasajero(int numButaca, Usuario pasajero) {
		
		pasajeros[numButaca].setPasajero(pasajero);
	}
	public Usuario getPasajero(int numButaca) {
		
		return pasajeros[numButaca].getPasajero();
	}
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
	

}
