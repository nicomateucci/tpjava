package consola_para_pruebas;

import java.sql.SQLException;
import java.util.Scanner;

import business.LogicServicio;
import entities.Servicio;
import util.AppDataException;

public class GetTieneRefuerzo {

	public static void main(String[] args) throws AppDataException, SQLException {
	
		int opc = 1;
		Servicio serv = new Servicio();
		Scanner s = new Scanner(System.in);
		
		while(opc != 0) {
			
			System.out.println("Ingrese servicio para consultar si posee refuerzos: ");
			int num = s.nextInt();
			
			serv.setIdServicio(num);
			LogicServicio logser = new LogicServicio();
			if (logser.getTieneRefuerzo(serv)) {
				System.out.println("El servicio " + num + " SI tiene refuerzos");
			}else {
				System.out.println("El servicio " + num + " NO tiene refuerzos");
			}
			System.out.println("Quiere seguir consulta: 0 termina");
			opc = s.nextInt();
		}
		s.close();
	}
}
