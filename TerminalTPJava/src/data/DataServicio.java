package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.LogicDestino;
import business.LogicMicro;
import business.LogicPersona;
import entities.Conductor;
import entities.Destino;
import entities.Micro;
import entities.Servicio;
import entities.Usuario;
import util.AppDataException;

public class DataServicio {


	public void addAll(Servicio s) throws AppDataException, SQLException{

		s.setIdServicio(this.generateIdServicio());
		this.insert(s);
		this.insertAllDestinos(s.getDestinos(), s.getIdServicio());
		this.insertAllMicros(s.getMicros(), s.getIdServicio());
		this.insertAllConductores(s.getMicros(), s.getIdServicio());
	}

	public void insertAllConductores(ArrayList<Micro> mm, int idServicio) throws SQLException, AppDataException {

		PreparedStatement stmt = null;

		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(""
					+ "INSERT INTO MicroConductor (patente, dniConductor, idServicio) "
					+ "VALUES (?,?,?)");
			for (Micro m : mm) {
				for(Conductor c: m.getConductores()) {
					
					stmt.setString(1, m.getPatente());
					stmt.setString(2, c.getDni());
					stmt.setInt(3, idServicio);
					stmt.addBatch();
				}
			}
			stmt.executeBatch();
		} finally{	
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
	}
	public void insertAllMicros(ArrayList<Micro> mm, int idServicio) throws SQLException, AppDataException {

		PreparedStatement stmt = null;

		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(""
					+ "INSERT INTO ServicioMicro (idServicio, patente) "
					+ "VALUES (?,?)");
			for (Micro m : mm) {
				stmt.setInt(1, idServicio);
				stmt.setString(2, m.getPatente());
				stmt.addBatch();
			}
			stmt.executeBatch();
		} finally{	
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
	}

	public int generateIdServicio() throws AppDataException, SQLException {
		ResultSet rs = null;
		PreparedStatement stmt=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select max(idServicio) as id from Servicio");
			rs = stmt.executeQuery();
			rs.first();
			return (rs.getInt("id") + 1);
		} catch (SQLException e) {
			throw new AppDataException(e, "Error al conectar a la base da datos");
		} finally{	
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
	}



	private static final String SQL_INSERT = "INSERT INTO ServicioDestino (idServicio, idDestino, precio, ordenDestinos) VALUES (?,?, ?, ?)";
	public void insertAllDestinos(ArrayList<Destino> dd, int idServicio) throws SQLException, AppDataException {

		int i = 0;
		PreparedStatement stmt = null;

		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(SQL_INSERT);
			for (Destino d : dd) {
				i++;
				stmt.setInt(1, idServicio);
				stmt.setInt(2, d.getIdDestino());
				stmt.setDouble(3, d.getPrecioDestino());
				stmt.setInt(4, i);
				stmt.addBatch();
			}
			stmt.executeBatch();
		} finally{	
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
	}
	public ArrayList<Servicio> getDetalles() throws AppDataException, SQLException {

		ArrayList<Servicio> uu= new ArrayList<Servicio>();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {

			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select * from getDetallesServicios");
			rs=stmt.executeQuery();
			while(rs!=null && rs.next()){
				Micro m = new Micro();
				Conductor c = new Conductor();
				Servicio s = new Servicio();

				s.setIdServicio(rs.getInt("idServicio"));
				s.setFechaServicio(rs.getDate("fechaServicio"));
				s.setHoraServicio(rs.getString("HoraServicio"));
				s.setRecorrido(rs.getString("Recorrido"));
				//m.setMarca(rs.getString("marca"));
				//m.setPatente(rs.getString("patente"));				
				//c.setNombre(rs.getString("nombresApellidos"));


				//m.addConductor(c);
				//s.addMicro(m);
				uu.add(s);
			}

		} catch (SQLException e) {
			throw new AppDataException(e, "Error al conectar a la base da datos");
		} finally{	
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return uu;
	}
	public ArrayList<Servicio> getAllByDestinos(Destino origen, Destino destino) throws AppDataException, SQLException {

		ArrayList<Servicio> ss=null;
		Servicio s = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("call getServiciosByDestinos(?,?)");
			stmt.setInt(1, origen.getIdDestino());
			stmt.setInt(2, destino.getIdDestino());
			rs=stmt.executeQuery();
			ss = new ArrayList<Servicio>();
			int i = 0;
			while(rs!=null && rs.next()){
				i++;
				s = new Servicio();

				s.setIdServicio(rs.getInt("idServicio"));
				s.setFechaServicio(rs.getDate("fechaServicio"));
				s.setHoraServicio(rs.getString("horaServicio"));
				ss.add(s);
			}

		} catch (SQLException e) {
			throw new AppDataException(e, "Error al conectar a la base da datos");
		} finally{	
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return ss;
	}

	public Servicio getById(int idServicio) throws SQLException, AppDataException{

		Servicio s=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select * from Servicio where idServicio=?");
			stmt.setInt(1, idServicio);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){

				s = new Servicio();

				s.setIdServicio(rs.getInt("idServicio"));
				s.setFechaServicio(rs.getDate("fechaServicio"));
				s.setHoraServicio(rs.getString("horaServicio"));
			}

		} catch (SQLException e) {
			throw new AppDataException(e, "Error al conectar a la base da datos");
		} finally{	
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return s;
	}




	public void insert(Servicio s) throws AppDataException{
		ResultSet rs = null;
		PreparedStatement stmt=null;
		try {
			/* Lo borre, porque cuendo tengo que agregar las Foreign Keys a las tabals ServicioDestino, ServicioMicro
			 * ya tengo que conocer cual es el id de servicio que agregue.
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select max(idServicio) as id from Servicio");
			rs = stmt.executeQuery();
			rs.first();
			int idSer = ((rs.getInt("id")) + 1);
			stmt.close();
			stmt = null;
			rs.close();
			 */
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
							"insert into Servicio(idServicio, fechaServicio, horaServicio) values (?,?,?)"
							);
			stmt.setInt(1, s.getIdServicio());
			stmt.setDate(2, s.getFechaServicio());
			stmt.setString(3, s.getHoraServicio());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new AppDataException(e, "Error ocurrido en el metodo insert(Serivicio s) en la calse DataServicio al conectar a la base de datos");
		}
	}
	public void update(Servicio elServicio){

	}
	public void delete(Servicio elServicio){

	}
	public boolean getTieneRefuerzo(Servicio ser) throws AppDataException, SQLException {

		boolean rta = false;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select getTieneRefuerzo(?) as ref");
			stmt.setInt(1, ser.getIdServicio());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				//rta = rs.getBoolean(1);			ANDA BIEN
				rta = rs.getBoolean("ref");
			}
		} catch (SQLException e) {
			throw new AppDataException(e, "Error al conectar a la base da datos");
		} finally{	
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return rta;
	}

}
