package jpa.promociones.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCProcedimiento {
	
	/**
	 * asignarPromociones: gesta la conexión con la BD por medio de JDBC y ejecuta el 
	 * 					   procedimiento de asignación de promociones ya definido en Oracle DB
	 */
	public static void asignarPromociones() {
		
		Connection conexion = null;
		Statement stmt;
		
		try {
			conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "saul_proyecto", "1026282037");
			conexion.setAutoCommit(false);
			stmt = conexion.createStatement();
			stmt.executeUpdate("CALL asignarPromociones()");
			stmt.close();
			conexion.commit();
			conexion.close();
		}
		catch(SQLException e) {
			if (conexion != null) {
				try {
					conexion.rollback();
					conexion.close();
				}
				catch(SQLException ex) {
					System.out.println("Error al ejecutar el procedimiento " + e);					
				}
			}
			System.out.println("Error al realizar la conexión");
		}
	}
	
	/**
	 * quitarPromociones: gesta la conexión con la BD por medio de JDBC y ejecuta el 
	 * 					  procedimiento de quitar las promociones ya definido en Oracle DB
	 */
	public static void quitarPromociones() {
		
		Connection conexion = null;
		Statement stmt;
		
		try {
			conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "saul_proyecto", "1026282037");
			conexion.setAutoCommit(false);
			stmt = conexion.createStatement();
			stmt.executeUpdate("CALL quitarPromociones()");
			stmt.close();
			conexion.commit();
			conexion.close();
		}
		catch(SQLException e) {
			if (conexion != null) {
				try {
					conexion.rollback();
					conexion.close();
				}
				catch(SQLException ex) {
					System.out.println("Error al ejecutar el procedimiento " + e);					
				}
			}
			System.out.println("Error al realizar la conexión");
		}
	}
	
}
