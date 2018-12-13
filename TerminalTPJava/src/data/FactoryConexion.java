package data;
import java.sql.*;

import util.AppDataException;


public class FactoryConexion {
	
	//Me tiro el error que el driver com.mysql.jdbc.Driver esta obsoleto, de todas froams, funciono la conexion.
	//private String driver="com.mysql.jdbc.Driver";
	private String driver="com.mysql.cj.jdbc.Driver";
	
	// -------------- Conexion a servidor en JELASTIC
	
	String host="node24713-env-4846480.jelastic.saveincloud.net";
	private String user="root";
	private String password="fmPwzOo1pE";
	/* String host="localhost";
	private String user="usertpjava";
	private String password="usertpjava";*/
	
	private String db="terminalTPJava";
	private String port="3306";
	private Connection conn;
	private int cantConn=0;
	private static FactoryConexion instancia;
		
	private FactoryConexion(){
		try {
			Class.forName(driver); 
			//Seria como hacer un new pero esta relacionado con la base de datos.
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static FactoryConexion getInstancia(){
		if (FactoryConexion.instancia == null){		
			FactoryConexion.instancia=new FactoryConexion();
		}
		return FactoryConexion.instancia;
		
	}
	
	public Connection getConn() throws SQLException , AppDataException{
		try {
			if(conn==null || conn.isClosed()){	
				conn = DriverManager.getConnection(
			        "jdbc:mysql://"+host+":"+port+"/"+db+"?user="+user+"&password="+password);
			}
		} catch (SQLException e) {
			throw new AppDataException(e, "Error al conectar a la base de datos");
		}
		cantConn++;
		return conn;
	}

	public void releaseConn() throws SQLException{
		try {
			cantConn--;
			if(cantConn==0){
				conn.close();
			}
		} catch (SQLException e) {
			throw e;
		}
	}
}
	