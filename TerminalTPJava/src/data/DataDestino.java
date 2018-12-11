package data;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JOptionPane;

import entities.*;
import util.AppDataException;

public class DataDestino {


	public Destino getById(Destino d) throws AppDataException, SQLException {

		Destino des = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select idDestino, localidad, porcentajeAumento from Destino where idDestino=?");
			stmt.setInt(1, d.getIdDestino());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				double por = rs.getDouble("porcentajeAumento");
				if(Objects.equals(null, por)) {
					des = new Destino(d.getIdDestino());
					des.setLocalidad(rs.getString("localidad"));
				}else {
					des = new DestinoDirecto();
					des.setIdDestino(rs.getInt("idDestino"));
					des.setLocalidad(rs.getString("localidad"));
					((DestinoDirecto) des).setPorcentajeAumento(rs.getDouble("porcentajeAumento"));
				}
			}

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
		return des;
	}
	/*
public Destino getById(Destino d) throws AppDataException, SQLException {

		Destino des = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select idDestino, localidad from Destino where idDestino=?");
			stmt.setInt(1, d.getIdDestino());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){

				des = new Destino(d.getIdDestino());
				des.setLocalidad(rs.getString("localidad"));
			}

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
		return des;
	}
public DestinoDirecto getById(DestinoDirecto d) throws AppDataException, SQLException {

	DestinoDirecto des = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	try {
		stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select idDestino, localidad, porcentajeAumento from Destino where idDestino=?");
		stmt.setInt(1, d.getIdDestino());
		rs=stmt.executeQuery();
		if(rs!=null && rs.next()){

			des = new DestinoDirecto();
			des.setIdDestino(rs.getInt("idDestino"));
			des.setLocalidad(rs.getString("localidad"));
			des.setPorcentajeAumento(rs.getDouble("porcentajeAumento"));
		}

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
	return des;
}*/

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
	public void insert(Destino d) throws AppDataException, SQLException{

		PreparedStatement st = null;
		ResultSet rs  = null;
		try {
			st = FactoryConexion.getInstancia().getConn().prepareStatement("select max(idDestino) as id from Destino");
			rs = st.executeQuery();
			rs.first();
			int idDes = (Integer.parseInt(rs.getString("id")) + 1);
			st.close();
			st = null;
			rs.close();

			st = FactoryConexion.getInstancia().getConn().prepareStatement("insert into Destino (idDestino, localidad) values (?,?)");
			st.setInt(1, idDes);
			st.setString(2, d.getLocalidad());
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Destino agregado correctamente");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al agrear al nuevo Destino");
			throw new AppDataException(e, "Error al agrear al nuevo Destino");
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
	public void insert(DestinoDirecto d) throws AppDataException, SQLException{

		PreparedStatement st = null;
		ResultSet rs  = null;
		try {
			st = FactoryConexion.getInstancia().getConn().prepareStatement("select max(idDestino) as id from Destino");
			rs = st.executeQuery();
			rs.first();
			int idDes = (Integer.parseInt(rs.getString("id")) + 1);
			st.close();
			st = null;
			rs.close();

			st = FactoryConexion.getInstancia().getConn().prepareStatement("insert into Destino (idDestino, localidad , porcentajeAumento) values (?,?,?)");
			st.setInt(1, idDes);
			st.setString(2, d.getLocalidad());
			st.setDouble(3, d.getPorcentajeAumento());
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Destino agregado correctamente");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al agrear al nuevo Destino");
			throw new AppDataException(e, "Error al agrear al nuevo Destino");
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


	public void update(Destino elDestino) throws Exception{
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"update Destino set "
							+ "localidad=?, porcentajeAumento=? where idDestino=?");
			stmt.setString(1, elDestino.getLocalidad());

			if (elDestino instanceof DestinoDirecto){
				stmt.setDouble(2,((DestinoDirecto) elDestino).getPorcentajeAumento());

			} else {
				stmt.setNull(2, java.sql.Types.DOUBLE);
			}
			stmt.setInt(3,elDestino.getIdDestino());
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


	public void delete(Destino elDestino) throws Exception{
		PreparedStatement stmt = null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from Destino WHERE idDestino=?"); 
			stmt.setInt(1, elDestino.getIdDestino());
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

}
