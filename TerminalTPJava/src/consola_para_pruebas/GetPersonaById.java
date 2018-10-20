package uiconsolePARA_PRUEBAS_A_BD;

import data.DataPersona;
import entities.Usuario;

public class GetPersonaById {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String dni = "39052011";
		DataPersona dataPer = new DataPersona();
		Usuario per = null;
		
		per = (Usuario) dataPer.getByDni(dni);
		if(per.getDni() != null){
			System.out.println("Se encontro a la persona");
			System.out.println("Nombre: " + per.getNombre());
			System.out.println("Apellido: " + per.getApellido() );
			System.out.println("Email (Es usuario): " + per.getEmail() );
		} else {
			System.out.println("No se encontro la persona");
		}
	}

}
