/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.User;

/**
 *
 * @author Javier
 */
public class ProductoController {

    public ProductoController() {
    }
    
    public int login(User usuario){
     int result = 0;
     Conexion conectar = new Conexion();
     Connection cn = conectar.conexion();
     PreparedStatement pst =null;
     ResultSet rs = null;
     
     String sql = "SELECT * FROM tbl_users WHERE usu_nombre = ? AND usu_password = ?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getApellido());
            rs = pst.executeQuery();
            if (!rs.next()){
               int b = 1; 
               return b;
            } else {
               int b=2;
               return b;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
            int b = 3;
            return b;
        }
    }
    
}
