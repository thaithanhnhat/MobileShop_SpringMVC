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
import ttnhat.data.dao.UsersDao;
import ttnhat.data.driver.MySQLDriver;
import ttnhat.data.model.Users;

/**
 *
 * @author nhatt
 */
public class UsersImpl implements UsersDao {
    Connection conn = MySQLDriver.getConnection();
        
    @Override
     public Users findUser(String emailphone,String password){
            String sql;
            if(emailphone.contains("@")){
                sql = "select * from users where email='"+emailphone+"' and password='"+password+"'";
            }
            else{
                sql = "select * from users where phone='"+emailphone+"' and password='"+password+"'";
            }           
        try {
            PreparedStatement sttm;
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if(rs.next()) return new Users(rs);
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return null;
    }
     public Users findUser(String emailphone){
          String sql;
            if(emailphone.contains("@")){
                sql = "select * from users where email='"+emailphone+"'";
            }
            else{
                sql = "select * from users where phone='"+emailphone+"'";
            }           
        try {
            PreparedStatement sttm;
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if(rs.next()) return new Users(rs);
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
         
    }
    public void insertUser(String name,String email,String phone, String password){
    
    }
     
      
    
}
