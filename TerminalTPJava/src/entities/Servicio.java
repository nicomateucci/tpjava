package entities;

import java.util.ArrayList;

import business.LogicDestino;
import business.LogicServicio;

public class Servicio {

		private int idServicio;
		private java.sql.Date fechaServicio;
		private String horaServicio;
		public ArrayList<Destino> destinos;
		public ArrayList<Micro> micros;
		//********************************************************************
		public String recorrido;

		/* Formato: destino1, destino2, destino3, ..., destinoN
		 * Atributo agregado para mostrar al usuario administrador todos los destinos de un servicio
		 * Reulta mas simple ya que en la pagina JSP no va a ser necesario recorreR el ArrayList<Destino>
		 * y preguntarle a uno por una su localidad y luego concatenarlos para mostrarlos en la talba HTML.
		 * 
		 * Ademas mi sirvio para aprender la funcion de sql group_contact(), que concatena las
		 * distintas columnas segun los registros agrupados por un group by*/
		//********************************************************************
		//public boolean tieneRefuerzo;
		
		public Servicio() {
			micros = new ArrayList<Micro>();
			destinos = new ArrayList<Destino>();
		}
		
		
		public ArrayList<Destino> getDestinos() {
			return destinos;
		}


		public void setDestinos(ArrayList<Destino> destinos) {
			this.destinos = destinos;
		}


		public ArrayList<Micro> getMicros() {
			return micros;
		}


		public void setMicros(ArrayList<Micro> micros) {
			this.micros = micros;
		}


		public String getRecorrido() {
			return recorrido;
		}
		public void setRecorrido(String recorrido) {
			this.recorrido = recorrido;
		}
		public void addDestino(Destino des) {
			destinos.add(des);
		}
		public void addDestino(DestinoDirecto des) {
			destinos.add(des);
		}
		public void addDestinos() {
			
		}
		public void addMicro(Micro m) {
			micros.add(m);
		}
		public void addMicro(MicroCama m) {
			micros.add(m);
		}
		public void addMicros() {
			
		}
		
		
		public java.sql.Date getFechaServicio() {
			return fechaServicio;
		}
		public void setFechaServicio(java.sql.Date fechaServicio) {
			this.fechaServicio = fechaServicio;
		}
		public String getHoraServicio() {
			return horaServicio;
		}
		public void setHoraServicio(String horaServicio) {
			this.horaServicio = horaServicio;
		}
		public int getIdServicio() {
			return idServicio;
		}
		public void setIdServicio(int idServicio) {
			this.idServicio = idServicio;
		}
}
