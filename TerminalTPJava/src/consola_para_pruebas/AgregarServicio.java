package consola_para_pruebas;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import business.LogicDestino;
import business.LogicServicio;
import entities.Destino;
import entities.Servicio;
import javafx.scene.control.TextFormatter;
import util.AppDataException;

public class AgregarServicio {

	public static void main(String[] args) throws AppDataException, SQLException {

		Scanner scanner = new Scanner(System.in);
		LogicServicio logs = new LogicServicio();
		LogicDestino logd = new LogicDestino();
		Servicio s = new Servicio();

		System.out.println("Esta por agregar un nuevo servicio:");
		System.out.println("Ingrese la fecha del servicio con este formato: mes-dia-año");
		String fecha = scanner.nextLine();
		
		//Parseo de fecha
		SimpleDateFormat  format = new SimpleDateFormat("MM-dd-yyyy");
		java.util.Date fjava = null;
		java.sql.Date  fsql = null;
		try {
			fjava = format.parse(fecha);
		} catch(java.text.ParseException e) {
			e.printStackTrace();
		}
		fsql = (Date) new java.sql.Date(fjava.getTime());
		System.out.println("Ingrese la hora del servicio con este formato: mes-dia-año");
		String hora = scanner.nextLine();
		s.setFechaServicio(fsql);
		s.setHoraServicio(hora);
		
		Destino d = new Destino();
		System.out.println("Ingrese un id de Destino del 1 al 7");
		int idDes = scanner.nextInt();
		d.setIdDestino(idDes);
		Destino des = logd.getById(d);
		des.setPrecioDestino((Double) 0.0);
		s.addDestino(des);
		
		d = new Destino();
		System.out.println("Ingrese un id de Destino del 1 al 7");
		idDes = scanner.nextInt();
		d.setIdDestino(idDes);
		des = logd.getById(d);
		System.out.println("Ingrese el precio desde el origen hasta esta destino");
		Double precio = scanner.nextDouble();
		des.setPrecioDestino(precio);
		s.addDestino(des);
		
		
		d = new Destino();
		System.out.println("Ingrese un id de Destino del 1 al 7");
		idDes = scanner.nextInt();
		d.setIdDestino(idDes);
		des = logd.getById(d);
		System.out.println("Ingrese el precio desde el origen hasta esta destino");
		precio = scanner.nextDouble();
		des.setPrecioDestino(precio);
		s.addDestino(des);
		
		logs.addAll(s);
		
		System.out.println("No olvides de borrar el servicio en la base de datos, ya que podra traer fallas en claves foraneas");
		scanner.close();
	}

}
