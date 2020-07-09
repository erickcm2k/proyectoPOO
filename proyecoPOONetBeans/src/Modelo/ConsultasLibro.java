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
 * @author erick
 */
public class ConsultasLibro extends ConexionBD {
    
    public boolean registrarLibro(Libro lib) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "insert into material(id, titulo, autor, anio, area_conocimiento, numero_ejemplares, isbn) values (?,?,?,?,?,?,?)";

        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, lib.getId());
            pst.setString(2, lib.getTitulo());
            pst.setString(3, lib.getAutor());
            pst.setInt(4, lib.getAnio());
            pst.setString(5,lib.getAreaConocimiento());
            pst.setInt(6,lib.getNumEjemplares());
            pst.setString(7, lib.getIsbn());
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta INSERT de Libro.");
        }
        return false;
    }
    
    public boolean modificarLibro(Libro lib, Libro nuevoLib) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "update material set id=?, titulo=?, autor=?, anio=?, area_conocimiento=?, numero_ejemplares=?, isbn=? where id=?";
        try {
            pst = con.prepareStatement(sql);
            
            pst.setInt(1, nuevoLib.getId());
            pst.setString(2, nuevoLib.getTitulo());
            pst.setString(3, nuevoLib.getAutor());
            pst.setInt(4, nuevoLib.getAnio());
            pst.setString(5, nuevoLib.getAreaConocimiento());
            pst.setInt(6,nuevoLib.getNumEjemplares());
            pst.setString(7, nuevoLib.getIsbn());    
            pst.setInt(8, lib.getId());
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta UPDATE de Libro.");
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
