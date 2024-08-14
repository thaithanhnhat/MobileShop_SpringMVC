/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttnhat.data.impl;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.awt.image.RescaleOp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ttnhat.data.dao.CategoryDao;
import ttnhat.data.driver.MySQLDriver;
import ttnhat.data.model.Categories;

/**
 *
 * @author nhatt
 */
public class CategoryImpl implements CategoryDao {
    Connection conn = MySQLDriver.getConnection();
    public List<Categories> findAll(){
        List<Categories> listCategory = new ArrayList<>();
        String sql ="select * from shoping.categories";
        try {
       
            PreparedStatement sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                listCategory.add(new Categories(id, name));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCategory;
    }
    public boolean insert(Categories categories){
        String sql ="INSERT into shoping.categories(name) VALUES ('?')";
        try {       
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setString(1,categories.getName());
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
    public boolean update(Categories categories){
        String sql = "UPDATE shoping.categories set name = '?' WHERE id = ?";
        try {
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setString(1,categories.getName());
            sttm.setInt(2,categories.getId());
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
        String sql =   "DELETE from shoping.categories WHERE id = ? ";
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
        String sql = "select * from shoping.categories where id =" + id;
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
