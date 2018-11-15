package consola_para_pruebas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import entities.Butaca;
import entities.Conductor;
import entities.Micro;
import entities.MicroCama;
import entities.Usuario;

public class PrebaSubclasesEnArrayList {

	public static void main(String[] args) {
		
		ArrayList<Micro> mm = new ArrayList<Micro>();
		
		MicroCama mc = new MicroCama();
		mc.setPatente("123ABC");
		mc.setAumento(1.26);
		
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date fechaJava = null;
		java.sql.Date fechaSql = null;
		try {
			fechaJava = formatoFecha.parse("31/12/2018");
		} catch(java.text.ParseException e) {
			e.printStackTrace();
		}
		fechaSql = new java.sql.Date(fechaJava.getTime());
		mc.setFechaUltimoCtrl(fechaSql);
		mc.setMarca("Mercedes Benz");
		
		mc.setPasajeros(20);
		
		Usuario u = new Usuario();
		u.setDni("37829123");
		u.setNombre("Nicolas");
		u.setApellido("Mateucci");
		mc.getButaca(3).setPasajero(u);
		Usuario u2 = new Usuario();
		u2.setDni("34981626");
		u2.setNombre("Sebastian");
		u2.setApellido("Mateucci");
		mc.setPasajero(15, u2);
		
		Conductor c = new Conductor();
		c.setDni("26165984");
		c.setNombre("Cacho");
		c.setApellido("Canale");
		c.setContacto("3462169548");
		mc.addConductor(c);
		Conductor c2 = new Conductor();
		c2.setDni("22984325");
		c2.setNombre("Carlos Mario");
		c2.setApellido("Canale");
		c2.setContacto("346159845");
		mc.addConductor(c2);
		
		mm.add(mc);
		for(Micro m:mm) {
			System.out.println("El micro de AttayList<Micro> es de la calse: " + m.getClass());
		}
		

	}

}
