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
public class Telefono {
    private int id_usuario;
    private int telefono;

    public Telefono(int id_usuario, int telefono) {
        this.id_usuario = id_usuario;
        this.telefono = telefono;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
}
