/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.sql.Connection;
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
        
        String sql = "insert into persona(id, nombre, apellido_paterno, apellido_materno, fecha_nacimiento, domicilio, nombre_usuario,clave,horaio_entrada_empleado,horaio_salida_empleado) values (?,?,?,?,?,?,?,?,?,?)";

        
        try {
            pst = con.prepareStatement(sql);
           // pst.setInt(1, lib.getId());
            pst.setString(2, empl.getNombre());
            pst.setString(3, empl.getApellidoPaterno());
            pst.setString(4, empl.getApellidoMaterno());
            pst.setDate(5,empl.getFechaNacimiento());
            pst.setString(6,empl.getDomicilio());
            pst.setString(7, empl.getNombreUsuario());
			pst.setString(8, empl.getClaveAcceso());
			pst.setInt(9, empl.getHoraEntrada());
			pst.setInt(10, empl.getHoraSalida());
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
        
        String sql = "update material set nombre=?, apellido_paterno=?, apellido_materno=?, fecha_nacimiento=?, domicilio=?, nombre_usuario=?,clave=?,horaio_entrada_empleado=?,horaio_salida_empleado=? where id=?";
        try {
            pst = con.prepareStatement(sql);
            
            pst.setString(2, nuevoempl.getNombre());
            pst.setString(3, nuevoempl.getApellidoPaterno());
            pst.setString(4, nuevoempl.getApellidoMaterno());
            pst.setDate(5,nuevoempl.getFechaNacimiento());
            pst.setString(6,nuevoempl.getDomicilio());
            pst.setString(7, nuevoempl.getNombreUsuario());
			pst.setString(8, nuevoempl.getClaveAcceso());
			pst.setInt(9, nuevoempl.getHoraEntrada());
			pst.setInt(10, nuevoempl.getHoraSalida());
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta UPDATE de Empleado.");
        }
        return false;
    }    
    
    public boolean borrarLibro(Libro lib) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "DELETE FROM material WHERE id=?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, lib.getId());
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta DELETE de Libro.");
        }
        return false;        
    }
    
    public Libro obtenerLibroPorId(int id_libro) {        
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "SELECT * FROM material WHERE id=?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,id_libro);
            rs = pst.executeQuery();
            Libro libro = null;
            if(rs.next()) {
                
                int id = Integer.parseInt(rs.getString("id"));
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int anio = Integer.parseInt(rs.getString("anio"));
                String areaConocimiento = rs.getString("area_conocimiento");
                int numeroEjemplares = Integer.parseInt(rs.getString("numero_ejemplares"));
                String isbn = rs.getString("isbn");
                
                
                libro = new Libro(id, titulo, autor, anio, areaConocimiento, numeroEjemplares, isbn);
            }
            return libro;
        } catch(SQLException e) {
            System.out.println("Error en la consulta SELECT por id de Libro.");
        }
        return null;        
    }    

    public ArrayList<Libro> obtenerListaLibros() {
        ArrayList<Libro> libros = new ArrayList();
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "SELECT * FROM material WHERE isbn IS NOT NULL";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                
                int id = Integer.parseInt(rs.getString("id"));
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int anio = Integer.parseInt(rs.getString("anio"));
                String areaConocimiento = rs.getString("area_conocimiento");
                int numeroEjemplares = Integer.parseInt(rs.getString("numero_ejemplares"));
                String isbn = rs.getString("isbn");
                
                
                Libro libro = new Libro(id, titulo, autor, anio, areaConocimiento, numeroEjemplares, isbn);
                libros.add(libro);
            }
            return libros;
        } catch(SQLException e) {
            System.out.println("Error en la consulta SELECT de Libro.");
        }
        return null;        
    }          
}
