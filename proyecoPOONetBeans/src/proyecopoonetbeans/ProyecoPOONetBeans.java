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
		ConsultasPersona perso = new ConsultasPersona();
		ArrayList<Persona> personas;
		personas = perso.obtenerListaPersonas();
		
		Persona aux;
		for(int i =0; i<personas.size();i++){
			aux= personas.get(i);
			System.out.println(aux.getNombreUsuario());
		}
		System.out.println("*********************************");
		for(int i =0; i<personas.size();i++){
			aux= personas.get(i);
			System.out.println(aux.getClaveAcceso());
		}

    }
     
    
}
