/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebamysql;

/**
 *
 * @author erick
 */
public class Materia {
    private int id_materia;
    private String nombre;

    public Materia(int id_materia, String nombre) {
        this.id_materia = id_materia;
        this.nombre = nombre;
    }

    public int getId_materia() {
        return id_materia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
}
