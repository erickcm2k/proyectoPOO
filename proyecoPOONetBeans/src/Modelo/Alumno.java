/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Jahaziel
 */
public class Alumno extends Usuario{
    //Atributos del alumno
    private String boleta;
    private String nivel;
    
    //Constructor por parametros
    public Alumno(String boleta, String nivel, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String domicilio, ArrayList<String> telefono, String claveAcceso, String nombreUsuario){    
        super(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, domicilio, telefono, claveAcceso, nombreUsuario);
        this.boleta = boleta;
        this.nivel = nivel;
    }

    //Metodo que cambia de nivel de estudios al alumno de acuerdo al String recibido
    public void cambiarNivel(String nivel) {
       switch(nivel){
           case "Primaria":
                setNivel("Primaria");
                break;
           case "Secundaria":
               setNivel("Secundaria");
               break;
           case "Preparatoria":
               setNivel("Preparatoria");
               break;
       }
    }
    
    //Sobrescribimiento para el prestamo que puede pedir el alumno
    @Override
    public boolean solicitaPrestamo(){
        
        //Modificar
        return false;
        
    }
    
    //Setter del Nivel:
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    
}
