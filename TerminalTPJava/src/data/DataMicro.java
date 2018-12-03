package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select distinct patente, porcentajeAumento, marca, fechaUltimoControl, count(numButaca) as cantButacas " + 
							"from Micro m " + 
							"inner join Butaca b on b.patenteMicro = m.patente " + 
					"group by m.patente");
			rs=stmt.executeQuery();
			while(rs!=null && rs.next()){
				Micro m = null;
				double pAumento = rs.getDouble("porcentajeAumento");
				if(pAumento != 0) {
					m = new MicroCama();
					((MicroCama) m).setAumento(pAumento);
				}
				else {
					m = new Micro();
				}	
				m.setMarca(rs.getString("marca"));
				m.setPatente(rs.getString("patente"));
				m.setFechaUltimoCtrl(rs.getDate("fechaUltimoControl"));
				m.setCantidadButacas(rs.getInt("cantButacas"));
				mm.add(m);
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
	}
	public MicroCama getByPatente(MicroCama mic) throws AppDataException, SQLException{

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



	public void add(Micro elMicro){

	}	

	public void insert(MicroCama m) throws AppDataException, SQLException{
		PreparedStatement st = null;
		PreparedStatement st2 = null;
		ResultSet rs  = null;
		try {
			st = FactoryConexion.getInstancia().getConn().prepareStatement("insert into Micro (patente, marca, fechaUltimoControl, porcentajeAumento) values (?,?,?,?)");
			st.setString(1, m.getPatente());
			st.setString(2, m.getMarca());
			st.setDate(3,  m.getFechaUltimoCtrl());
			st.setDouble(4, m.getAumento());
			st.executeUpdate();
			st2=FactoryConexion.getInstancia().getConn().prepareStatement(""
					+ "INSERT INTO Butaca (numButaca, patenteMicro) VALUES (?,?)");
			int i = 0;
			for (Butaca b : m.getButacas()) {
				i++;
				st2.setInt(1, i);
				st2.setString(2, m.getPatente());
				st2.addBatch();
			}
			st.executeBatch();
			System.out.println("Micro agregado correctamente, verificar el numero de butacas en la BD");
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
		PreparedStatement st2 = null;
		ResultSet rs  = null;
		try {
			st = FactoryConexion.getInstancia().getConn().prepareStatement("insert into Micro (patente, marca, fechaUltimoControl) values (?,?,?)");
			st.setString(1, m.getPatente());
			st.setString(2, m.getMarca());
			st.setDate(3,  m.getFechaUltimoCtrl());
			st.executeUpdate();
			st2=FactoryConexion.getInstancia().getConn().prepareStatement(""
					+ "INSERT INTO Butaca (numButaca, patenteMicro) VALUES (?,?)");
			int i = 0;
			for (Butaca b : m.getButacas()) {
				i++;
				st2.setInt(1, i);
				st2.setString(2, m.getPatente());
				st2.addBatch();
			}
			st2.executeBatch();
			System.out.println("Micro agregado correctamente, verificar el numero de butacas en la BD, se agregaron " + i + " micros.");
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
