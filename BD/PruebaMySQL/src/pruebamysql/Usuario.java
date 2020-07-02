/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebamysql;
import java.sql.Date;

/**
 *
 * @author erick
 */
public class Usuario {
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private Date fecha_nacimiento;
    private String domicilio;
    private int clave;
    private String nombre_usuario;
    private String numero_empleado;
    private int boleta_alumno;
    private String nivel_alumno;

    /* Constructor para un Usuario común. */
    public Usuario(String nombre, String apellido_paterno, String apellido_materno, Date fecha_nacimiento, String domicilio, int clave, String nombre_usuario) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.domicilio = domicilio;
        
        this.clave = clave;
        this.nombre_usuario = nombre_usuario;
    }

    /* Constructor para un profesor.*/
    public Usuario(String nombre, String apellido_paterno, String apellido_materno, Date fecha_nacimiento, String domicilio, int clave, String nombre_usuario, String numero_empleado) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.domicilio = domicilio;
        
        this.clave = clave;
        this.nombre_usuario = nombre_usuario;
        
        this.numero_empleado = numero_empleado;
    }

    /* Constructo para un alumno. */
    public Usuario(String nombre, String apellido_paterno, String apellido_materno, Date fecha_nacimiento, String domicilio, int clave, String nombre_usuario, int boleta_alumno, String nivel_alumno) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.domicilio = domicilio;
        
        this.clave = clave;
        this.nombre_usuario = nombre_usuario;
        
        this.boleta_alumno = boleta_alumno;
        this.nivel_alumno = nivel_alumno;
    }
    
    
    
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public int getClave() {
        return clave;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public String getNumero_empleado() {
        return numero_empleado;
    }

    public int getBoleta_alumno() {
        return boleta_alumno;
    }

    public String getNivel_alumno() {
        return nivel_alumno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public void setNumero_empleado(String numero_empleado) {
        this.numero_empleado = numero_empleado;
    }

    public void setBoleta_alumno(int boleta_alumno) {
        this.boleta_alumno = boleta_alumno;
    }

    public void setNivel_alumno(String nivel_alumno) {
        this.nivel_alumno = nivel_alumno;
    }
    
    
}
