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

    //Metodo que cambia de nivel de estudios al alumno
    public void cambiarNivel(String nivel) {
        //Modifcar
    }
    
}
