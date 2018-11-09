package entities;

public class Butaca {
	public int numero;
	public Usuario pasajero;
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Usuario getPasajero() {
		return pasajero;
	}
	public void setPasajero(Usuario u) {
		this.pasajero = u;
	}

}
