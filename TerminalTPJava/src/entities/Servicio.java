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
		public int ordenDestino;
		public Double precioDestino;
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
		
		public int getOrdenDestino() {
			return ordenDestino;
		}

		public void setOrdenDestino(int ordenDestino) {
			this.ordenDestino = ordenDestino;
		}

		public Double getPrecioDestino() {
			return precioDestino;
		}

		public void setPrecioDestino(Double precioDestino) {
			this.precioDestino = precioDestino;
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
		public void addDestinos() {
			
		}
		public void addMicro(Micro m) {
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
