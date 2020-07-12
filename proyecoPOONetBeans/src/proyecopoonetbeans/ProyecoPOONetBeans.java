/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecopoonetbeans;

import Control.*;
import Modelo.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author Jahaziel
 */
public class ProyecoPOONetBeans {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {                    
       
       
            // Prueba de inserción de un alumno junto con sus teléfonos
           /* Telefono tel1 = new Telefono(1, "123456");
            Telefono tel2 = new Telefono(1, "654321");
            Date fecha = Date.valueOf("2000-07-10");
            ArrayList<Telefono> tels = new ArrayList(Arrays.asList(tel1, tel2));
            ArrayList<String> telefonos = new ArrayList();
            ArrayList<String> materiasImpartidas = new ArrayList();
            for(Telefono tel : tels) {
                telefonos.add(tel.getTelefono());
            }
            Profesor prof = new Profesor(123456, materiasImpartidas, "erickkk", "castañeda", "martinez", fecha, "calle 1", telefonos, "mipassword", "erickce40");
                
            
            ConsultasProfesor con = new ConsultasProfesor();
            ConsultasProfesor con2 = new ConsultasProfesor();
            con.registrarProfesor(prof);            
            int id = con2.obtenerIdPorNumeroEmpleado(123456);
            for(String tel : telefonos) {
                ConsultasTelefono conTel = new ConsultasTelefono();
                Telefono telefonoRegistrar = new Telefono(id, tel);
                conTel.registrarTelefono(telefonoRegistrar);
            }
            System.out.println(id);*/
            
            // pruebas para borrar alumnos junto con sus teléfonos
           /* 
            ConsultasProfesor con1 = new ConsultasProfesor();
            ConsultasProfesor con2 = new ConsultasProfesor();
            ConsultasTelefono conTel = new ConsultasTelefono();
            int id = con1.obtenerIdPorNumeroEmpleado(123456);
            conTel.borrarTelefonoPorId(id);
            con2.borrarProfesorPorNumeroEmpleado(123456);
            */
            //(int boleta, String nivel, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String domicilio, ArrayList<String> telefono, String claveAcceso, String nombreUsuario)
            /*
            Pruebas para modificar alumnos
            
            Telefono tel1 = new Telefono(1, "123456");
            Telefono tel2 = new Telefono(1, "654321");
            Date fecha = Date.valueOf("2000-07-10");
            ArrayList<Telefono> tels = new ArrayList(Arrays.asList(tel1, tel2));
            ArrayList<String> telefonos = new ArrayList();
            for(Telefono tel : tels) {
                telefonos.add(tel.getTelefono());
            }            
            Date nacimiento = Date.valueOf("2003-01-31");
            Alumno alumno = new Alumno(2010249017, "Secundaria", "Robina", "Tevlin", "Abell", nacimiento, "0 Park Meadow Crossing", telefonos, "BSTQJ9C4H", "8ASMtPSMrLt0");
            Alumno alumnoNuevo = new Alumno(2010249017, "Primaria", "Robina", "Tevlin", "Abell", nacimiento, "0 Park Meadow Crossing", telefonos, "BSTQJ9C4H", "8ASMtPSMrLt0");
            ConsultasAlumno con = new ConsultasAlumno();
            con.modificarAlumno(alumno, alumnoNuevo);*/
    }
     
    
}
