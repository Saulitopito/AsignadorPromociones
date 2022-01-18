package jpa.promociones.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private Connection conexion;
		
	public void conectar() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conexion = DriverManager.getConnection(url);
		}
		catch(SQLException e) {
			System.out.println("Error al conectar con la base de datos" + e);
		}
		catch(ClassNotFoundException e) {
			System.out.println("Error en la ruta de conexión" + e);
			e.printStackTrace();
		}
	}
	
	public void cerrarConexion() {
		try {
			conexion.close();
		}
		catch(SQLException e) {
			System.out.println("Error al cerrar la conexión" + e);
		}
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
	

}
