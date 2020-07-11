package Control;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erick
 */
public class ConexionBD { 
    private String cadenaConexion = "jdbc:mysql://";
    private String usuario = "root";
    private String contrasenia = "cometota";
    private String bd = "biblioteca";
    private String ip = "localhost:3306";
    private Statement instruccion; 
    private ResultSet tablaResultado;
    private Connection conexion; 

    
    public Connection conectar() {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            cadenaConexion += ip;
            cadenaConexion += "/" + bd;
            conexion = DriverManager.getConnection(cadenaConexion, usuario, contrasenia);
            System.out.println("Conexión exitosa");
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        } catch(ClassNotFoundException e) {
            System.out.println("Driver no encontrado.");
            return null;
        }
        return conexion;
    }           
}
