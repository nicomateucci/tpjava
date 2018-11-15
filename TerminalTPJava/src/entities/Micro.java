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
	public Micro(String patente) {
		conductores = new ArrayList<Conductor>();
		this.setPatente(patente);
	}
	
	
	public ArrayList<Conductor> getConductores() {
		return conductores;
	}

	public Butaca getButaca(int num) {
		return pasajeros[num];
		
	}
	public Butaca[] getPasajeros() {
		return pasajeros;
	}
	public void setPasajeros(Butaca[] pasajeros) {
		this.pasajeros = pasajeros;
	}
	public void setConductores(ArrayList<Conductor> conductores) {
		this.conductores = conductores;
	}
	public void addConductor(Conductor con) {
		
		conductores.add(con);
	}
	public void setPasajeros(int numButacas) {
		
		pasajeros = new Butaca[numButacas];
		
	}
	public void setPasajero(int numButaca, Usuario p) {
		
		int x = numButaca;
		Usuario p2 = p;
		pasajeros[x].setPasajero(p2);
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
