package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.*;
import util.AppDataException;

public class DataMicro {

	
	
	public ArrayList<Micro> getAll() throws SQLException, AppDataException{
		
		ArrayList<Micro> mm= new ArrayList<Micro>();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select * from Micro");
			rs=stmt.executeQuery();
			while(rs!=null && rs.next()){
				double pAumento = rs.getDouble("porcentajeAumento");
				if(pAumento != 0) {
					MicroCama m = new MicroCama();
					m.setAumento(pAumento);
					m.setMarca(rs.getString("marca"));
					m.setPatente(rs.getString("patente"));
					m.setFechaUltimoCtrl(rs.getDate("fechaUltimoControl"));
					mm.add(m);
					
				} else {
					Micro m = new Micro();
					m.setMarca(rs.getString("marca"));
					m.setPatente(rs.getString("patente"));
					m.setFechaUltimoCtrl(rs.getDate("fechaUltimoControl"));
					mm.add(m);
				}	
			}
			return mm;

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
	
	public Micro getByPatente(String patente){
		return new Micro();
	}
	public void add(Micro elMicro){
		
	}	
	
	public void insert(Micro elMicro){

	}
	public void update(Micro elMicro){
		
	}
	public void delete(Micro elMicro){
		
	}
}
