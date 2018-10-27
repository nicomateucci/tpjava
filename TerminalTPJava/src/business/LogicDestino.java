package business;

import java.sql.SQLException;

import data.DataDestino;
import entities.Destino;
import util.AppDataException;

public class LogicDestino {
	
	private DataDestino dataDes;
	
	public Destino getByNombre(String nombre) throws AppDataException, SQLException {
		dataDes = new DataDestino();
		return dataDes.getByNombre(nombre);
	}

}
