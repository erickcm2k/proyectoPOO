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
public class Empleado extends Persona{
    
    //Definicion de los atributos de Empleado
    private int horaEntrada;
    private int horaSalida;
    
    //Constructor por paremetros
    public Empleado(int horaEntrada, int horaSalida, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String domicilio, ArrayList<String> telefono, String claveAcceso, String nombreUsuario) {
        super(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, domicilio, telefono, claveAcceso, nombreUsuario);
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }
    
    //Metodo que Genera las Claves de los Materiales Electronicos
    public String generarClave(MaterialElectronico materialE){
        //Modifciar
        return null;
    }
    
    //Metodo que creea y registra a un nuevo tipo de usuario
    public void registraUsuario(){
        //Modificar
    }
    
    //Meto que genera Alertas de los Usuarios
    public int generaAlertas(){
        //Modificar
        return 0;
        
    }
    /*
    *************************************Getters y Setters*******************************************************************
    */

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }
    
	
}
