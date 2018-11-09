package business;

import java.sql.SQLException;
import java.util.ArrayList;

import data.DataServicio;
import entities.Destino;
import entities.Servicio;
import util.AppDataException;

public class LogicServicio{

	public DataServicio dataSer;

	public boolean getTieneRefuerzo(Servicio ser) throws AppDataException, SQLException {
		
		dataSer = new DataServicio();
		return dataSer.getTieneRefuerzo(ser);
	}
	public ArrayList<Servicio> getAllByDestinos(Destino origen, Destino destino) throws AppDataException, SQLException{
		
		dataSer = new DataServicio();
		return dataSer.getAllByDestinos(origen, destino);
	}
	public ArrayList<Servicio> getDetalles() throws AppDataException, SQLException {
		dataSer = new DataServicio();
		return dataSer.getDetalles();
	}
}
