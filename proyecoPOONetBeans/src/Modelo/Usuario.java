/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Jahaziel
 */
public abstract class Usuario extends Persona{
    
    //Atributos de Usuario
    protected String clave;
    protected String nombreUsuario;
    
    //Metodo que solicita un Material para prestamo
    public boolean solicitaPrestamo(){
        
        //Modificar
        return false;
        
    }
}
