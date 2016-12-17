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
public class Producto {
    private int pro_id;
    private String prod_nom;
    private String prod_foto;
    
    //constructor vacio
    public Producto() {
    }
    
    //todos los constructores
    public Producto(int pro_id, String prod_nom) {
        this.pro_id = pro_id;
        this.prod_nom = prod_nom;
    }
    
    //setters
    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public void setProd_nom(String prod_nom) {
        this.prod_nom = prod_nom;
    }

    public void setProd_foto(String prod_foto) {
        this.prod_foto = prod_foto;
    }
    
    //getters
    public int getPro_id() {
        return pro_id;
    }

    public String getProd_nom() {
        return prod_nom;
    }

    public String getProd_foto() {
        return prod_foto;
    }
    
    
    
    
    
}



