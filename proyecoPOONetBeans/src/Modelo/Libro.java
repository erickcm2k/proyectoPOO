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
public class Libro extends Material{
    //Atributos de Libro
    private String isbn;

    public Libro(int id, String titulo, String autor, int anio, String areaConocimiento, int numEjemplares, String isbn) {
        super(id, titulo, autor, anio, areaConocimiento, numEjemplares);
        this.isbn=isbn;
    }   
    
    
    
}
