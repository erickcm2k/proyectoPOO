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
    private Usuario usuario;
    
    /*
    *************************************Constructor********************************************
    */
	public Prestamo(Date fechaPrestamo, Date fechaDevolucion, double multa, ArrayList<Material> material, Usuario usuario){
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.multa = multa;
        this.material = material;
        this.usuario = usuario;
    }

    //Funcion que verifica si el prestamo tiene adeudo
    public boolean tieneAdeudo() {
        Date fecha;
		fecha = new Date(0);
		fecha.getDate();
        return fechaDevolucion.compareTo(fecha)>=0;
    }
    
    //Ccalucla el costo total del adeudo;
    public double calcularAdeudo(){
        //Modificar
        Date fecha=null;
        if(tieneAdeudo()){
            return fechaDevolucion.compareTo(fecha)*2.5;
        }
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }    
}
