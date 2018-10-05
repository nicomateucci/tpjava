package business;

import java.util.ArrayList;
import data.DataPersona;
import entities.Persona;

public class LogicPersona {

	public DataPersona dataPer;


	public ArrayList<Persona> getAll(){
		return dataPer.getAll();
	}

	public Persona getByDni(String dni) throws Exception{
		return dataPer.getByDni(dni);
	}
}
