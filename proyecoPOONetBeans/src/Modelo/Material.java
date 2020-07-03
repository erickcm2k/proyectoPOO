/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;

/**
 *
 * @author Jahaziel
 */
public abstract class Material {
    //Atributos de Material
    protected int id;
    protected String titulo;
    protected String autor;
    protected int anio;
    protected String areaConocimiento;
    protected int numEjemplares;
    
    //Constructor de la clase Material

    public Material(int id, String titulo, String autor, int anio, String areaConocimiento, int numEjemplares) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.areaConocimiento = areaConocimiento;
        this.numEjemplares = numEjemplares;
    }
    
    
    //ver los materiales existetes
    public File ver(){
        //modificar
        return null;
        
    }
    
}
