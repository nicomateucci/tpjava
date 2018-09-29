package data;


import entities.Destino;

public class DataDestino {

	public int idDestino;
	public String localidad;
	public float precio;
	
	public int getIdDestino() {
		return idDestino;
	}
	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
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
	public float getPorcentajeAumento() {
		return porcentajeAumento;
	}

	public void setPorcentajeAumento(float porcentajeAumento) {
		this.porcentajeAumento = porcentajeAumento;
	}
	public float porcentajeAumento;

	
	
	public Destino getById(int idDestino){
		return new Destino();
	}
	/*
	public ArrayList<Destino> getAll(){
		return new ArrayList<Destino>();
	}*/
		
	
	public void insert(Destino elDestino){

	}
	public void update(Destino elDestino){
		
	}
	public void delete(Destino elDestino){
		
	}
	
}
