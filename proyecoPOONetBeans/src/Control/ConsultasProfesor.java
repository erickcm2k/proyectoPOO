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
         	
	public Profesor obtenerProfesorPorId(int id_profe) {        
            ResultSet rs = null;
            PreparedStatement pst = null;
            Connection con = conectar();
            ConsultasTelefono conBD = new ConsultasTelefono();        
            ArrayList<Telefono> tels = new ArrayList();
            ArrayList<String> materiasImparte = new ArrayList(); 
            String sql = "SELECT * FROM persona where id=?";

            try {
                pst = con.prepareStatement(sql);
                pst.setInt(1,id_profe);
                rs = pst.executeQuery();
                Profesor me = null;    
                if(rs.next()) {

                    String nombre = rs.getString("nombre");
                                    String apellidoPaterno = rs.getString("apellido_paterno");
                                    String apellidoMaterno = rs.getString("apellido_materno");
                                    Date fechaNacimiento = Date.valueOf(rs.getString("fecha_nacimiento"));
                                    String domicilio = rs.getString("domicilio");				
                                    String claveAcceso = rs.getString("clave");
                                    String nombreUsuario = rs.getString("nombre_usuario");
                                    int numEmpleado = Integer.parseInt(rs.getString("numero_empleado"));                               
                                    tels = conBD.obtenerTelefonosPorId(id_profe);
                                    ArrayList<String> telefonos = new ArrayList();                                
                                    for(Telefono tel : tels) {
                                        telefonos.add(tel.getTelefono());
                                    }

                    me = new Profesor(numEmpleado, materiasImparte, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, domicilio, telefonos, claveAcceso, nombreUsuario);
                }
                return me;
            } catch(SQLException e) {
                System.out.println("Error en la consulta SELECT por numero_empleado de Profesor.");
                e.printStackTrace();
            }
            return null;        
    } 
	
	public ArrayList<Profesor> obtenerListaProfesores() {        
        ArrayList<Profesor> profesores = new ArrayList();
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = conectar();       

        String sql = "SELECT * FROM persona where numero_empleado IS NOT NULL";
        
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
                int numEmpleado = Integer.parseInt(rs.getString("numero_empleado"));                   
                ConsultasTelefono conTel = new ConsultasTelefono();
                ArrayList<Telefono> tels = new ArrayList();
                ArrayList<String> telefonos = new ArrayList();                
                tels = conTel.obtenerTelefonosPorId(id);
                ArrayList<String> materiasImparte = new ArrayList();                                                                                    
                for(Telefono tel : tels) {
                   telefonos.add(tel.getTelefono());                   
                }           

                Profesor prof = new Profesor(numEmpleado, materiasImparte, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, domicilio, telefonos, claveAcceso, nombreUsuario);
                profesores.add(prof);
            }
            return profesores;
            
        } catch(SQLException e) {
            System.out.println("Error en la consulta SELECT por numero_empleado de Profesor.");
            e.printStackTrace();
        }
        return null;        
    }         
        
	
}
