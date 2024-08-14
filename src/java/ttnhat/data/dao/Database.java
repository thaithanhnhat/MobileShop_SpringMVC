/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttnhat.data.dao;

import ttnhat.data.impl.CartImpl;
import ttnhat.data.impl.CategoryImpl;
import ttnhat.data.impl.ProductsImpl;
import ttnhat.data.impl.UsersImpl;

/**
 *
 * @author nhatt
 */
public class Database {
    public static CategoryDao getCategoryDao(){
        return new CategoryImpl();
    }
    
    public static ProductsDao getProductsDao(){
        return new ProductsImpl();
    }
    
    public static UsersDao getUsersDao(){
        return new UsersImpl();
    }
    
     public static CartDao getCartDao(){
        return new CartImpl();
    }
    
    
}
