/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jahaziel
 */
public class Prestamo {
    //Atributos del Prestamo
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private double multa;
    private ArrayList<Material> materia;
    
    //Funcion que verifica si el prestamo tiene adeudo
    public boolean tieneAdeudo(){
        //Modificar
        return false;
    }
    
    //Ccalucla el costo total del adeudo;
    public double calcularAdeudo(){
        //Modificar
        return 0;
        
    }
    
}
