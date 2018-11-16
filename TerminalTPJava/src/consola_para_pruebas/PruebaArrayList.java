package consola_para_pruebas;

import java.sql.SQLException;
import java.util.ArrayList;

import business.LogicDestino;
import entities.Destino;
import util.AppDataException;

public class PruebaArrayList {

	public static void main(String[] args) throws SQLException, AppDataException {
		
		LogicDestino logd = new LogicDestino();
		ArrayList<Destino> dd = logd.getAll();
		
		

	}

}
