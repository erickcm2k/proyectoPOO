/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecopoonetbeans;

import Modelo.*;
import java.util.ArrayList;

/**
 *
 * @author Jahaziel
 */
public class ProyecoPOONetBeans {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BaseDeDatos miBD = new BaseDeDatos("localhost:3306", "root", "cometota", "biblioteca");
        miBD.conectar();
        //BIEN  miBD.insertarTelefono("1", "1111"); 
        //BIEN miBD.actualizarTelefono("1", "12345", "2", "2222");
        //BIEN miBD.borrarTelefono(2, "2222");
        try {
        ArrayList<Telefono> telefonos = miBD.obtenerTelefonosPorId(1);            
        } catch(Exception e) {
            System.out.println("No se pudo");
        }
        
        //BIEN ArrayList<Telefono> telefonos = miBD.obtenerTodoTelefono();

        
        miBD.cerrarConexion();
    }
     
    
}
