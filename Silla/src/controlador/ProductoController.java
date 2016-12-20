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
    public void añadirProducto(Serie s, Producto p, Stock so, Lugar l) throws SQLException{
        //Hacemos la conexion
        Conexion conectar=new Conexion();
        Connection cn = conectar.conexion();
        //Introduciremos las sentencias SQL con su respectivo orden
        
        String sql = "";
        String sql1= "INSERT INTO tbl_serie(serie_nom) VALUES (?)";
        String sql2= "select distinct last_insert_id() from tbl_serie";
        String sql3= "INSERT INTO tbl_producte (prod_nom, prod_foto) VALUES (?,?)";
        String sql4= "select disntinct last_insert_id() from tbl_producte";
        String sql5= "INSERT INTO tbl_lloc(num_bloc, num_passadis, num_lleixa)VALUES(?,?,?)";
        String sql6= "select distinct last_insert_id() from tbl_lloc";
        String sql7= "INSERT INTO tbl_estoc(estoc_q_max, estoc_q_actual, estoc_q_min)VALUES(?,?,?)";
        //ahora recogemos los datos 
        PreparedStatement pst1 = null;
        Statement st=null;
        PreparedStatement pst2 = null;
        ResultSet rs=null;
        
        try {
            //
            cn.setAutoCommit(false);
            //
            pst1 = cn.prepareStatement(sql1);
            pst1.setString(1, s.getSerie_nom());
            pst1.executeUpdate();
            //
            st=cn.createStatement();
            rs=st.executeQuery(sql2);
            //
            int idst1=0;
            while(rs.next()){
                idst1=rs.getInt(1);  
            }
            JOptionPane.showMessageDialog(null,idst1);
            //
            pst2 = cn.prepareStatement(sql3);
            pst2.setString(1, p.getProd_nom());
            pst2.setString(2, p.getProd_foto());
            pst2.setInt(3,idst1);
            //
            st=cn.createStatement();
            rs=st.executeQuery(sql4);
            //
            int idst2=0;
            if(rs.next()){
                idst2=rs.getInt(1);
            }
            JOptionPane.showMessageDialog(null, idst2);
            //
            pst2=cn.prepareStatement(sql5);
            pst2.setString(1, l.getNum_lloc());
            pst2.setString(2, l.getNum_passadis());
            pst2.setString(3, l.getNum_lleixa());
            //
            st=cn.createStatement();
            rs=st.executeQuery(sql6);
            //
            int idst3=0;
            if(rs.next()){
                idst3=rs.getInt(1); 
            }
            JOptionPane.showMessageDialog(null, idst3);
            //
            pst2=cn.prepareStatement(sql7);
            pst2.setString(1, so.getEstoc_q_max());
            pst2.setString(2, so.getEstoc_q_actual());
            pst2.setString(3, so.getEstoc_q_min());
            pst2.setInt(4,idst2);
            pst2.setInt(5,idst3);
            
      
       
            
            
            
            cn.commit();
           
        } catch (SQLException | HeadlessException e) {
            try {
                cn.rollback();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se puede deshacer");
            }
        }finally{
            cn.setAutoCommit(true);
            cn.close();
            pst1.close();
            pst2.close();
            st.close();
            rs.close();
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
    
    public DefaultTableModel updateTable() {
        
        DefaultTableModel muestra;
        //1. conectarme
        Conexion conectar = new Conexion();
        Connection cn = conectar.conexion();

        String sql = "Select * FROM tbl_lloc INNER JOIN tbl_estoc on tbl_lloc.lloc_id = tbl_estoc.lloc_id INNER JOIN tbl_producte ON tbl_producte.prod_id = tbl_estoc.prod_id INNER JOIN tbl_serie ON tbl_serie.serie_id = tbl_producte.serie_id INNER JOIN tbl_categoria ON tbl_categoria.categoria_id = tbl_serie.categoria_id ORDER BY tbl_producte.prod_id";
        Statement st = null;
        String vectorProducto[] = new String[10];
  
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
    
   public boolean validarSerie(String serie){
       Conexion conectar = new Conexion();
       Connection cn = conectar.conexion();
       
       String sql = "SELECT * FROM tbl_serie WHERE serie_nom=?";
       PreparedStatement pst = null;
     
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, serie);
            ResultSet rs = pst.executeQuery(sql);
            if (!rs.next()){
            return true;
            }      
        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
   }
   
   public boolean validarUbicacion(String bloq, String pas, String rep){
       Conexion conectar = new Conexion();
       Connection cn = conectar.conexion();
       
       PreparedStatement pst = null;
       
       String sql = "SELECT * FROM tbl_lloc WHERE num_bloc=? AND num_passadis=? AND num_lleixa=?";
       
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, bloq);
            pst.setString(2, pas);
            pst.setString(3, rep);
            ResultSet rs = pst.executeQuery();
            
            if(!rs.next()){
                return true;
            }
                   
        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return false;
   }
   
   public void modificarProducto(String nSerie, String nom, int act, int min, int max, String cat, String  bloq, String  pas, String  rep, int id){
       Conexion conectar = new Conexion();
       Connection cn = conectar.conexion();
       
       Statement st = null;
       PreparedStatement pst = null;
       PreparedStatement pst1 = null;
       PreparedStatement pst2 = null;
       PreparedStatement pst3 = null;
       PreparedStatement pst4 = null;
       
       String sql = "SELECT * FROM tbl_categoria WHERE categoria_nom=?";
       String sql1 = "UPDATE tbl_serie SET serie_nom=?, categoria_id=? WHERE serie_id=?";
       String sql2 = "UPDATE tbl_producte SET prod_nom=?, WHERE prod_id=?";
       String sql3 = "UPDATE tbl_lloc SET num_bloc=?, num_passadis=?, num_lleixa=? WHERE lloc_id=?";
       String sql4 = "UPDATE tbl_lloc SET estoc_q_max=?, estoc_q_actual=?, estoc_q_min=? WHERE estoc_id=?";
       
        try {
            cn.setAutoCommit(false);
            
           pst = cn.prepareStatement(sql);
           pst.setString(1, cat);
           ResultSet rs = pst.executeQuery();
           int idCat=0;
           while(rs.next()){
           idCat=rs.getInt("categoria_id");
           }
           
           pst1 = cn.prepareStatement(sql1);
           pst1.setString(1, nSerie);
           pst1.setInt(2, idCat);
           pst1.setInt(3, id);
           pst1.executeUpdate();
           
           pst2 = cn.prepareStatement(sql2);
           pst2.setString(1, nom);
           pst2.setInt(2, id);
           pst2.executeUpdate();
           
           pst3 = cn.prepareStatement(sql3);
           pst3.setString(1, bloq);
           pst3.setString(2, pas);
           pst3.setString(3, rep);
           pst3.setInt(4, id);
           pst3.executeUpdate();
           
           pst4 = cn.prepareStatement(sql4);
           pst4.setInt(1, max);
           pst4.setInt(2, min);
           pst4.setInt(3, act);
           pst4.setInt(4, id);
           pst4.executeUpdate();
           
           cn.setAutoCommit(true);
        
        JOptionPane.showMessageDialog(null, "Producto modificado correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en la modificacion");       
        } 
    }
   
    public void eliminar (int id){
        Conexion conectar = new Conexion();
        Connection cn = conectar.conexion();
        
        PreparedStatement pst = null;
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;
        PreparedStatement pst3 = null;
        
        String sql = "DELETE FROM tbl_lloc WHERE lloc_id = ?";
        String sql1 = "DELETE FROM tbl_estoc WHERE estoc_id = ?";
        String sql2 = "DELETE FROM tbl_producte WHERE prod_id = ?";
        String sql3 = "DELETE FROM tbl_serie WHERE serie_id = ?";
        
        try {
            
            cn.setAutoCommit(false);
            
            pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            
            pst1 = cn.prepareStatement(sql1);
            pst1.setInt(1, id);
            pst1.executeUpdate();
            
            pst2 = cn.prepareStatement(sql2);
            pst2.setInt(1, id);
            pst2.executeUpdate();
            
            pst3 = cn.prepareStatement(sql3);
            pst3.setInt(1, id);
            pst3.executeUpdate();
            
            cn.setAutoCommit(true);
            
            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto");
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    

