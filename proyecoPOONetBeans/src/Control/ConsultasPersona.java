/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Control.ConexionBD;
import Modelo.*;
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
public class ConsultasPersona extends ConexionBD{
	 public ArrayList<Persona> obtenerListaPersonas() {
        ArrayList<Persona> persona = new ArrayList();
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = conectar();
		
        /*
		*********************Agregar Profesores********************************
		*/
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
                
                Persona prof = new Profesor( numEmpleado, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, domicilio, claveAcceso, nombreUsuario);
                persona.add(prof);
            }
        } catch(SQLException e) {
            System.out.println("Error en la consulta SELECT de Profesor.");
        }
		
		/*
		*********************Agregar Alumnos********************************
		*/
        sql = "SELECT * FROM persona WHERE boleta_alumno IS NOT NULL;";
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
                
                Persona alumno = new Alumno( boleta,nivel, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, domicilio, claveAcceso, nombreUsuario);
                persona.add(alumno);
            }
        } catch(SQLException e) {
            System.out.println("Error en la consulta SELECT de Alumno.");
        }
		/*
		*********************Agregar Empleados********************************
		*/
		sql = "SELECT * FROM persona WHERE horario_entrada_empleado IS NOT NULL AND horario_salida_empleado IS NOT NULL;";
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
				int horaEntrada = Integer.parseInt(rs.getString("horario_entrada_empleado"));
				int horaSalida = Integer.parseInt(rs.getString("horario_salida_empleado"));
                
                Persona empleado = new Empleado( horaEntrada, horaSalida, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, domicilio, claveAcceso, nombreUsuario);
                persona.add(empleado);
            }
            return persona;
        } catch(SQLException e) {
            System.out.println("Error en la consulta SELECT de Empleado.");
        }
        return null;
    } 
	
}
