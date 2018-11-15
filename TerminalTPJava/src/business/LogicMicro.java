package business;

import java.sql.SQLException;
import java.util.ArrayList;

import data.DataMicro;
import entities.Micro;
import entities.MicroCama;
import util.AppDataException;

public class LogicMicro{

	private DataMicro datam;

	
	public boolean esCama(String p) throws SQLException, AppDataException {
		datam = new DataMicro();
		return datam.esCama(p);
		
	}
	public Micro getByPatente(Micro m) throws AppDataException, SQLException {
		datam = new DataMicro();
		return datam.getByPatente(m);
	}
	public MicroCama getByPatente(MicroCama m) throws AppDataException, SQLException {
		datam = new DataMicro();
		return datam.getByPatente(m);
	}
	public ArrayList<Micro> getAll() throws SQLException, AppDataException{

		datam = new DataMicro();
		return datam.getAll();
	}

	public void insert(Micro m) throws AppDataException, SQLException {

		datam = new DataMicro();
		datam.insert(m);
	}
	public void insert(MicroCama m) throws AppDataException, SQLException {

		datam = new DataMicro();
		datam.insert(m);
	}


}
