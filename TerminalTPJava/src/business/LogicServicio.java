package business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import data.DataServicio;
import entities.Destino;
import entities.Servicio;
import util.AppDataException;
import util.NoServiceException;

public class LogicServicio{

	public DataServicio dataSer;

	
	public double[] getRecaudacionPorMes() throws AppDataException, SQLException {
		dataSer = new DataServicio();
		return dataSer.getRecaudacionPorMes();
	}
	public String[][] getDestinosByMesAno(int mes, int ano) throws AppDataException, SQLException{
		dataSer = new DataServicio();
		return dataSer.getDestinosByMesAno(mes, ano);
	}
	public void addPasajero(int idSer, String dni, String patente, int numButaca, int origen, int destino, double precio) throws AppDataException{
		dataSer = new DataServicio();
		dataSer.addPasajero(idSer, dni, patente, numButaca, origen, destino, precio);
	}
	public Servicio getServicioParaVenta(int id) throws Exception {
		dataSer = new DataServicio();
		return dataSer.getServicioParaVenta(id);
	}
	public Servicio getById(int id) throws SQLException, AppDataException,NoServiceException{
		dataSer = new DataServicio();
		return dataSer.getById(id);
	}
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
	public ArrayList<Servicio> getAllByDestinos(Destino origen, Destino destino) throws AppDataException, SQLException, NoServiceException{
		
		dataSer = new DataServicio();
		return dataSer.getAllByDestinos(origen, destino);
	}
	public ArrayList<Servicio> getDetalles() throws AppDataException, SQLException {
		dataSer = new DataServicio();
		return dataSer.getDetalles();
	}
public void update(Servicio s) throws Exception {
		dataSer = new DataServicio();
		dataSer.update(s);
	}
	public void delete(Servicio s) throws Exception {
		dataSer = new DataServicio();
		dataSer.delete(s);
	}
}
