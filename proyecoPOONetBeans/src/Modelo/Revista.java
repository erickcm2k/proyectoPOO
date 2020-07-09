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
public class Revista extends Material{
    //Atributos de Revista
    private int volumen;
    private int numero;
    
    //Constructor por parametros

    public Revista(int volumen, int numero, int id, String titulo, String autor, int anio, String areaConocimiento, int numEjemplares) {
        super(id, titulo, autor, anio, areaConocimiento, numEjemplares);
        this.volumen = volumen;
        this.numero = numero;
    }
    
    /*
    ***************** Setters y Getters****************************
    */

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getVolumen() {
        return volumen;
    }
    
    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }
    
}
