/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Javier
 */
public class Conexion {
    //datos de la conexion
    public String db="bd_estoc";
    //el puerto 3306 no es necesario porque es el puerto por defecto.
    public String url = "jdbc:mysql://localhost:3306/"+db;
    public String user= "root";
    public String pass="";
    //1. Establecer la conexion:
    //funcion que conecta con la base de datos y java.
    public Connection conexion(){
        Connection conexion=null;
        //indicar la ruta donde esta mi driver.
        try{
            //Para decir la ruta del Diver.class
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion=DriverManager.getConnection(url, user, pass);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Conexion erronea");   
            System.out.println(e);
        }finally{
            return conexion;
        }
    }
    //constructor 

    public Conexion() {
    }
    
    
}
