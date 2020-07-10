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
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String domicilio;
    private ArrayList<String> telefono;
    private String claveAcceso;
    private String nombreUsuario;
    
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

     /*
    ***************Getters y Setters****************
    */
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public ArrayList<String> getTelefono() {
        return telefono;
    }

    public void setTelefono(ArrayList<String> telefono) {
        this.telefono = telefono;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }
	
	//Borrar

	public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String domicilio, String claveAcceso, String nombreUsuario) {
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.fechaNacimiento = fechaNacimiento;
		this.domicilio = domicilio;
		this.claveAcceso = claveAcceso;
		this.nombreUsuario = nombreUsuario;
	}
	
    
}
