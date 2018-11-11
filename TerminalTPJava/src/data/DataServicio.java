package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Conductor;
import entities.Destino;
import entities.Micro;
import entities.Servicio;
import entities.Usuario;
import util.AppDataException;

public class DataServicio {

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

	public void add(Servicio elServicio){
	
	}
	
	
	public void insert(Servicio elServicio){

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
	public void addServicioDestino(Servicio s, Destino d) throws AppDataException {
		
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
							"insert into ServicioDestino(idServicio, idDestino, precio, ordenDestinos) values (?,?,?,?)"
							);
			stmt.setInt(1, s.getIdServicio());
			stmt.setInt(2, d.getIdDestino());
			stmt.setDouble(3, s.getPrecioDestino());
			stmt.setInt(4, s.getOrdenDestino());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new AppDataException(e, "Error en al conexion a la base de datos");
		}
	}
	
}
