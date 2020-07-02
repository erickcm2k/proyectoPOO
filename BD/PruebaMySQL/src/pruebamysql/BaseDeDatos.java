package pruebamysql;

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
            System.out.println(cadenaConexion);
            conexion = DriverManager.getConnection(cadenaConexion, usuario, contrasenia);
                        
            
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        } catch(ClassNotFoundException e) {
            System.out.println("Driver no encontrado.");
            return false;
        }
        return true;
    }
    
    public void ejecutarSentencia() {
        try {
                       
            Statement myStatement = conexion.createStatement();
            ResultSet myResult = myStatement.executeQuery("select * from prestamo");
            ArrayList<Prestamo> prestamos = new ArrayList();
            while(myResult.next()) {            
                
                
                int idPrestamo = Integer.parseInt(myResult.getString("id_prestamo"));
                int idPersona = Integer.parseInt(myResult.getString("id_persona"));
                int idMaterial = Integer.parseInt(myResult.getString("id_material"));
                Date fechaPrestamo = Date.valueOf(myResult.getString("fecha_prestamo"));
                Date fechaDevolucion = Date.valueOf(myResult.getString("fecha_devolucion"));
                double multa = Double.parseDouble(myResult.getString("multa"));  
                    
                Prestamo prestamoActual = new Prestamo(idPrestamo, idPersona, idMaterial, fechaPrestamo, fechaDevolucion, multa);
               prestamos.add(prestamoActual);
            } 
            
            int i = 0;
            for(Prestamo prestamo: prestamos) {
                System.out.println("Elemento" + i++);
                System.out.println(prestamo.getId_prestamo());
                System.out.println(prestamo.getId_persona());
                System.out.println(prestamo.getId_material());
                System.out.println(prestamo.getFecha_prestamo());
                System.out.println(prestamo.getFecha_devolucion());
                System.out.println(prestamo.getMulta());
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarTelefono() {
        try {
            Statement myStatement = conexion.createStatement();
            
            int id_usuario = 1;
            int telefono = 12345;
            
                    
            PreparedStatement post = conexion.prepareStatement("insert into telefono(id_usuario, telefono) values("+id_usuario+","+telefono+");");
            post.executeUpdate();
            
            //ResultSet myResult = myStatement.executeQuery("insert into telefono(id_usuario, telefono) values(" + id_usuario + "," + telefono + ")");            
        } catch(SQLException e) {
            System.out.println("Error al ingresar datos, revisar detalles de la consulta.");
        }
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