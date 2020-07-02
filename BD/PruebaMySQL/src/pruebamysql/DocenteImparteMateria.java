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
public class DocenteImparteMateria {
    private int id_docente;
    private int id_materia;

    public DocenteImparteMateria(int id_docente, int id_materia) {
        this.id_docente = id_docente;
        this.id_materia = id_materia;
    }

    public int getId_docente() {
        return id_docente;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_docente(int id_docente) {
        this.id_docente = id_docente;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }
    
    
}
