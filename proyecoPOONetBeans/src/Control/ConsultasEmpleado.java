/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Control.ConexionBD;
import Modelo.Empleado;
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
public class ConsultasEmpleado  extends ConexionBD{
	public boolean registrarEmpleado(Empleado empl) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "insert into persona(nombre, apellido_paterno, apellido_materno, fecha_nacimiento, domicilio, nombre_usuario,clave,horario_entrada_empleado,horario_salida_empleado) values (?,?,?,?,?,?,?,?,?)";

        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, empl.getNombre());
            pst.setString(2, empl.getApellidoPaterno());
            pst.setString(3, empl.getApellidoMaterno());
            pst.setDate(4,empl.getFechaNacimiento());
            pst.setString(5,empl.getDomicilio());
            pst.setString(6, empl.getNombreUsuario());
			pst.setString(7, empl.getClaveAcceso());
			pst.setInt(8, empl.getHoraEntrada());
			pst.setInt(9, empl.getHoraSalida());
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta INSERT de Empleado.");
        }
        return false;
    }
    
    public boolean modificarEmpleado(Empleado empl, Empleado nuevoempl) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "update persona set nombre=?, apellido_paterno=?, apellido_materno=?, fecha_nacimiento=?, domicilio=?,horario_entrada_empleado=?,horario_salida_empleado=? where nombre=? and apellido_paterno=? and apellido_materno=? and horario_entrada_empleado=? and horario_salida_empleado=?";
        try {
            pst = con.prepareStatement(sql);
            
            pst.setString(1, nuevoempl.getNombre());
            pst.setString(2, nuevoempl.getApellidoPaterno());
            pst.setString(3, nuevoempl.getApellidoMaterno());
            pst.setDate(4,nuevoempl.getFechaNacimiento());
            pst.setString(5,nuevoempl.getDomicilio());
			pst.setInt(6, nuevoempl.getHoraEntrada());
			pst.setInt(7, nuevoempl.getHoraSalida());
			pst.setString(8, empl.getNombre());
            pst.setString(9, empl.getApellidoPaterno());
            pst.setString(10, empl.getApellidoMaterno());
			pst.setInt(11, empl.getHoraEntrada());
			pst.setInt(12, empl.getHoraSalida());
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta UPDATE de Empleado.");
        }
        return false;
    }    
    
    public boolean borrarEmpleado(Empleado empl) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "DELETE FROM persona WHERE nombre=? and apellido_paterno=? and apellido_materno=? and horario_entrada_empleado=? and horario_salida_empleado=?";
        
        try {
            pst = con.prepareStatement(sql);
			pst.setString(1, empl.getNombre());
            pst.setString(2, empl.getApellidoPaterno());
            pst.setString(3, empl.getApellidoMaterno());
			pst.setInt(4, empl.getHoraEntrada());
			pst.setInt(5, empl.getHoraSalida());
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta DELETE del Empleado.");
        }
        return false;        
    }
         

    public ArrayList<Empleado> obtenerListaEmpleados() {
        ArrayList<Empleado> empleado = new ArrayList();
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "SELECT * FROM persona WHERE horario_entrada_empleado IS NOT NULL AND horario_salida_empleado IS NOT NULL;";
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
                
                Empleado empl = new Empleado( horaEntrada, horaSalida, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, domicilio, claveAcceso, nombreUsuario);
                empleado.add(empl);
            }
            return empleado;
        } catch(SQLException e) {
            System.out.println("Error en la consulta SELECT de Empleado.");
        }
        return null;        
    }          
}
