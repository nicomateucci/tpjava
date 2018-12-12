package business;

import java.sql.SQLException;
import java.util.ArrayList;

import data.*;
import entities.*;
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
	/*public MicroCama getByPatente(MicroCama m) throws AppDataException, SQLException {
		datam = new DataMicro();
		return datam.getByPatente(m);
	}*/
	
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
	public void update(Micro m) throws Exception {
		datam = new DataMicro();
		datam.update(m);
	}
	public void delete(Micro m) throws Exception {
		datam = new DataMicro();
		datam.delete(m);
	}

}
