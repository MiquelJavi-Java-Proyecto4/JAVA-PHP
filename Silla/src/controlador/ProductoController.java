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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.Producto;
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
    
    public DefaultTableModel mostrarProducto() {
        DefaultTableModel muestra = null;

        //1. conectarme
        Conexion conectar = new Conexion();
        Connection cn = conectar.conexion();

        String sql = "Select * FROM tbl_lloc INNER JOIN tbl_estoc on tbl_lloc.lloc_id = tbl_estoc.lloc_id INNER JOIN tbl_producte ON tbl_producte.prod_id = tbl_estoc.prod_id INNER JOIN tbl_serie ON tbl_serie.serie_id = tbl_producte.serie_id INNER JOIN tbl_categoria ON tbl_categoria.categoria_id = tbl_serie.categoria_id ORDER BY tbl_producte.prod_id";
        Statement st = null;
        String vectorProducto[] = new String[10];
        String vectorProducto1[] = new String[10];
        vectorProducto1[0] = "IDProducto";
        vectorProducto1[1] = "Nombre";
        vectorProducto1[2] = "Nº serie";
        vectorProducto1[3] = "estoc_Actual";
        vectorProducto1[4] = "estoc_Min";
        vectorProducto1[5] = "estoc_Max";
        vectorProducto1[6] = "Bloque";
        vectorProducto1[7] = "Pasillo";
        vectorProducto1[8] = "Respisa";
        vectorProducto1[9] = "Categoria";
        
        muestra=new DefaultTableModel(null, vectorProducto1);
//String[] vectorProducto; De otra manera definir el vector

        try {

            st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {    
                vectorProducto[0] = rs.getString("tbl_producte.prod_id");
                vectorProducto[1] = rs.getString("tbl_producte.prod_nom");
                vectorProducto[2] = rs.getString("tbl_serie.serie_nom");
                vectorProducto[3] = String.valueOf(rs.getInt("tbl_estoc.estoc_q_actual"));
                vectorProducto[4] = String.valueOf(rs.getInt("tbl_estoc.estoc_q_min"));
                vectorProducto[5] = String.valueOf(rs.getInt("tbl_estoc.estoc_q_max"));
                vectorProducto[6] = rs.getString("tbl_lloc.num_bloc");
                vectorProducto[7] = rs.getString("tbl_lloc.num_passadis");
                vectorProducto[8] = rs.getString("tbl_lloc.num_lleixa");
                vectorProducto[9] = rs.getString("tbl_categoria.categoria_nom");
                muestra.addRow(vectorProducto);
               
            }
        } catch (Exception e) {
        }

        return muestra;
    }
}
