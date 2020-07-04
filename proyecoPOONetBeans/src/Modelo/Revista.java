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
    private String volumen;
    private String numero;
    
    //Constructor por parametros

    public Revista(String volumen, String numero, int id, String titulo, String autor, int anio, String areaConocimiento, int numEjemplares) {
        super(id, titulo, autor, anio, areaConocimiento, numEjemplares);
        this.volumen = volumen;
        this.numero = numero;
    }
    
    /*
    ***************** Setters y Getters****************************
    */

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getVolumen() {
        return volumen;
    }
    
    
}
