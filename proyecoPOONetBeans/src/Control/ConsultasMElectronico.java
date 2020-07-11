/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Control.ConexionBD;
import Modelo.MaterialElectronico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class ConsultasMElectronico extends ConexionBD {
    
    public boolean registrarMaterialElectronico(MaterialElectronico me) {
        PreparedStatement pst = null;
        Connection con = conectar();

        String sql = "insert into material (id, titulo, autor, anio, area_conocimiento, numero_ejemplares, pagina_descarga, clave_temporal) values (?,?,?,?,?,?,?,?)";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, me.getId());
            pst.setString(2, me.getTitulo());
            pst.setString(3, me.getAutor());
            pst.setInt(4, me.getAnio());
            pst.setString(5,me.getAreaConocimiento());
            pst.setInt(6,me.getNumEjemplares());
            pst.setString(7, me.getPaginaDescarga());
            pst.setInt(8, me.getClaveTemporal());
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta INSERT de Material Electrónico.");
        }
        return false;
    }
    
    public boolean modificarMaterialElectronico(MaterialElectronico me, MaterialElectronico meNuevo) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "update material set id=?, titulo=?, autor=?, anio=?, area_conocimiento=?, numero_ejemplares=?, pagina_descarga=?, clave_temporal=? where id=?";
        try {
            pst = con.prepareStatement(sql);
            
            pst.setInt(1, meNuevo.getId());
            pst.setString(2, meNuevo.getTitulo());
            pst.setString(3, meNuevo.getAutor());
            pst.setInt(4, meNuevo.getAnio());
            pst.setString(5, meNuevo.getAreaConocimiento());
            pst.setInt(6,meNuevo.getNumEjemplares());
            pst.setString(7, meNuevo.getPaginaDescarga());    
            pst.setInt(8, meNuevo.getClaveTemporal());    
            pst.setInt(9, me.getId());
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta UPDATE de Material Electrónico.");
            e.printStackTrace();
        }
        return false;
    }    
    
    public boolean borrarMaterialElectronico(MaterialElectronico me) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "DELETE FROM material WHERE id=?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, me.getId());
            pst.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("Error en la consulta DELETE de Material Electrónico.");
        }
        return false;        
    }
    
    public MaterialElectronico obtenerMaterialElectronicoPorId(int id_me) {        
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "SELECT * FROM material WHERE id=?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,id_me);
            rs = pst.executeQuery();
            MaterialElectronico me = null;
            if(rs.next()) {
                
                int id = Integer.parseInt(rs.getString("id"));
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int anio = Integer.parseInt(rs.getString("anio"));
                String areaConocimiento = rs.getString("area_conocimiento");
                int numeroEjemplares = Integer.parseInt(rs.getString("numero_ejemplares"));
                String paginaDescarga = rs.getString("pagina_descarga");
                int claveTemporal = Integer.parseInt("clave_temporal");
                                
                me = new MaterialElectronico(paginaDescarga, claveTemporal, id, titulo, autor, anio, areaConocimiento, numeroEjemplares);
            }
            return me;
        } catch(SQLException e) {
            System.out.println("Error en la consulta SELECT por id de Material Electrónico.");
        }
        return null;        
    }    

    public ArrayList<MaterialElectronico> obtenerListaMaterialesElectronicos() {
        ArrayList<MaterialElectronico> materialesElectronicos = new ArrayList();
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "SELECT * FROM material WHERE pagina_descarga IS NOT NULL AND clave_temporal IS NOT NULL";
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
                String paginaDescarga = rs.getString("pagina_descarga");
                int claveTemporal = Integer.parseInt(rs.getString("clave_temporal"));
                
                            
                MaterialElectronico me = new MaterialElectronico(paginaDescarga, claveTemporal, id, titulo, autor, anio, areaConocimiento, numeroEjemplares);
                materialesElectronicos.add(me);
            }
            return materialesElectronicos;
        } catch(SQLException e) {
            System.out.println("Error en la consulta SELECT de Material Electrónico.");
            e.printStackTrace();
        }
        return null;        
    }            
}
