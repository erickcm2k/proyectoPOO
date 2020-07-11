/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Control.ConexionBD;
import Modelo.Alumno;
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
public class ConsultasAlumno extends ConexionBD{
	public boolean registrarAlumno(Alumno alum) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "insert into persona(nombre, apellido_paterno, apellido_materno, fecha_nacimiento, domicilio, clave, nombre_usuario, boleta_alumno, nivel_alumno) values (?,?,?,?,?,?,?,?,?)";

        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, alum.getNombre());
            pst.setString(2, alum.getApellidoPaterno());
            pst.setString(3, alum.getApellidoMaterno());
            pst.setDate(4, alum.getFechaNacimiento());
            pst.setString(5,alum.getDomicilio());
            pst.setString(6, alum.getNombreUsuario());
			pst.setString(7, alum.getClaveAcceso());
			pst.setInt(8, alum.getBoleta());
			pst.setString(9, alum.getNivel());
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta INSERT de Alumno.");
        }
        return false;
    }
    
    public boolean modificarAlumno(Alumno alum, Alumno nuevoAlum) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "update persona set nombre=?, apellido_paterno=?, apellido_materno=?, fecha_nacimiento=?, domicilio=?, clave=?, nombre_usuario=?, boleta_alumno=?, nivel_alumno=? where boleta_alumno=?";
        try {
            pst = con.prepareStatement(sql);
            
            pst.setString(1, nuevoAlum.getNombre());
            pst.setString(2, nuevoAlum.getApellidoPaterno());
            pst.setString(3, nuevoAlum.getApellidoMaterno());
            pst.setDate(4,nuevoAlum.getFechaNacimiento());
            pst.setString(5,nuevoAlum.getDomicilio());
			pst.setString(6,nuevoAlum.getClaveAcceso());
			pst.setString(7,nuevoAlum.getNombreUsuario());
			pst.setInt(8, nuevoAlum.getBoleta());
			pst.setString(9,nuevoAlum.getNivel());
			pst.setInt(10, alum.getBoleta());
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta UPDATE de Alumno.");
        }
        return false;
    }    
    
    public boolean borrarAlumno(Alumno alum) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "DELETE FROM persona WHERE boleta_alumno=?";
        
        try {
            pst = con.prepareStatement(sql);
			pst.setInt(1, alum.getBoleta());
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta DELETE del Alumno.");
        }
        return false;        
    }
         

    public ArrayList<Alumno> obtenerListaAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList();
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "SELECT * FROM persona WHERE boleta_alumno IS NOT NULL;";
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
				int boleta = Integer.parseInt(rs.getString("boleta_alumno"));
				String nivel = rs.getString("nivel_alumno");
                
                Alumno alum = new Alumno( boleta,nivel, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, domicilio, claveAcceso, nombreUsuario);
                alumnos.add(alum);
            }
            return alumnos;
        } catch(SQLException e) {
            System.out.println("Error en la consulta SELECT de Alumno.");
        }
        return null;        
    } 
	
	public Alumno obtenerAlumnoBoleta(int id_alumno) {        
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "SELECT * FROM persona boleta_alumno=?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,id_alumno);
            rs = pst.executeQuery();
            Alumno me = null;
            if(rs.next()) {
                
                String nombre = rs.getString("nombre");
				String apellidoPaterno = rs.getString("apellido_paterno");
				String apellidoMaterno = rs.getString("apellido_materno");
				Date fechaNacimiento = rs.getDate("fecha_nacimiento");
				String domicilio = rs.getString("domicilio");
				//ArrayList<String> telefono;
				String claveAcceso = rs.getString("clave");
				String nombreUsuario = rs.getString("nombre_usuario");
				int boleta = Integer.parseInt(rs.getString("boleta_alumno"));
				String nivel = rs.getString("nivel_alumno");
                
                me= new Alumno( boleta,nivel, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, domicilio, claveAcceso, nombreUsuario);
                
				return me;
			}
		}
		catch(SQLException e) {
            System.out.println("Error en la consulta SELECT por numero_empleado de Profesor.");
        }
        return null;        
    }
	
	
}
