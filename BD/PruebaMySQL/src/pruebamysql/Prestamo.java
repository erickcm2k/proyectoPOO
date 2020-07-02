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
public class Prestamo {
    private int id_prestamo;
    private int id_persona;
    private int id_material;
    private Date fecha_prestamo;
    private Date fecha_devolucion;
    private double multa;

    public Prestamo(int id_prestamo, int id_persona, int id_material, Date fecha_prestamo, Date fecha_devolucion, double multa) {
        this.id_prestamo = id_prestamo;
        this.id_persona = id_persona;
        this.id_material = id_material;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
        this.multa = multa;
    } 

    public int getId_prestamo() {
        return id_prestamo;
    }

    public int getId_persona() {
        return id_persona;
    }

    public int getId_material() {
        return id_material;
    }

    public Date getFecha_prestamo() {
        return fecha_prestamo;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public double getMulta() {
        return multa;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    public void setFecha_prestamo(Date fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }
    
    
}
