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
public class Proveedor {
    private int prov_id;
    private String prov_nom;
    private String prov_adre;
    private String prov_email;
    
    //constructor basio
    public Proveedor() {
    }
    
    //todos los constructor
    public Proveedor(int prov_id, String prov_nom, String prov_adre, String prov_email) {
        this.prov_id = prov_id;
        this.prov_nom = prov_nom;
        this.prov_adre = prov_adre;
        this.prov_email = prov_email;
    }
    
    //setters
    public void setProv_id(int prov_id) {
        this.prov_id = prov_id;
    }

    public void setProv_nom(String prov_nom) {
        this.prov_nom = prov_nom;
    }

    public void setProv_adre(String prov_adre) {
        this.prov_adre = prov_adre;
    }

    public void setProv_email(String prov_email) {
        this.prov_email = prov_email;
    }
    
    //getters
    public int getProv_id() {
        return prov_id;
    }

    public String getProv_nom() {
        return prov_nom;
    }

    public String getProv_adre() {
        return prov_adre;
    }

    public String getProv_email() {
        return prov_email;
    }
    
    
    
    
            
    
    
}
