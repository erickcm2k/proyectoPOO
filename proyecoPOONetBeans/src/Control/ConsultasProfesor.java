/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Control.ConexionBD;
import Modelo.Profesor;
import Modelo.Telefono;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jahaziel
 */
public class ConsultasProfesor extends ConexionBD {
    
    public boolean registrarProfesor(Profesor prof) {
        PreparedStatement pst = null;
        Connection con = conectar();

        String sql = "insert into persona(nombre, apellido_paterno, apellido_materno, fecha_nacimiento, domicilio, clave, nombre_usuario, numero_empleado) values (?,?,?,?,?,?,?,?)";
                    
        try {
            
            pst = con.prepareStatement(sql);
            pst.setString(1, prof.getNombre());
            pst.setString(2, prof.getApellidoPaterno());
            pst.setString(3, prof.getApellidoMaterno());
            pst.setDate(4, prof.getFechaNacimiento());
            pst.setString(5, prof.getDomicilio());
            pst.setString(6, prof.getNombreUsuario());
            pst.setString(7, prof.getClaveAcceso());
            pst.setInt(8, prof.getNumEmpleado());
            
            pst.execute();        
            return true;
            
        } catch(SQLException e) {
            System.out.println("Error en la consulta INSERT de Profesor.");
        }
        return false;
    }        
   
    
    public boolean modificarProfesor(Profesor prof, Profesor nuevoProf) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "update persona set nombre=?, apellido_paterno=?, apellido_materno=?, fecha_nacimiento=?, domicilio=?, clave=?, nombre_usuario=? numero_empleado=? where numero_empleado=?";
        try {
            pst = con.prepareStatement(sql);
            
            pst.setString(1, prof.getNombre());
            pst.setString(2, prof.getApellidoPaterno());
            pst.setString(3, prof.getApellidoMaterno());
            pst.setDate(4, prof.getFechaNacimiento());
            pst.setString(5, prof.getDomicilio());
            pst.setString(6, prof.getClaveAcceso());
            pst.setString(7, prof.getNombreUsuario());
            pst.setInt(8, prof.getNumEmpleado());            
            pst.setInt(9, nuevoProf.getNumEmpleado());
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta UPDATE de Profesor.");
        }
        return false;
    }  
    
    public boolean borrarProfesorPorNumeroEmpleado(int numero_empleado) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "DELETE FROM persona WHERE numero_empleado=?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, numero_empleado);
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta DELETE del Profesor.");
            e.printStackTrace();
        }
        return false;        
    }
         

    public ArrayList<Profesor> obtenerListaProfesores() {
        ArrayList<Profesor> profesores = new ArrayList();
        ResultSet rs = null;
        ArrayList<String> materiasImpartidas = new ArrayList();        
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "SELECT * FROM persona WHERE numero_empleado IS NOT NULL";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                String nombre = rs.getString("nombre");
                int id = Integer.parseInt(rs.getString("id"));                
                String apellidoPaterno = rs.getString("apellido_paterno");
                String apellidoMaterno = rs.getString("apellido_materno");
                Date fechaNacimiento = Date.valueOf(rs.getString("fecha_nacimiento"));
                String domicilio = rs.getString("domicilio");
                String claveAcceso = rs.getString("clave");
                String nombreUsuario = rs.getString("nombre_usuario");
                int numeroEmpleado = Integer.parseInt(rs.getString("numero_empleado"));
                ConsultasTelefono conTel = new ConsultasTelefono();
                ArrayList<Telefono> tels = new ArrayList();
                ArrayList<String> telefonos = new ArrayList();                
                tels = conTel.obtenerTelefonosPorId(id);
                for(Telefono tel : tels) {
                   telefonos.add(tel.getTelefono());                   
                }                  
                
                Profesor profesor = new Profesor(numeroEmpleado, materiasImpartidas, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, domicilio, telefonos, claveAcceso, nombreUsuario);
                profesores.add(profesor);
            }
            return profesores;
        } catch(SQLException e) {
            System.out.println("Error en la consulta SELECT de Profesor.");
        }
        return null;                     
    } 
    
    public int obtenerIdPorNumeroEmpleado(int numero_empleado) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = conectar();
        String sql = "SELECT id FROM persona WHERE numero_empleado=?";
        int id;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, numero_empleado);
            rs = pst.executeQuery();
            if(rs.next()) {                      
                id = Integer.parseInt(rs.getString("id"));
                return id;
            } else {
                return 0;
            }
            

	} catch(SQLException e) {
            System.out.println("Error en la consulta SELECT por numero_empleado de Profesor.");
            e.printStackTrace();
        }
        return 0;        
    }    
	
	public Profesor obteneProfesorPorId(int id_profesor) {        
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = conectar();
        ConsultasTelefono conBD = new ConsultasTelefono();
        ArrayList<Telefono> tels = new ArrayList();
        ArrayList<String> materiasImpartidas = new ArrayList();
        String sql = "SELECT * FROM persona WHERE id=?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id_profesor);
            rs = pst.executeQuery();
            Profesor profesor = null;
            if(rs.next()) {
                
                String nombre = rs.getString("nombre");
                String apellidoPaterno = rs.getString("apellido_paterno");
                String apellidoMaterno = rs.getString("apellido_materno");
                Date fechaNacimiento = Date.valueOf(rs.getString("fecha_nacimiento"));
                String domicilio = rs.getString("domicilio");
                String claveAcceso = rs.getString("clave");
                String nombreUsuario = rs.getString("nombre_usuario");
                int numeroEmpleado = Integer.parseInt(rs.getString("numero_empleado"));
                tels = conBD.obtenerTelefonosPorId(id_profesor);
                ArrayList<String> telefonos = new ArrayList();                                
                for(Telefono tel : tels) {
                    telefonos.add(tel.getTelefono());
                }        
                
                profesor = new Profesor(numeroEmpleado, materiasImpartidas, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, domicilio, telefonos, claveAcceso, nombreUsuario);
                return profesor;
            }
	} catch(SQLException e) {
            System.out.println("Error en la consulta SELECT por numero_empleado de Profesor.");
            e.printStackTrace();
        }
        return null;        
    }	
}
