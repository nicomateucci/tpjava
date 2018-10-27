package data;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Destino;
import util.AppDataException;

public class DataDestino {

	
	public Destino getById(int idDestino){
		return new Destino();
	}
	public Destino getByNombre(String nombre) throws AppDataException, SQLException {
		
		Destino d=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select idDestino, localidad from Destino where localidad=?");
			stmt.setString(1, nombre);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){

				d = new Destino();

				d.setIdDestino(rs.getInt("idDestino"));
				d.setLocalidad(rs.getString("localidad"));
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
		return d;
	}
	/*
	public ArrayList<Destino> getAll(){
		return new ArrayList<Destino>();
	}*/
		
	
	public void insert(Destino elDestino){

	}
	public void update(Destino elDestino){
		
	}
	public void delete(Destino elDestino){
		
	}
	
}
