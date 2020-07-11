/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecopoonetbeans;
import Control.*;
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
            /*ConsultasProfesor con = new ConsultasProfesor();
            Profesor prof = con.obtenerProfesorPorId(118);            

            
            System.out.println(prof.getNombre());
            for(String tel : prof.getTelefono()) {
                System.out.println(tel);
            }*/
     
            ConsultasProfesor con = new ConsultasProfesor();
            int i = 1;
            ArrayList<Profesor> profesores = con.obtenerListaProfesores();
            
            for(Profesor prof : profesores) {
                System.out.println(prof.getNombre() + " " + prof.getNumEmpleado() + " " + prof.getTelefono());
                
            }         
            

    }
     
    
}
