package entities;

import java.io.Serializable;

public class Destino implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idDestino;
	private String localidad;
	private int ordenDestino;
	private Double precioDestino;
	
	public double getPorcentajeAumento() {
		return 0.0;
	}
	public int getOrdenDestino() {
		return ordenDestino;
	}
	public void setOrdenDestino(int ordenDestino) {
		this.ordenDestino = ordenDestino;
	}

	public Double getPrecioDestino() {
		return precioDestino;
	}

	public void setPrecioDestino(Double precioDestino) {
		this.precioDestino = precioDestino;
	}
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
	public Destino(int id) {
		this.setIdDestino(id);
	}

}
