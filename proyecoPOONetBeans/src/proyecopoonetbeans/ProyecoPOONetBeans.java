/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecopoonetbeans;
import Modelo.ConexionBD;
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
        Libro libro = new Libro(1234, "Libro 1234", "autor1", 2000, "area1", 100, "12345");
        ConsultasLibro conLib = new ConsultasLibro();
  
        Libro libroNuevo = conLib.obtenerLibroPorId(10);
        System.out.println(libroNuevo.getIsbn());
   
    }
     
    
}
