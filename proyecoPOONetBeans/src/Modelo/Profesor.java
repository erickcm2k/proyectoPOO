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
public class Profesor extends Usuario{
    
    //Atributos de Profesor
    private String numEmpleado;
    private ArrayList<String> materiasImparte;
    
    //Contructor por parametros

    public Profesor(String numEmpleado, ArrayList<String> materiasImparte, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String domicilio, ArrayList<String> telefono, String claveAcceso, String nombreUsuario) {
        super(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, domicilio, telefono, claveAcceso, nombreUsuario);
        this.numEmpleado = numEmpleado;
        this.materiasImparte = materiasImparte;
    }
    
    //Genero que añade una materia que imparte el profesor al arrgelo
    public void addNateria(String materia){
        //Modificar
    }
    
    
}
