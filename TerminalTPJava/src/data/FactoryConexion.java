package data;
import java.sql.*;


public class FactoryConexion {
	
	//Me tiro el error que el driver com.mysql.jdbc.Driver esta obsoleto, de todas froams, funciono la conexion.
	//private String driver="com.mysql.jdbc.Driver";
	private String driver="com.mysql.cj.jdbc.Driver";
	private String host="localhost";
	private String port="3306";
	private String user="usertpjava";
	private String password="usertpjava";
	private String db="terminalTPJava";
	
	private static FactoryConexion instancia;
		
	private FactoryConexion(){
		try {
			Class.forName(driver); //Seria como hacer un new pero esta relacionado con la base de datos.
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
	
	private Connection conn;
	
	
	public Connection getConn(){
		try {
				conn = DriverManager.getConnection(
			        "jdbc:mysql://"+host+":"+port+"/"+db+"?user="+user+"&password="+password);
					/*Versiones nuevas +&useSSL=false*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
	