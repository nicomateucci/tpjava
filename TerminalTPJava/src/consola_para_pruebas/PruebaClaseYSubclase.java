package consola_para_pruebas;

import java.sql.SQLException;
import java.util.Scanner;

import business.LogicDestino;
import entities.Destino;
import entities.DestinoDirecto;
import util.AppDataException;

public class PruebaClaseYSubclase {

	public static void main(String[] args) throws SQLException, AppDataException {

		LogicDestino logicd = new LogicDestino();

		Scanner s = new Scanner(System.in);
				System.out.println("Listado de destinos disponibles para viajar:");
		for(Destino d: logicd.getAll()) {
			if(d.getClass() == DestinoDirecto.class) {
				System.out.println("Id destino: " + d.getIdDestino());
				System.out.println("Localidad: " + d.getLocalidad());
				System.out.println("Porcentaje de aumento:" + ((DestinoDirecto) d).getPorcentajeAumento());
				System.out.println("Soy clase: " + d.getClass());
				System.out.println();
			}else {
				System.out.println("Id destino: " + d.getIdDestino());
				System.out.println("Localidad: " + d.getLocalidad());
				System.out.println("Soy clase: " + d.getClass());
				System.out.println();
			}
		}
		System.out.println("Ingrese el id de un destino:");
		int id = s.nextInt();
		
		Destino des = new Destino(id);
		Destino d2 = logicd.getById(des);
		System.out.println("El destino encontrado se guardo en la clase Destino, pero la clase del destin oencontrado es " + d2.getClass() );
		System.out.println("El metodo instaceof DestinoDirecto aplicado al destino ingresado devolvio:" + (d2 instanceof DestinoDirecto));
		System.out.println("El metodo  logicd.getById(destinoIngresado) directo a la BD devolvio un destino de la clase :" + (logicd.getById(des).getClass()));
		s.close();
	}
}
