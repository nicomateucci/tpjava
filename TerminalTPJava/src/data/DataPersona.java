package data;

import java.util.Date;

import entities.Persona;

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
	

	
	/*
	public ArrayList<Persona> getAll(){
		return new ArrayList<Persona>();
	}*/
	
	public Persona getByDni(String dni){
		return new Persona();
	}
	public void add(Persona laPersona){
		
	}
	
	public void insert(Persona laPersona){

	}
	public void update(Persona laPersona){
		
	}
	public void delete(Persona elMilaPersonacro){
		
	}
	
}
