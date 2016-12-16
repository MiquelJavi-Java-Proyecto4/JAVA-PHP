/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Javier
 */
public class Categoria {
    private int categoria_id;
    private String categoria_nom;
    
    //constructor vacio
    public Categoria() {
    }
    
    //todos los constructores
    public Categoria(int categoria_id, String categoria_nom) {
        this.categoria_id = categoria_id;
        this.categoria_nom = categoria_nom;
    }
    
    //setters
    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public void setCategoria_nom(String categoria_nom) {
        this.categoria_nom = categoria_nom;
    }
    
    //getters

    public int getCategoria_id() {
        return categoria_id;
    }

    public String getCategoria_nom() {
        return categoria_nom;
    }
    
    
    
    
    
}
