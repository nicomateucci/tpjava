package entities;

import java.io.Serializable;

public class Destino implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int idDestino;
	public String localidad;
	public int getIdDestino() {
		return idDestino;
	}
	public void setIdDestino(int codigo) {
		this.idDestino = codigo;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public Destino() {}

}
