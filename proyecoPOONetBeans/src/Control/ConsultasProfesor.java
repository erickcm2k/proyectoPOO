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
    
	/*public boolean registrarProfesor(Profesor prof) {
        PreparedStatement pst = null;
        Connection con = conectar();
        ArrayList<String> telefonos = new ArrayList();
        for(String tels : prof.getTelefono()) {
            telefonos.add(tels);
        }      
        
        String sql = "insert into persona(nombre, apellido_paterno, apellido_materno, fecha_nacimiento, domicilio, clave, nombre_usuario, boleta_alumno, nivel_alumno) values (?,?,?,?,?,?,?,?,?)";
            
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, prof.getNombre());
            pst.setString(2, prof.getApellidoPaterno());
            pst.setString(3, prof.getApellidoMaterno());
            pst.setDate(4, prof.getFechaNacimiento());
            pst.setString(5, prof.getDomicilio());
            pst.setString(6, prof.getNombreUsuario());
            pst.setString(7, prof.getClaveAcceso());
            pst.setInt(8, prof.getBoleta());
            pst.setString(9, prof.getNivel());
            pst.execute();        
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta INSERT de Profesor.");
        }
        return false;
    }        
   
    
    public boolean modificarProfesor(Profesor alum, Profesor nuevoAlum) {
        return false;
    }    
    
    public boolean borrarProfesorPorNumeroEmpleado(int boleta) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "DELETE FROM persona WHERE boleta_alumno=?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, boleta);
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta DELETE del Profesor.");
            e.printStackTrace();
        }
        return false;        
    }
         

    public ArrayList<Profesor> obtenerListaProfesores() {
        ArrayList<Profesor> alumnos = new ArrayList();
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "SELECT * FROM persona WHERE boleta_alumno IS NOT NULL";
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
                int boleta = Integer.parseInt(rs.getString("boleta_alumno"));
                String nivel = rs.getString("nivel_alumno");
                ConsultasTelefono conTel = new ConsultasTelefono();
                ArrayList<Telefono> tels = new ArrayList();
                ArrayList<String> telefonos = new ArrayList();                
                tels = conTel.obtenerTelefonosPorId(id);
                for(Telefono tel : tels) {
                   telefonos.add(tel.getTelefono());                   
                }                  
                
                Profesor alum = new Profesor(boleta, nivel, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, domicilio, telefonos, claveAcceso, nombreUsuario);
                alumnos.add(alum);
            }
            return alumnos;
        } catch(SQLException e) {
            System.out.println("Error en la consulta SELECT de Profesor.");
        }
        return null;        
    } 
	
	public Profesor obtenerAlumnoPorId(int id_alumno) {        
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = conectar();
        ConsultasTelefono conBD = new ConsultasTelefono();
        ArrayList<Telefono> tels = new ArrayList();
        String sql = "SELECT * FROM persona WHERE id=?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,id_alumno);
            rs = pst.executeQuery();
            Profesor alumno = null;
            if(rs.next()) {
                
                String nombre = rs.getString("nombre");
                String apellidoPaterno = rs.getString("apellido_paterno");
                String apellidoMaterno = rs.getString("apellido_materno");
                Date fechaNacimiento = Date.valueOf(rs.getString("fecha_nacimiento"));
                String domicilio = rs.getString("domicilio");
                String claveAcceso = rs.getString("clave");
                String nombreUsuario = rs.getString("nombre_usuario");
                int boleta = Integer.parseInt(rs.getString("boleta_alumno"));
                String nivel = rs.getString("nivel_alumno");
                tels = conBD.obtenerTelefonosPorId(id_alumno);
                ArrayList<String> telefonos = new ArrayList();                                
                for(Telefono tel : tels) {
                    telefonos.add(tel.getTelefono());
                }        
                
                alumno = new Profesor(boleta, nivel, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, domicilio, telefonos, claveAcceso, nombreUsuario);
                return alumno;
            }
	} catch(SQLException e) {
            System.out.println("Error en la consulta SELECT por numero_empleado de Profesor.");
            e.printStackTrace();
        }
        return null;        
    }	*/
}
