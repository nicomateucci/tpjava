package data;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Conductor;
import entities.Destino;
import entities.DestinoDirecto;
import entities.Persona;
import entities.Usuario;
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
		
	public void insert(Destino elDestino){

	}
	public void update(Destino elDestino){
		
	}
	public void delete(Destino elDestino){
		
	}
	public ArrayList<Destino> getAll() throws SQLException, AppDataException {
		
		ArrayList<Destino> dd= new ArrayList<Destino>();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select * from Destino");
			rs=stmt.executeQuery();
			while(rs!=null && rs.next()){
				double pAumento = rs.getDouble("porcentajeAumento");
				if(pAumento != 0) {
					DestinoDirecto d = new DestinoDirecto();
					d.setPorcentajeAumento(pAumento);
					d.setIdDestino(rs.getInt("idDestino"));
					d.setLocalidad(rs.getString("localidad"));
					dd.add(d);
					
				} else {
					Destino d = new Destino();
					d.setIdDestino(rs.getInt("idDestino"));
					d.setLocalidad(rs.getString("localidad"));
					dd.add(d);
				}	
			}
			return dd;

		} catch (SQLException e) {
			throw e;
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
}
