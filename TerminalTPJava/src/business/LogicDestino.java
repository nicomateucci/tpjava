package business;

import java.sql.SQLException;
import java.util.ArrayList;

import data.DataDestino;
import data.DataServicio;
import entities.Destino;
import entities.DestinoDirecto;
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
	public void insert(Destino d) throws AppDataException, SQLException {
		dataDes = new DataDestino();
		dataDes.insert(d);
	}
	public void insert(DestinoDirecto d) throws AppDataException, SQLException {
		dataDes = new DataDestino();
		dataDes.insert(d);
	}
}
