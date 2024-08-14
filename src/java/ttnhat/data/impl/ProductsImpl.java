/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttnhat.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ttnhat.data.dao.ProductsDao;
import ttnhat.data.driver.MySQLDriver;
import ttnhat.data.model.Products;

/**
 *
 * @author nhatt
 */
public class ProductsImpl implements ProductsDao {
    Connection conn = MySQLDriver.getConnection();
    public List<Products> findAll(){
        List<Products> listProducts = new ArrayList<>();
        String sql ="select * from shoping.products";
        try {      
            PreparedStatement sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while(rs.next()){
                 int id = rs.getInt("id");
                 int id_category = rs.getInt("id_category");
                 String image = rs.getString("image");
                 String name = rs.getString("name");
                 double price = rs.getDouble("price");
                 int quantity = rs.getInt("quantity");
                 int status = rs.getInt("status");                   
                listProducts.add(new Products(id, id_category, image, name, price, quantity, status));  
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProducts;
    }
    public boolean insert(Products products){
        String sql ="INSERT into shoping.products(id_category, image, name, price, quantily, status) VALUES (?, ?, ?, ?, ?, ?)";
        try {       
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setInt(1,products.getId_category());
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public boolean update(Products products){
        String sql = "UPDATE shoping.products set name = '?' WHERE id = ?";
        try {
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setString(1,products.getName());
            sttm.setInt(2,products.getId());
            sttm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public boolean dalete(int id){
        String sql =   "DELETE from shoping.products WHERE id = ? ";
        try {
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setInt(1,id);
            sttm.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public boolean find(int id){
        String sql = "select * from shoping.products where id =" + id;
        try {
            PreparedStatement sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if(rs.next() == false){
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true;
    }


}
