package data;

import entities.*;

public class DataMicro {

	public String patente;
	public String dniConductor;

	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public String getDniConductor() {
		return dniConductor;
	}
	public void setDniConductor(String dniConductor) {
		this.dniConductor = dniConductor;
	}
	/*
	public ArrayList<Micro> getAll(){
		return new ArrayList<Micro>();
	}*/
	
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
