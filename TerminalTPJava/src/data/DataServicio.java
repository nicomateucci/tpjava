package data;

import java.util.Date;

import entities.Servicio;

public class DataServicio {

	public int idServicio;
	public Date fechaHoraServ;

	public int getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	public Date getFechaHoraServ() {
		return fechaHoraServ;
	}
	public void setFechaHoraServ(Date fechaHoraServ) {
		this.fechaHoraServ = fechaHoraServ;
	}
	
	/*
	public ArrayList<Servicio> getAll(){
		return new ArrayList<Servicio>();
	}*/
	public Servicio getById(int idServicio){
		return new Servicio();
	}
	public void add(Servicio elServicio){
	
	}
	
	
	public void insert(Servicio elServicio){

	}
	public void update(Servicio elServicio){
		
	}
	public void delete(Servicio elServicio){
		
	}
	
}
