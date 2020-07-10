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
    private int numEmpleado;
    private ArrayList<String> materiasImparte;
    
    //Contructor por parametros

	public Profesor(int numEmpleado, ArrayList<String> materiasImparte, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String domicilio, ArrayList<String> telefono, String claveAcceso, String nombreUsuario) {
		super(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, domicilio, telefono, claveAcceso, nombreUsuario);
		this.numEmpleado = numEmpleado;
		this.materiasImparte = materiasImparte;
	}
    
    //Añade una materia al arraylist materiasIMparte el profesor
    public void addNateria(String materia){
        this.materiasImparte.add(materia);
    }
    
     /*
    ***************Getters y Setters****************
    */

    public ArrayList<String> getMateriasImparte() {
        return materiasImparte;
    }

    public void setMateriasImparte(ArrayList<String> materiasImparte) {
        this.materiasImparte = materiasImparte;
    }

	public int getNumEmpleado() {
		return numEmpleado;
	}

	public void setNumEmpleado(int numEmpleado) {
		this.numEmpleado = numEmpleado;
	}
	
    
}
