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
import ttnhat.data.dao.CartDao;
import ttnhat.data.driver.MySQLDriver;
import ttnhat.data.model.Cart;

/**
 *
 * @author nhatt
 */
public class CartImpl implements CartDao{
    Connection conn = MySQLDriver.getConnection();
    public List<Cart> dataOrder(int uID){
        List<Cart> listCart = new ArrayList<>();
        String sql ="select * from shoping.cart where uID ="+uID;
        try { 
            PreparedStatement sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while(rs.next()){   
                listCart.add(new Cart(rs));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCart;
    }
    public void insert(int uID,int idProducts){
        String sql ="select * from shoping.cart where uID ="+uID+" and idProducts="+idProducts;       
        try {
            PreparedStatement sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            String sql1="";
            if(rs.next()){
                  sql1= "update shoping.cart set quantity = quantity +1 where uID ="+uID+" and idProducts="+idProducts;
            }
            else{
                 sql1 ="INSERT into shoping.cart(uID,idProducts,quantity) VALUES ("+uID+","+idProducts+",1)";    
            }
            PreparedStatement sttm1 = conn.prepareStatement(sql1);
            sttm1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartImpl.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    public void delete(int uID,int idProducts){
        String sql = "delete from shoping.cart where uID =" +uID +" and idProducts ="+idProducts;
         try {
            PreparedStatement sttm = conn.prepareStatement(sql);        
            sttm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
 