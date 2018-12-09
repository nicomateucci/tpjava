package business;

import java.sql.SQLException;
import java.util.ArrayList;

import data.*;
import entities.*;
import util.AppDataException;
import util.NoDestinoException;

public class LogicDestino {
	
	private DataDestino dataDes;
	
	public Destino getById(Destino d) throws AppDataException, SQLException {
		dataDes = new DataDestino();
		return dataDes.getById(d);
	}
	public Destino getByNombre(String nombre) throws AppDataException, SQLException,NoDestinoException {
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
	
	public void update(Destino d)  throws Exception{
		dataDes = new DataDestino();
		dataDes.update(d);
	}
	public void delete(Destino d)  throws Exception{
		dataDes = new DataDestino();
		dataDes.delete(d);
	}
}
