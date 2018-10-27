package entities;

import java.util.Date;

public class Servicio {

		private int idServicio;
		private java.sql.Date fechaServicio;
		private String horaServicio;
		
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
