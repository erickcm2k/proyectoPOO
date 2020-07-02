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
public abstract class Persona {
    
    //Definicion de los atributos de Persona
    protected String nombre;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected Date fechaNacimiento;
    protected String domicilio;
    protected ArrayList<String> telefono;
    protected String claveAcceso;
    protected String nombreUsuario;
    
    //Constructor por parametros (Todos los atributos de Persona)
    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String domicilio, ArrayList<String> telefono, String claveAcceso, String nombreUsuario) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.claveAcceso = claveAcceso;
        this.nombreUsuario = nombreUsuario;
    }
    
    
}
