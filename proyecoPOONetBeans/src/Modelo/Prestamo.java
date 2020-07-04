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
public class Prestamo {
    //Atributos del Prestamo
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private double multa;
    private ArrayList<Material> material;
    
    //Funcion que verifica si el prestamo tiene adeudo
    public boolean tieneAdeudo(){
        return fechaDevolucion.compareTo(fechaPrestamo)>=0;
    }
    
    //Ccalucla el costo total del adeudo;
    public double calcularAdeudo(){
        //Modificar
        return 0;
        
    }

    //asigna un arrayLIst a materiales
    public void añadirMaterial(ArrayList<Material> material) {
        this.material = material;
    }
    
    //añade material uno por uno al arraylist
    public void añadirMaterial(Material material) {
        this.material.add(material);
    }
    
    /*
    **************************Setters y Getters****************
    */

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public ArrayList<Material> getMaterial() {
        return material;
    }

    
    
    
}
