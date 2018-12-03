package consola_para_pruebas;

import entities.Micro;
import entities.MicroCama;

public class SubClaseAsignadaASuperClase {

	public static void main(String[] args) {
		
		Micro m = null;
		m = new MicroCama();
		m.setPatente("qwerty");
		m.setMarca("Worlkswagen");
		((MicroCama) m).setAumento(1.26);
		m.setButacas(17);
		System.out.println("El microcama asignado a la calse micro es de clase " + m.getClass() + " y el porcentaje"
				+ "de aumento es " + m.getAumento());
		
	}

}
