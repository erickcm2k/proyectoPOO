/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Control.ConexionBD;
import Modelo.Profesor;
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
public class ConsultasProfesor extends ConexionBD{
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
            pst.setString(5,prof.getDomicilio());
            pst.setString(6, prof.getNombreUsuario());
			pst.setString(7, prof.getClaveAcceso());
			pst.setInt(8, prof.getNumEmpleado());;
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta INSERT de Profesor.");
        }
        return false;
    }
    
    public boolean modificarProfesor(Profesor prof, Profesor nuevoprof) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "update persona set nombre=?, apellido_paterno=?, apellido_materno=?, fecha_nacimiento=?, domicilio=?, clave=?, nombre_usuario=?, numero_empleado=? where numero_empleado=?";
        try {
            pst = con.prepareStatement(sql);
            
            pst.setString(1, nuevoprof.getNombre());
            pst.setString(2, nuevoprof.getApellidoPaterno());
            pst.setString(3, nuevoprof.getApellidoMaterno());
            pst.setDate(4,nuevoprof.getFechaNacimiento());
            pst.setString(5,nuevoprof.getDomicilio());
			pst.setString(6,nuevoprof.getClaveAcceso());
			pst.setString(7,nuevoprof.getClaveAcceso());
			pst.setString(8, nuevoprof.getNombreUsuario());
			pst.setInt(9, prof.getNumEmpleado());
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta UPDATE de Profesor.");
        }
        return false;
    }    
    
    public boolean borrarEmpleado(Profesor prof) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "DELETE FROM persona WHERE numero_empleado=?";
        
        try {
            pst = con.prepareStatement(sql);
			pst.setInt(1, prof.getNumEmpleado());
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta DELETE del Profesor.");
        }
        return false;        
    }
         

    public ArrayList<Profesor> obtenerListaProfesores() {
        ArrayList<Profesor> profesor = new ArrayList();
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "SELECT * FROM persona WHERE numero_empleado IS NOT NULL;";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
				String nombre = rs.getString("nombre");
				String apellidoPaterno = rs.getString("apellido_paterno");
				String apellidoMaterno = rs.getString("apellido_materno");
				Date fechaNacimiento = rs.getDate("fecha_nacimiento");
				String domicilio = rs.getString("domicilio");
				//ArrayList<String> telefono;
				String claveAcceso = rs.getString("clave");
				String nombreUsuario = rs.getString("nombre_usuario");
				int numEmpleado = Integer.parseInt(rs.getString("numero_empleado"));
                
                Profesor prof = new Profesor( numEmpleado, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, domicilio, claveAcceso, nombreUsuario);
                profesor.add(prof);
            }
            return profesor;
        } catch(SQLException e) {
            System.out.println("Error en la consulta SELECT de Profesor.");
        }
        return null;        
    } 
	
	public Profesor obtenerProfesorNumEmpl(int id_profe) {        
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "SELECT * FROM persona numero_empleado=?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,id_profe);
            rs = pst.executeQuery();
            Profesor me = null;
            if(rs.next()) {
                
                String nombre = rs.getString("nombre");
				String apellidoPaterno = rs.getString("apellido_paterno");
				String apellidoMaterno = rs.getString("apellido_materno");
				Date fechaNacimiento = rs.getDate("fecha_nacimiento");
				String domicilio = rs.getString("domicilio");
				//ArrayList<String> telefono;
				String claveAcceso = rs.getString("clave");
				String nombreUsuario = rs.getString("nombre_usuario");
				int numEmpleado = Integer.parseInt(rs.getString("numero_empleado"));
                                
                me = new Profesor( numEmpleado, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, domicilio, claveAcceso, nombreUsuario);
            }
            return me;
        } catch(SQLException e) {
            System.out.println("Error en la consulta SELECT por numero_empleado de Profesor.");
        }
        return null;        
    } 
	
	public Profesor obtenerProfesorNombre(String nombreP) {        
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "SELECT * FROM persona nombre= ? and numero_empleado IS NOT NULL";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,nombreP);
            rs = pst.executeQuery();
            Profesor me = null;
            if(rs.next()) {
                
                String nombre = rs.getString("nombre");
				String apellidoPaterno = rs.getString("apellido_paterno");
				String apellidoMaterno = rs.getString("apellido_materno");
				Date fechaNacimiento = rs.getDate("fecha_nacimiento");
				String domicilio = rs.getString("domicilio");
				//ArrayList<String> telefono;
				String claveAcceso = rs.getString("clave");
				String nombreUsuario = rs.getString("nombre_usuario");
				int numEmpleado = Integer.parseInt(rs.getString("numero_empleado"));
                                
                me = new Profesor( numEmpleado, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, domicilio, claveAcceso, nombreUsuario);
            }
            return me;
        } catch(SQLException e) {
            System.out.println("Error en la consulta SELECT por nombre de Profesor.");
        }
        return null;        
    } 
	
	public Profesor obtenerProfesorApellidoPaterno(String paterno) {        
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "SELECT * FROM persona apellido_paterno= ? and numero_empleado IS NOT NULL";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,paterno);
            rs = pst.executeQuery();
            Profesor me = null;
            if(rs.next()) {
                
                String nombre = rs.getString("nombre");
				String apellidoPaterno = rs.getString("apellido_paterno");
				String apellidoMaterno = rs.getString("apellido_materno");
				Date fechaNacimiento = rs.getDate("fecha_nacimiento");
				String domicilio = rs.getString("domicilio");
				//ArrayList<String> telefono;
				String claveAcceso = rs.getString("clave");
				String nombreUsuario = rs.getString("nombre_usuario");
				int numEmpleado = Integer.parseInt(rs.getString("numero_empleado"));
                                
                me = new Profesor( numEmpleado, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, domicilio, claveAcceso, nombreUsuario);
            }
            return me;
        } catch(SQLException e) {
            System.out.println("Error en la consulta SELECT por apellido_paterno de Profesor.");
        }
        return null;        
    } 
	
}
