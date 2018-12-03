package entities;

public class Butaca {
	private int numero;
	private Usuario pasajero;
	
	public Butaca() {
		pasajero = new Usuario();
	}
	public Butaca(int i) {
		this.setNumero(i);
	}
	public int getNumero() {
		return numero;
	}
	//Creo que el setButaca no deberia ser publico, porque no sse puede modificar desde el lado de la UI.
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
