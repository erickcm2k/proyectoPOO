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

        ConexionBD conexion = new ConexionBD();
        conexion.conectar();
        ConsultasTelefono consulta = new ConsultasTelefono();
        
        ArrayList<Telefono> telefonos = consulta.obtenerListaTelefonos();
        for(Telefono tel : telefonos) {
            System.out.println(tel.getId_usuario() + " " + tel.getTelefono());
        }
    }
     
    
}
