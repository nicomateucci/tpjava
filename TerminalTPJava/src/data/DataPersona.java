package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import entities.Conductor;
import entities.Persona;
import entities.Usuario;

public class DataPersona {

	public String dni;
	public String nombre;
	public String apellido;
	public String tipoDni;
	public Date fechaNacimiento;
	public Date fechaInicio;
	public String contacto;
	public String nombreUsuario;
	public String contraseña;
	public String email;

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTipoDni() {
		return tipoDni;
	}
	public void setTipoDni(String tipoDni) {
		this.tipoDni = tipoDni;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public ArrayList<Persona> getAll(){
		return new ArrayList<Persona>();
	}

	public Persona getByDni(String dni) throws Exception{

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

		} catch (Exception e) {
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
	public void add(Persona laPersona){

	}

	public void insert(Persona laPersona){

	}
	public void update(Persona laPersona){

	}
	public void delete(Persona laPersona){

	}

}
