/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.net.URL;

/**
 *
 * @author Jahaziel
 */
class MaterialElectronico extends Material{
    //Atributos del Material Electronico
    private URL paginaDescarga;
    private String claveTemporal;

    //Constructor por paramtros
    public MaterialElectronico(URL paginaDescarga, String claveTemporal, int id, String titulo, String autor, int anio, String areaConocimiento, int numEjemplares) {
        super(id, titulo, autor, anio, areaConocimiento, numEjemplares);
        this.paginaDescarga = paginaDescarga;
        this.claveTemporal = claveTemporal;
    }
    
    
}
