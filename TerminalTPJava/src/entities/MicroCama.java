package entities;

import java.io.Serializable;

public class MicroCama extends Micro implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public double aumento;
	
	public MicroCama() {}
	public double getAumento() {
		return aumento;
	}
	public void setAumento(double aumento) {
		this.aumento = aumento;
	}

}
