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
public abstract class ConexionBD { 
    protected String cadenaConexion = "jdbc:mysql://";
    protected String usuario = "root";
    protected String contrasenia = "root";
    protected String bd = "biblioteca";
    protected String ip = "localhost:3306";
    protected Statement instruccion; 
    protected ResultSet tablaResultado;
    protected Connection conexion; 

    
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
