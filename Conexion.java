package ProyectoFinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

  
    private static final String URL = "jdbc:mysql://localhost:3306/concesionario?serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CLAVE = ""; 

      
    
    	 public static Connection getConnection() {
    	        Connection conn = null;
    	        try {
    	            conn = DriverManager.getConnection(URL, USUARIO, CLAVE);
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	        return conn;
    	    }
    }
