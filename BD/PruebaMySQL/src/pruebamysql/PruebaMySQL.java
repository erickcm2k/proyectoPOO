/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebamysql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author erick
 */
public class PruebaMySQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*try {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "cometota");
        } catch(Exception e) {
            e.printStackTrace();
        }*/
        BaseDeDatos miBD = new BaseDeDatos("localhost:3306", "root", "cometota", "biblioteca");
        miBD.conectar();
        miBD.cerrar();
     
    }
    
}
