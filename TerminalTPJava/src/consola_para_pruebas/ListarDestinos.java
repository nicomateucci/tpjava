package consola_para_pruebas;

import java.sql.SQLException;

import business.LogicDestino;
import entities.Destino;
import entities.DestinoDirecto;
import util.AppDataException;

public class ListarDestinos {

	public static void main(String[] args) throws SQLException, AppDataException {
		
		LogicDestino logicd = new LogicDestino();
		
		System.out.println("Listado de destinos disponibles para viajar:");
		for(Destino d: logicd.getAll()) {
			if(d.getClass() == DestinoDirecto.class) {
				System.out.println("Id destino: " + d.getIdDestino());
				System.out.println("Localidad: " + d.getLocalidad());
				System.out.println("Porcentaje de aumento: 0 " + ((DestinoDirecto) d).getPorcentajeAumento());
				System.out.println("Soy clase: " + d.getClass());
				System.out.println();
			}else {
				System.out.println("Id destino: " + d.getIdDestino());
				System.out.println("Localidad: " + d.getLocalidad());
				System.out.println("Soy clase: " + d.getClass());
				System.out.println();
			}

		}

	}
}
