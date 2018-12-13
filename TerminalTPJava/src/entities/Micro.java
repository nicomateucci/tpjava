package entities;

import java.io.Serializable;
import java.util.ArrayList;
import entities.Usuario;
import java.util.Arrays;

public class Micro implements Serializable,Comparable <Micro>{

	private static final long serialVersionUID = 1L;

	private String patente;
	private ArrayList<Conductor> conductores;
	private Butaca butacas[];
	private String marca;
	private java.sql.Date fechaUltimoCtrl;
	private int cantidadButacas;
	private int cantidadServicios;

	public double getAumento() {
		return 0.0;
	}
	public void setCantidadButacas(int cantidadButacas) {
		this.cantidadButacas = cantidadButacas;
	}
	public int getCantidadButacas() {
		return cantidadButacas;
	}
	public void addPasajero(Usuario pasajero, int numButaca) {
		butacas[--numButaca].setPasajero(pasajero);
	}
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
		return butacas[num];

	}
	public Butaca[] getButacas() {
		return butacas;
	}
	public void setButacas(Butaca[] pasajeros) {
		this.butacas = pasajeros;
	}
	public void setButacas(int numButacas) {
		butacas = new Butaca[numButacas];
		for(int i = 0; i < numButacas; i++) {
			butacas[i] = new Butaca();
		}
	}
	
	public void setConductores(ArrayList<Conductor> conductores) {
		this.conductores = conductores;
	}
	public void addConductor(Conductor con) {

		conductores.add(con);
	}
	public Usuario getPasajero(int numButaca) {

		return butacas[numButaca].getPasajero();
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
	public int getCantidadServicios() {
		return cantidadServicios;
	}
	public void setCantidadServicios(int cantidadServicios) {
		this.cantidadServicios = cantidadServicios;
	}
	
	@Override
    public int compareTo(Micro m) {
        if (cantidadServicios < m.getCantidadButacas()) {
            return -1;
        }
        if (cantidadServicios > m.getCantidadServicios()) {
            return 1;
        }
        return 0;
    }
	
	
}
