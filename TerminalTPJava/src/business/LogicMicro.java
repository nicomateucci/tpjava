package business;

import java.sql.SQLException;
import java.util.ArrayList;

import data.DataMicro;
import entities.Micro;
import entities.MicroCama;
import util.AppDataException;

public class LogicMicro{

	private DataMicro datam;

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
