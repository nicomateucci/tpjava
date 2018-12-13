package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JOptionPane;

import entities.*;
import util.AppDataException;

public class DataMicro {


	public boolean esCama(String p) throws SQLException, AppDataException {
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select porcentajeAumento from Micro where patente=?");
			stmt.setString(1, p);
			rs=stmt.executeQuery();
			rs.next();
			return (rs.getDouble("porcentajeAumento") > 0);
			
		} catch (SQLException e) {
			throw new AppDataException(e, "Error al consultar destinos en la base da datos");
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
					getCantidadServicios(m);
					mm.add(m);
					
				} else {
					Micro m = new Micro();
					m.setMarca(rs.getString("marca"));
					m.setPatente(rs.getString("patente"));
					m.setFechaUltimoCtrl(rs.getDate("fechaUltimoControl"));
					getCantidadServicios(m);
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
	
public Micro getByPatente(Micro mic) throws AppDataException, SQLException{
		
		Micro m = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select patente, marca, fechaUltimoControl, porcentajeAumento from Micro where patente=?");
			stmt.setString(1, mic.getPatente());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				double por = rs.getDouble("porcentajeAumento");
				if(Objects.equals(null,por)){
					m = new Micro();
					m.setPatente(rs.getString("patente"));
					m.setMarca(rs.getString("marca"));
					m.setFechaUltimoCtrl(rs.getDate("fechaUltimoControl"));
				}else {
					m = new MicroCama();
					m.setPatente(rs.getString("patente"));
					m.setMarca(rs.getString("marca"));
					m.setFechaUltimoCtrl(rs.getDate("fechaUltimoControl"));
					((MicroCama) m).setAumento(rs.getDouble("porcentajeAumento"));
				}
			}
		} catch (SQLException e) {
			throw new AppDataException(e, "Error al conectar con la BD producido en el metodo getByPatente(Micro m)");
		} finally{	
		try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return m;
	}	
	
	/*public Micro getByPatente(Micro mic) throws AppDataException, SQLException{
		
		Micro m = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select patente, marca, fechaUltimoControl from Micro where patente=?");
			stmt.setString(1, mic.getPatente());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){

				m = new Micro();
				m.setPatente(rs.getString("patente"));
				m.setMarca(rs.getString("marca"));
				m.setFechaUltimoCtrl(rs.getDate("fechaUltimoControl"));
			}

		} catch (SQLException e) {
			throw new AppDataException(e, "Error al conectar con la BD producido en el metodo getByPatente(Micro m)");
		} finally{	
		try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return m;
	}*/
	
/*public MicroCama getByPatente(MicroCama mic) throws AppDataException, SQLException{
		
		MicroCama m = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select patente, marca, fechaUltimoControl, porcentajeAumento from Micro where patente=?");
			stmt.setString(1, mic.getPatente());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){

				m = new MicroCama();
				m.setPatente(rs.getString("patente"));
				m.setMarca(rs.getString("marca"));
				m.setFechaUltimoCtrl(rs.getDate("fechaUltimoControl"));
				m.setAumento(rs.getDouble("porcentajeAumento"));
			}

		} catch (SQLException e) {
			throw new AppDataException(e, "Error al conectar con la BD producido en el metodo getByPatente(MicroCama m)");
		} finally{	
		try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return m;
	}
*/	
	
	
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
	
	
	public void update(Micro m) throws Exception{
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"update Micro set "
					+ "marca=?, fechaUltimoControl=?, porcentajeAumento=? where patente=?");
			stmt.setString(1, m.getMarca());
			stmt.setDate(2, m.getFechaUltimoCtrl());
			
			if (m instanceof MicroCama){
				stmt.setDouble(3,((MicroCama) m).getAumento());

			} else {
				stmt.setNull(3, java.sql.Types.DOUBLE);
			}
			stmt.setString(4,m.getPatente());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally{
			try {
				if(stmt != null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
	}
	

	public void delete(Micro m) throws Exception{
		PreparedStatement stmt = null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from Micro WHERE patente=?"); 
				stmt.setString(1, m.getPatente());
				stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally{
			try {
				if(stmt != null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
	}
	
	public void getCantidadServicios(Micro m) throws AppDataException, SQLException {
		PreparedStatement st = null;
		ResultSet rs  = null;
		try {
			st = FactoryConexion.getInstancia().getConn().prepareStatement("select count(patente) cantidad from ServicioMicro WHERE patente = ?;");
			st.setString(1, m.getPatente());
			rs=st.executeQuery();
			if(rs!=null && rs.next()){
				m.setCantidadServicios(rs.getInt("cantidad"));
				
			}
			else {
				m.setCantidadServicios(0);
			}
			
			
			
		}catch (SQLException e) {
			throw new AppDataException(e, "Error al consultar la cantidad de servicios por micro");
		}finally{	
		try {
				if(rs!=null)rs.close();
				if(st!=null)st.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		
	}
	


}