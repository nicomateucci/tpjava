package business;

import java.sql.SQLException;
import java.util.ArrayList;

import data.DataMicro;
import entities.Micro;
import util.AppDataException;

public class LogicMicro{
	
	private DataMicro datam;
	
	public ArrayList<Micro> getAll() throws SQLException, AppDataException{
		
		datam = new DataMicro();
		return datam.getAll();
	}
	

}
