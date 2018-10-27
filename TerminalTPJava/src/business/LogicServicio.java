package business;

import java.sql.SQLException;
import java.util.ArrayList;

import data.DataServicio;
import entities.Destino;
import entities.Servicio;
import sun.security.krb5.internal.crypto.Des;
import util.AppDataException;

public class LogicServicio{

	public DataServicio dataSer;
	
	public ArrayList<Servicio> getAllByDestinos(int idPartida, int idLlegada, java.sql.Date fecha){
		
		dataSer = new DataServicio();
		return dataSer.getAllByDestinos(idPartida, idLlegada, fecha);
	}
	
	public ArrayList<Servicio> getAllByDestinos(Destino origen, Destino destino) throws AppDataException, SQLException{
		
		dataSer = new DataServicio();
		return dataSer.getAllByDestinos(origen, destino);
	}
}
