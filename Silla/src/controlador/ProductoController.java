/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import modelo.Conexion;
import modelo.Lugar;
import modelo.Producto;
import modelo.Serie;
import modelo.Stock;
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

    //Visualizaremos todo lo que parece en nuestra VistaProducto
    public void añadirProducto(Categoria c, Serie s, Producto p, Stock so, Lugar l){
        //Hacemos la conexion
        Conexion conectar=new Conexion();
        Connection cn = conectar.conexion();
        //Introduciremos las sentencias SQL con su respectivo orden
        String sql= "INSERT INTO tbl_categoria (categoria_nom) VALUES (?)";
        String sql1= "select distinct last_insert_id() from  tbl_categoria";
        String sql2= "INSERT INTO tbl_serie(serie_nom) VALUES (?)";
        String sql3= "select distinct last_insert_id() from tbl_serie";
        String sql4= "INSERT INTO tbl_producte (prod_nom, prod_foto) VALUES (?,?)";
        String sql5= "select disntinct last_insert_id() from tbl_producte";
        String sql6= "INSERT INTO tbl_estoc(estoc_q_actual, estoc_min, estoc_max)VALUES(?,?,?)";
        String sql7= "select distinct last_insert_id() from tbl_estoc";
        String sql8= "INSERT INTO tbl_lloc(num_bloc, num_passadis, num_lleixa)VALUES(?,?,?)";
        //ahora recogemos los datos 
        PreparedStatement pst1 = null;
        Statement st1=null;
        PreparedStatement pst2 = null;
        Statement st2=null;
        PreparedStatement pst3 = null;
        Statement st3=null;
        PreparedStatement pst4 = null;
        Statement st4=null;
        PreparedStatement pst5 = null;
        Statement st5=null;
        PreparedStatement pst6 = null;
        Statement st6=null;
        PreparedStatement pst7 = null;
        Statement st7=null;
        PreparedStatement pst8 = null;
        ResultSet rs8=null;
        try {
            //Aqui hacemos que automaticamente deshabilite la conexion.
            cn.setAutoCommit(false);
            //
            pst1 = cn.prepareStatement(sql);
            pst1.setString(1, c.getCategoria_nom());
            JOptionPane.showMessageDialog(null, "categoria correcta");
            //recuperamos el ultimo registro
            st2=cn.createStatement();
            rs8 = st2.executeQuery(sql2);
            //
            int idst1=0;
            while(rs8.next()){
            idst1=rs8.getInt(1);
            }
            JOptionPane.showMessageDialog(null, idst1);
            //
            pst2 = cn.prepareStatement(sql3);
            pst2.setString(1,s.getSerie_nom());
            pst2.setInt(2,idst1);
            //
            //while(){
                
            //}
            //
            pst3 = cn.prepareStatement(sql4);
            
        
            
            
            
        } catch (SQLException | HeadlessException e) {
            try {
                cn.rollback();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se puede deshacer");
            }
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
        vectorProducto1[0] = "ID";
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
    

