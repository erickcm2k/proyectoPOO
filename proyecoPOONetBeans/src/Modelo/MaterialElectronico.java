/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Jahaziel
 */
class MaterialElectronico extends Material{
    //Atributos del Material Electronico
    private int paginaDescarga;
    private int claveTemporal;

    //Constructor por paramtros
    public MaterialElectronico(int paginaDescarga, int claveTemporal, int id, String titulo, String autor, int anio, String areaConocimiento, int numEjemplares) {
        super(id, titulo, autor, anio, areaConocimiento, numEjemplares);
        this.paginaDescarga = paginaDescarga;
        this.claveTemporal = claveTemporal;
    }
    
    /*
    ***********************Getters t Setters de Material Eñectronico **************
    */

    public int getPaginaDescarga() {
        return paginaDescarga;
    }

    public void setPaginaDescarga(int paginaDescarga) {
        this.paginaDescarga = paginaDescarga;
    }

    public int getClaveTemporal() {
        return claveTemporal;
    }

    public void setClaveTemporal(int claveTemporal) {
        this.claveTemporal = claveTemporal;
    }
    
}
