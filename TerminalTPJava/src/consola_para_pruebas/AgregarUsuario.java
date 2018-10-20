package uiconsolePARA_PRUEBAS_A_BD;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import business.LogicPersona;
import entities.Usuario;

public class AgregarUsuario {

	public static void main(String[] args) throws Exception {

		Scanner s = new Scanner(System.in);
		Usuario user = new Usuario();
		LogicPersona logicUser = new LogicPersona();

		System.out.println("Bienvenido a Plataforma 23 via consola");
		System.out.println("Ingrese su numero de DNI:");
		String dni = s.nextLine(); 
		user.setDni(dni);
		user.setTipoDni("DNI");
		System.out.println("Ingrese su nombre");
		user.setNombre(s.nextLine());
		System.out.println("Ingrese su apellido");
		user.setApellido(s.nextLine());

		System.out.println("Ingrese su fecha de nacimiento (AAAA-MM-DD):");
		String fecha = s.nextLine();
		//----------Parseo de fecha
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		java.sql.Date sqlDate = null;
		try {
			date = format.parse(fecha);
			sqlDate = new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		user.setFechaNacimiento(sqlDate);
		//----------------------------------------
		
		System.out.println("Ingrese su nombre de usuario:");
		user.setNombreUsuario(s.nextLine());
		System.out.println("Ingrese su contraseña:");
		user.setContraseña(s.nextLine());
		System.out.println("Ingrese email");
		user.setEmail(s.nextLine());
		
		try {
			logicUser.add(user);
			if(logicUser.getByDni(dni) != null) {
				System.out.println("Fue agregado correctamente al sistema, Bienvenido a Plataforma 23!.");
			}else {
				System.out.println("Lo sentimos, no pudo ser agregado, intente de nuevo.");
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
