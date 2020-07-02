package pruebamysql;

import java.sql.*;
import java.util.logging.Level;

public class BaseDeDatos { 
    private String cadenaConexion, usuario, contrasenia, bd, ip;
    private Statement instruccion; 
    private ResultSet tablaResultado;
    private Connection conexion; 

    public BaseDeDatos (String ip, String usuario, String contrasenia, String bd) { 
        this.ip = ip; 
        this.usuario = usuario; 
        this.contrasenia = contrasenia; 
        this.bd = bd; 
    }
    
    public boolean conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cadenaConexion = "jdbc:mysql://";
            cadenaConexion += ip;
            cadenaConexion += "/" + bd;
            System.out.println(cadenaConexion);
            conexion = DriverManager.getConnection(cadenaConexion, usuario, contrasenia);
            
            
            Statement myStatement = conexion.createStatement();
            ResultSet myResult = myStatement.executeQuery("select * from usuario");
            
            while(myResult.next()) {
                System.out.println(myResult.getString("id") + " " + myResult.getString("nombre"));
            }
            
            
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        } catch(ClassNotFoundException e) {
            System.out.println("Driver no encontrado.");
            return false;
        }
        return true;
    }

    public boolean cerrar() {
        try {
            conexion.close();
        } catch(SQLException e) {
            System.out.println("Error al cerrar conexión.");
            return false;
        }
        return true;
    }
    
    public boolean ejecutarSQL(String sentencia, int tipo) {
        switch(tipo) {
            case 1:
                try {
                    instruccion = conexion.createStatement();
                    tablaResultado = instruccion.executeQuery(sentencia);
                } catch(SQLException e) {
                    java.util.logging.Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, e);
                    return false;
                }
                break;
                
            case 2: 
                try {
                    instruccion = conexion.createStatement();
                    instruccion.execute(sentencia);
                    System.out.println("Datos ingresados...");;
                } catch(SQLException e) {
                    java.util.logging.Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, e);
                    return false;
                }
                break;
              
            default: 
                System.out.println("Error: Opción no válida.");
                break;               
            }
         return false;
    }
}