package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Conductor;
import entities.Destino;
import entities.Persona;
import entities.Servicio;
import entities.Usuario;
import util.AppDataException;

public class DataServicio {

	/*
	public ArrayList<Servicio> getAll(){
		return new ArrayList<Servicio>();
	}*/
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
	
}
