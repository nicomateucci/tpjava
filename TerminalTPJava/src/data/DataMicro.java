package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
	
	public void insert(MicroCama m) throws AppDataException, SQLException{
		PreparedStatement st = null;
		ResultSet rs  = null;
		try {
			st = FactoryConexion.getInstancia().getConn().prepareStatement("insert into Micro (patente, marca, fechaUltimoControl, porcentajeAumento) values (?,?,?,?)");
			st.setString(1, m.getPatente());
			st.setString(2, m.getMarca());
			st.setDate(3,  m.getFechaUltimoCtrl());
			st.setDouble(4, m.getAumento());
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Micro agregado correctamente");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al agregar el nuevo Micro");
			throw new AppDataException(e, "Error al agregar el nuevo Micro");
		} finally{	
		try {
				if(rs!=null)rs.close();
				if(st!=null)st.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
	}
	public void insert(Micro m) throws AppDataException, SQLException{
		PreparedStatement st = null;
		ResultSet rs  = null;
		try {
			st = FactoryConexion.getInstancia().getConn().prepareStatement("insert into Micro (patente, marca, fechaUltimoControl) values (?,?,?)");
			st.setString(1, m.getPatente());
			st.setString(2, m.getMarca());
			st.setDate(3,  m.getFechaUltimoCtrl());
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Micro agregado correctamente");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al agregar el nuevo Micro");
			throw new AppDataException(e, "Error al agregar al nuevo Micro");
		} finally{	
		try {
				if(rs!=null)rs.close();
				if(st!=null)st.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
	}
	public void update(Micro elMicro){
		
	}
	public void delete(Micro elMicro){
		
	}
}
