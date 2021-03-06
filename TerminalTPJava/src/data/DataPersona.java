package data;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Date;

import entities.*;
import util.AppDataException;

public class DataPersona {

	public ArrayList<Usuario> getAllUsuarios() throws SQLException, AppDataException{
		ArrayList<Usuario> uu= new ArrayList<Usuario>();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select `dni`, `nombre`, `apellido`, `fechaNac`, `nombreUsuario`, `contrasena`, `email` from Persona where esAdmin = 0 and nombreUsuario is not null");
			rs=stmt.executeQuery();
			while(rs!=null && rs.next()){
		
				Usuario u = new Usuario();
				u.setDni(rs.getString("dni"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				u.setFechaNacimiento(rs.getDate("fechaNac"));
				u.setNombreUsuario(rs.getString("nombreUsuario"));
				u.setContrasena(rs.getString("contrasena"));
				u.setEmail(rs.getString("email"));
				uu.add(u);
				}	
			return uu;
		
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
	
	public ArrayList<Conductor> getAllConductores() throws SQLException, AppDataException{
		ArrayList<Conductor> uu= new ArrayList<Conductor>();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select `dni`, `nombre`, `apellido`, `fechaNac`, `fechaInicio`, `contacto` from Persona where contacto is not null");
			rs=stmt.executeQuery();
			while(rs!=null && rs.next()){
		
				Conductor c = new Conductor();
				c.setDni(rs.getString("dni"));
				c.setNombre(rs.getString("nombre"));
				c.setApellido(rs.getString("apellido"));
				c.setFechaNacimiento(rs.getDate("fechaNac"));
				c.setFechaInicio(rs.getDate("fechaInicio"));
				c.setContacto(rs.getString("contacto"));
				uu.add(c);
				}	
			return uu;
		
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
	


	public Persona getByDni(String dni) throws SQLException, AppDataException{

		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select * from Persona where dni=?");
			stmt.setString(1, dni);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){

				if (rs.getString("fechaInicio") == null){
					p = new Usuario();
					((Usuario) p).setNombreUsuario(rs.getString("nombreUsuario"));
					((Usuario) p).setContrasena(rs.getString("contrasena"));;
					((Usuario) p).setEmail(rs.getString("email"));

				} else {
					p = new Conductor();
					((Conductor) p).setFechaInicio(rs.getDate("fechaInicio"));
					((Conductor) p).setContacto(rs.getString("contacto"));
				}

				p.setDni(rs.getString("dni"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setTipoDni(rs.getString("tipoDni"));
				p.setFechaNacimiento(rs.getDate("fechaNac"));
			}

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
		return p;
	}
	
	
	
	public void add(Usuario per) throws SQLException, AppDataException{

		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
							"insert into Persona(dni, nombre, apellido, tipoDni, fechaNac, nombreUsuario, contrasena, email, esAdmin)  values (?,?,?,?,?,?,?,?,?)"
							);
			stmt.setString(1, per.getDni());
			stmt.setString(2, per.getNombre());
			stmt.setString(3, per.getApellido());
			stmt.setString(4, per.getTipoDni());
			stmt.setDate(5, per.getFechaNacimiento());
			stmt.setString(6, per.getNombreUsuario());
			stmt.setString(7, per.getContrasena());
			stmt.setString(8, per.getEmail());
			stmt.setBoolean(9,((Persona) per).getEsAdmin());

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw e;
		}
	}

	public void add(Conductor per) throws SQLException, AppDataException{

		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
							"insert into Persona(dni, nombre, apellido, tipoDni, fechaNac, fechaInicio, contacto, esAdmin) values (?,?,?,?,?,?,?,0)"
							);
			stmt.setString(1, per.getDni());
			stmt.setString(2, per.getNombre());
			stmt.setString(3, per.getApellido());
			stmt.setString(4, per.getTipoDni());
			stmt.setDate(5, per.getFechaNacimiento());
			stmt.setDate(6, per.getFechaInicio());
			stmt.setString(7, per.getContacto());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new AppDataException(e, "Error en al conexion a la base de datos");
		}
	}

	public Usuario getLogedUser(Usuario per) throws Exception{
		Usuario u = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select dni, nombre, apellido, tipoDni, fechaNac, email, esAdmin from Persona where nombreUsuario=? and contrasena=?");
			stmt.setString(1, per.getNombreUsuario());
			stmt.setString(2, per.getContrasena());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				u = new Usuario();
				u.setDni(rs.getString("dni"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				u.setTipoDni(rs.getString("tipoDni"));
				u.setFechaNacimiento(rs.getDate("fechaNac"));
				u.setEmail(rs.getString("email"));
				u.setEsAdmin(rs.getBoolean("esAdmin"));
			}

		} catch (Exception e) {
			throw e;
		} finally{
			try {
				if(rs != null)rs.close();
				if(stmt != null)stmt.close();/*
				FactoryConexion.getInstancia().releaseConn();*/
			} catch (SQLException e) {
				throw e;
			}
		}

		return u;
	}	
	public void update(Persona laPersona) throws Exception{
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"update Persona set "
					+ "nombre=?, apellido=?, fechaNac=?, esAdmin=?, nombreUsuario=?, contrasena=?, email=?, fechaInicio=?, contacto=? "
					+ "where dni=?");
			stmt.setString(1, laPersona.getNombre());
			stmt.setString(2, laPersona.getApellido());
			stmt.setDate(3, laPersona.getFechaNacimiento());
			stmt.setBoolean(4, laPersona.getEsAdmin());
			
			if (laPersona instanceof Usuario){
				stmt.setString(5,((Usuario) laPersona).getNombreUsuario());
				stmt.setString(6,((Usuario) laPersona).getContrasena());
				stmt.setString(7,((Usuario) laPersona).getEmail());
				stmt.setDate(8, null);
				stmt.setString(9,null);

			} else {
				stmt.setString(5,null);
				stmt.setString(6,null);
				stmt.setString(7,null);
				stmt.setDate(8,((Conductor) laPersona).getFechaInicio());
				stmt.setString(9,((Conductor) laPersona).getContacto());
			}
			stmt.setString(10, laPersona.getDni());
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
	

	public void delete(Persona laPersona) throws Exception{
		PreparedStatement stmt = null;
		//No tengo que dejar que borre las cuentas propia.
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from Persona WHERE dni=?"); 
				stmt.setString(1, laPersona.getDni());
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
