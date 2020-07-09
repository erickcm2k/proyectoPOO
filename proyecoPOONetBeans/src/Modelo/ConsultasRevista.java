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
public class ConsultasRevista extends ConexionBD {
    
    public boolean registrarRevista(Revista rev) {
        PreparedStatement pst = null;
        Connection con = conectar();

        String sql = "insert into material (id, titulo, autor, anio, area_conocimiento, numero_ejemplares, volumen, numero) values (?,?,?,?,?,?,?,?)";
                
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, rev.getId());
            pst.setString(2, rev.getTitulo());
            pst.setString(3, rev.getAutor());
            pst.setInt(4, rev.getAnio());
            pst.setString(5,rev.getAreaConocimiento());
            pst.setInt(6,rev.getNumEjemplares());
            pst.setInt(7, rev.getVolumen());
            pst.setInt(8, rev.getNumero());
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta INSERT de Revista.");
        }
        return false;
    }
    
    public boolean modificarRevista(Revista rev, Revista nuevaRev) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "update material set id=?, titulo=?, autor=?, anio=?, area_conocimiento=?, numero_ejemplares=?, volumen=?, numero=? where id=?";
        try {
            pst = con.prepareStatement(sql);
            
            pst.setInt(1, nuevaRev.getId());
            pst.setString(2, nuevaRev.getTitulo());
            pst.setString(3, nuevaRev.getAutor());
            pst.setInt(4, nuevaRev.getAnio());
            pst.setString(5, nuevaRev.getAreaConocimiento());
            pst.setInt(6,nuevaRev.getNumEjemplares());
            pst.setInt(7, nuevaRev.getVolumen());    
            pst.setInt(8, nuevaRev.getNumero());    
            pst.setInt(9, rev.getId());
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta UPDATE de Revista.");
            e.printStackTrace();
        }
        return false;
    }    
    
    public boolean borrarRevista(Revista me) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "DELETE FROM material WHERE id=?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, me.getId());
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta DELETE de Revista.");
        }
        return false;        
    }
    
    public Revista obtenerRevistaPorId(int id_revista) {        
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "SELECT * FROM material WHERE id=?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,id_revista);
            rs = pst.executeQuery();
            Revista revista = null;
            if(rs.next()) {
                
                int id = Integer.parseInt(rs.getString("id"));
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int anio = Integer.parseInt(rs.getString("anio"));
                String areaConocimiento = rs.getString("area_conocimiento");
                int numeroEjemplares = Integer.parseInt(rs.getString("numero_ejemplares"));
                int volumen = Integer.parseInt(rs.getString("volumen"));
                int numero = Integer.parseInt("numero");
                                
                revista = new Revista(volumen, numero, id, titulo, autor, anio, areaConocimiento, numeroEjemplares);
            }
            return revista;
        } catch(SQLException e) {
            System.out.println("Error en la consulta SELECT por id de Revista.");
        }
        return null;        
    }    

    public ArrayList<Revista> obtenerListaRevista() {
        ArrayList<Revista> revistas = new ArrayList();
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "SELECT * FROM MATERIAL WHERE volumen IS NOT NULL AND numero IS NOT NULL";
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
                int volumen = Integer.parseInt(rs.getString("volumen"));
                int numero = Integer.parseInt(rs.getString("numero"));
                                            
                Revista revista = new Revista(volumen, numero, id, titulo, autor, anio, areaConocimiento, numeroEjemplares);
                revistas.add(revista);
            }
            return revistas;
        } catch(SQLException e) {
            System.out.println("Error en la consulta SELECT de Revista.");
            e.printStackTrace();
        }
        return null;        
    }            
}
