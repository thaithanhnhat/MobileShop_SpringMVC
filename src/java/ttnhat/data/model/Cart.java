/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttnhat.data.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nhatt
 */
public class Cart {
    private int idProducts;
    private int quantity;
    private String daddress;
    public Cart(ResultSet rs) throws SQLException {
           this.idProducts = rs.getInt("idProducts");
           this.quantity = rs.getInt("quantity");
           this.daddress = rs.getString("daddress");
    }
  

    public int getIdProducts() {
        return idProducts;
    }

    public void setIdProducts(int idProducts) {
        this.idProducts = idProducts;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDaddress() {
        return daddress;
    }

    public void setDaddress(String daddress) {
        this.daddress = daddress;
    }

    public Cart(int uID, int idCategory, int quantity, String daddress) {
        this.idProducts = idProducts;
        this.quantity = quantity;
        this.daddress = daddress;
    }
    
    
}
