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
public class Material {
    private int id;
    private String tipo_material;
    private String titulo;
    private String autor;
    private String anio;
    private String area_conocimiento;
    private String numero_ejemplares;
    private String isbn;
    private String volumen;
    private String numero;
    private String pagina_descarga;
    private int clave_temporal;

    /* Constructor para un libro. */
    public Material(int id, String tipo_material, String titulo, String autor, String anio, String area_conocimiento, String numero_ejemplares, String isbn) {
        this.id = id;
        this.tipo_material = tipo_material;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.area_conocimiento = area_conocimiento;
        this.numero_ejemplares = numero_ejemplares;
        this.isbn = isbn;
    }

    /* Constructor para una revista. */
    public Material(int id, String tipo_material, String titulo, String autor, String anio, String area_conocimiento, String numero_ejemplares, String volumen, String numero) {
        this.id = id;
        this.tipo_material = tipo_material;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.area_conocimiento = area_conocimiento;
        this.numero_ejemplares = numero_ejemplares;
        this.volumen = volumen;
        this.numero = numero;
    }

    /* Constructor para un material electrónico. */

    public Material(int id, String tipo_material, String titulo, String autor, String anio, String area_conocimiento, String numero_ejemplares, String pagina_descarga, int clave_temporal) {
        this.id = id;
        this.tipo_material = tipo_material;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.area_conocimiento = area_conocimiento;
        this.numero_ejemplares = numero_ejemplares;
        this.pagina_descarga = pagina_descarga;
        this.clave_temporal = clave_temporal;
    }

    
    
}
