/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ttnhat.data.dao;

import java.util.List;
import ttnhat.data.model.Cart;


/**
 *
 * @author nhatt
 */
public interface CartDao {
    public List<Cart> dataOrder(int uID);
    public void insert(int uID,int idProducts);   
    public void delete(int uID,int idProducts);   
}
