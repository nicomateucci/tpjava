package business;

import java.sql.SQLException;
import java.util.ArrayList;
import data.DataPersona;
import entities.Conductor;
import entities.Persona;
import entities.Usuario;

public class LogicPersona {

	public DataPersona dataPer;


	public ArrayList<Persona> getAll(){
		return dataPer.getAll();
	}

	public Persona getByDni(String dni) throws Exception{
		return dataPer.getByDni(dni);
	}
	//Sobrecargue el metodo add porque sino me salia el error de que en DataPersona no existe el 
	//metodo add que acepte una persona como argumento.
	public void add(Usuario per) throws SQLException {
		dataPer = new DataPersona();
		dataPer.add(per);
		
	}
	public void add(Conductor per) throws SQLException {
		
		dataPer.add(per);
		
	}
}
