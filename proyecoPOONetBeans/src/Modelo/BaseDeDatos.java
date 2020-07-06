package Modelo;

import java.sql.*;
import java.util.ArrayList;
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
            conexion = DriverManager.getConnection(cadenaConexion, usuario, contrasenia);
            System.out.println("Conexión exitosa");
            
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        } catch(ClassNotFoundException e) {
            System.out.println("Driver no encontrado.");
            return false;
        }
        return true;
    }          
    
    /* Operaciones SQL para obtener los teléfonos del usuario. */
    public void insertarTelefono(String id_persona, String telefono) { 
        String sentencia = "insert into telefono(id_persona, telefono) values("+id_persona+","+telefono+");";
        ejecutarSQL(sentencia);
    }
    public void actualizarTelefono(String id_persona, String telefono,String id_persona_nuevo, String telefono_nuevo) {
        String sentencia = "update telefono set id_persona="+id_persona_nuevo+", telefono="+telefono_nuevo+"" + " where id_persona="+id_persona+" and telefono="+telefono+";";
        ejecutarSQL(sentencia);
    }
    public void borrarTelefono(int id_persona, String telefono) { 
        String sentencia = "delete from telefono where id_persona="+id_persona+" and telefono="+telefono+";";
        ejecutarSQL(sentencia);        
    }
    public ArrayList<Telefono> obtenerTelefonosPorId(int id_persona) { 
        String sentencia = "select * from telefono where id_persona="+id_persona+";";       
        ArrayList<Telefono> telefonos = new ArrayList();
        try {
            Statement myStatement = conexion.createStatement();
            ResultSet myResult = myStatement.executeQuery(sentencia);
            System.out.println(sentencia);
            while(myResult.next()) {   
                int id = Integer.parseInt(myResult.getString("id_persona"));
                int tel = Integer.parseInt(myResult.getString("telefono"));

                Telefono telefonoActual = new Telefono(id, tel);
                telefonos.add(telefonoActual);
            }                  
            return telefonos;
        } catch(SQLException e) {
            e.printStackTrace();
        }    
        return null;
    }    
    public ArrayList<Telefono> obtenerTodoTelefono() { 
        String sentencia = "select * from telefono;";
        ArrayList<Telefono> telefonos = new ArrayList();
        try {
            Statement myStatement = conexion.createStatement();
            ResultSet myResult = myStatement.executeQuery(sentencia);
            System.out.println(sentencia);
            while(myResult.next()) {   
                int id = Integer.parseInt(myResult.getString("id_persona"));
                int tel = Integer.parseInt(myResult.getString("telefono"));

                Telefono telefono = new Telefono(id, tel);
                telefonos.add(telefono);
            }                  
            return telefonos;
        } catch(SQLException e) {
            e.printStackTrace();
        }    
        return null;
    }
    
    
    
    public boolean ejecutarSQL(String sentencia) {
        int tipo = tipoSentencia(sentencia);
        
        switch(tipo) {
            case 1: // SQL INSERT             
                System.out.println(sentencia);
                try {
                    Statement myStatement = conexion.createStatement();                    
                    PreparedStatement post = conexion.prepareStatement(sentencia);
                    post.executeUpdate();
                } catch(SQLException e) {
                    System.out.println("Error al ingresar datos, revisar detalles de la consulta.");
                }                
                break;
                
            case 2: // SQL UPDATE
                System.out.println(sentencia);
                try {
                    instruccion = conexion.createStatement();
                    instruccion.execute(sentencia);
                } catch(SQLException e) {
                    java.util.logging.Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, e);
                    return false;
                }
                break;
                
            case 3: // SQL DELETE
                System.out.println(sentencia);
                try {
                    Statement myStatement = conexion.createStatement();
                    myStatement.executeUpdate(sentencia);
                } catch(SQLException e) {
                    java.util.logging.Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, e);
                    return false;
                } 
                break;
                                     
            default: 
                System.out.println("Error: Sentencia SQL no válida.");
                break;               
            }
         return false;
    }
    
    public boolean cerrarConexion() {
        try {
            conexion.close();
        } catch(SQLException e) {
            System.out.println("Error al cerrar conexión.");
            return false;
        }
        return true;
    }    
    
    private int tipoSentencia(String sentenciaSQL) {
        int tipo = 0;

        int index = sentenciaSQL.indexOf(' ');
        String tipoSentencia = sentenciaSQL.substring(0, index).trim().toLowerCase();
        
        switch (tipoSentencia) {
            case "insert":
                tipo = 1;
                break;
            case "update":
                tipo = 2;
                break;
            case "delete":
                tipo = 3;
                break;
            case "select":
                tipo = 4;               
                if(sentenciaSQL.toLowerCase().contains("where")) {
                    tipo = 5;
                }   break;
            default:
                break;
        }
        System.out.println(tipoSentencia + " " + tipo);
        return tipo;
    }    
}