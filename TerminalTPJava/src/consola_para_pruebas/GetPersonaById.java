package consola_para_pruebas;

import business.LogicDestino;
import business.LogicPersona;
import data.DataPersona;
import entities.Destino;
import entities.Usuario;
import entities.DestinoDirecto;

public class GetPersonaById {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String dni = "33333333";
		LogicPersona logicPer = new LogicPersona();
		Usuario per = null;
		
		per = (Usuario) logicPer.getByDni(dni);
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
