package business;

import java.sql.SQLException;
import java.util.ArrayList;

import data.DataServicio;
import entities.Destino;
import entities.Servicio;
import util.AppDataException;

public class LogicServicio{

	public DataServicio dataSer;

	
	public void addAll(Servicio s) throws AppDataException, SQLException {
		dataSer = new DataServicio();
		dataSer.addAll(s);
	}
	public void insert(Servicio s) throws AppDataException {
		dataSer = new DataServicio();
		dataSer.insert(s);
	}
	/*Lo comente porque no crei conveniente que desdel a UI se pueda ver un Id generado desde la BD.
	 * Podria servir para mostrarle al usuario el numero de servicio que genero. Que tambien se pdria resolver
	 * con el uan consulta de servicios en la BD
	public int generateIdServicio() throws AppDataException, SQLException {
		dataSer = new DataServicio();
		return dataSer.generateIdServicio();
	}*/
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
