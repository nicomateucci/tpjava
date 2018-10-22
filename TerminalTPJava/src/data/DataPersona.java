package data;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import entities.Conductor;
import entities.Persona;
import entities.Usuario;

public class DataPersona {

	public ArrayList<Persona> getAll(){
		return new ArrayList<Persona>();
	}

	public Persona getByDni(String dni) throws SQLException{

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
					((Usuario) p).setContraseña(rs.getString("contraseña"));;
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
		} /*finally{ *****Falta hacer el metodo releaseCon()
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}*/
		return p;
	}
	public void add(Usuario per) throws SQLException{

		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
							"insert into Persona(dni, nombre, apellido, tipoDni, fechaNac, nombreUsuario, contraseña, email)  values (?,?,?,?,?,?,?,?)"
							);
			stmt.setString(1, per.getDni());
			stmt.setString(2, per.getNombre());
			stmt.setString(3, per.getApellido());
			stmt.setString(4, per.getTipoDni());
			stmt.setDate(5, per.getFechaNacimiento());
			stmt.setString(6, per.getNombreUsuario());
			stmt.setString(7, per.getContraseña());
			stmt.setString(8, per.getEmail());

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw e;
		}
	}

	public void add(Conductor per) throws SQLException{

		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
							"insert into persona(dni, nombre, apellido, tipoDni, fechaNac, fechaInicio, contacto) values (?,?,?,?,?,?,?)"
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
			throw e;
		}
	}

	public Usuario getLogedUser(Usuario per) throws Exception{
		Usuario u = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select dni, nombre, apellido, tipoDni, fechaNacimiento, email from Persona where nombreUsuario=? and contraseña=?");
			stmt.setString(1, u.getNombreUsuario());
			stmt.setString(2, u.getContraseña());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				u = new Usuario();
				u.setDni(rs.getString("dni"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				u.setTipoDni(rs.getString("tipoDni"));
				u.setFechaNacimiento(rs.getDate("fechaNacimiento"));
				u.setEmail(rs.getString("email"));
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

	public void insert(Persona laPersona){

	}
	public void update(Persona laPersona){

	}
	public void delete(Persona laPersona){

	}

}
