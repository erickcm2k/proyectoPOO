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
        
       ConsultasMElectronico mel = new ConsultasMElectronico();
       
       ArrayList<MaterialElectronico> mes = mel.obtenerListaMaterialesElectronicos();
       for(MaterialElectronico materialE : mes) {
           System.out.println(materialE.getPaginaDescarga());
       }

    }
     
    
}
