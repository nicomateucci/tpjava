package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Conductor;
import entities.Persona;
import entities.Servicio;
import entities.Usuario;

public class DataServicio {

	/*
	public ArrayList<Servicio> getAll(){
		return new ArrayList<Servicio>();
	}*/
	public Servicio getById(int idServicio) throws SQLException{
		
		Servicio s=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select * from Servicio where idServicio=?");
			stmt.setInt(1, idServicio);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){

				s = new Servicio();

				s.setFechaHoraServ(rs.getString("fechaHoraServicio"));
			}

		} catch (SQLException e) {
			throw e;
		} /*finally{ *****Falta hacer el metodo releaseCon()
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}*/
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
