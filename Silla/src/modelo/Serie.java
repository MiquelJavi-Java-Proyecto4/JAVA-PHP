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
public class Serie {
    private int serie_id;
    private int serie_nom;
    
    //constructor vacio
    public Serie() {
    }
    
    //todos los constructores
    public Serie(int serie_nom) {     
        this.serie_nom = serie_nom;
    }
    //setters

    public void setSerie_id(int serie_id) {
        this.serie_id = serie_id;
    }

    public void setSerie_nom(int serie_nom) {
        this.serie_nom = serie_nom;
    }
    
    //getters

    public int getSerie_id() {
        return serie_id;
    }

    public int getSerie_nom() {
        return serie_nom;
    }
     
    
    
    
    
    
}
