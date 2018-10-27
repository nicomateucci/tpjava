package entities;

public class Destino {
	
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
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public float precio;

}
