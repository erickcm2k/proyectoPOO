/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Control.ConexionBD;
import Modelo.Telefono;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class ConsultasTelefono extends ConexionBD {
    
    public boolean registrarTelefono(Telefono tel) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "INSERT INTO telefono (id_persona, telefono) values(?,?)";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,tel.getId_usuario());
            pst.setString(2,tel.getTelefono());
            pst.execute();
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean modificarTelefono(Telefono tel, Telefono nuevoTel) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "UPDATE telefono SET id_persona=?, telefono=? where id_persona=? and telefono=? ";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,nuevoTel.getId_usuario());
            pst.setString(2,nuevoTel.getTelefono());
            pst.setInt(3, tel.getId_usuario());
            pst.setString(4, tel.getTelefono());
            pst.execute();
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }    
    
    public boolean borrarTelefono(Telefono tel) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "DELETE FROM telefono WHERE id_persona=? and telefono=?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,tel.getId_usuario());
            pst.setString(2,tel.getTelefono());
            pst.execute();
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;        
    }
    
    public boolean borrarTelefonoPorId(int id_persona) {
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "DELETE FROM telefono WHERE id_persona=? ";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,id_persona);
            pst.execute();
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;        
    }    
    
    public ArrayList<Telefono> obtenerTelefonosPorId(int id_persona) {
        ArrayList<Telefono> telefonos = new ArrayList();
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "SELECT * FROM telefono WHERE id_persona=?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,id_persona);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                int id = Integer.parseInt(rs.getString("id_persona"));
                String telefono = rs.getString("telefono");
                Telefono tel = new Telefono(id, telefono);
                telefonos.add(tel);
            }
            return telefonos;
        } catch(SQLException e) {
            System.out.println("Error en consulta telefonos por id.");
            e.printStackTrace();
        }
        return null;        
    }    

    public ArrayList<Telefono> obtenerListaTelefonos() {
        ArrayList<Telefono> telefonos = new ArrayList();
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = conectar();
        
        String sql = "SELECT * FROM telefono";
        
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                int id = Integer.parseInt(rs.getString("id_persona"));
                String telefono = rs.getString("telefono");
                Telefono tel = new Telefono(id, telefono);
                telefonos.add(tel);
            }
            return telefonos;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;        
    }        
    
    
}
