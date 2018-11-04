package business;

import java.sql.SQLException;
import java.util.ArrayList;

import data.DataDestino;
import entities.Destino;
import util.AppDataException;

public class LogicDestino {
	
	private DataDestino dataDes;
	
	public Destino getByNombre(String nombre) throws AppDataException, SQLException {
		dataDes = new DataDestino();
		return dataDes.getByNombre(nombre);
	}

	public ArrayList<Destino> getAll() throws SQLException, AppDataException{
		dataDes = new DataDestino();
		return dataDes.getAll();
	}
}
