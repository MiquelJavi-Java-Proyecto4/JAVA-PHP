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
public class Lugar {
    private int lloc_id;
    private String num_bloc;
    private String num_passadis;
    private String num_lleixa;
    
    //constructor vacio
    public Lugar() {
    }
    
    //todos los constructores

    public Lugar(String num_bloc, String num_passadis, String num_lleixa) {
        this.num_bloc = num_bloc;
        this.num_passadis = num_passadis;
        this.num_lleixa = num_lleixa;
    }
    public void setLloc_id(int lloc_id) {
        this.lloc_id = lloc_id;
    }

    public void setNum_bloc(String num_bloc) {
        this.num_bloc = num_bloc;
    }

    public void setNum_passadis(String num_passadis) {
        this.num_passadis = num_passadis;
    }

    //setters
    public void setNum_lleixa(String num_lleixa) {
        this.num_lleixa = num_lleixa;
    }

    //getters

    public int getLloc_id() {
        return lloc_id;
    }

    public String getNum_bloc() {
        return num_bloc;
    }

    public String getNum_passadis() {
        return num_passadis;
    }

    public String getNum_lleixa() {
        return num_lleixa;
    }
     
    
}
