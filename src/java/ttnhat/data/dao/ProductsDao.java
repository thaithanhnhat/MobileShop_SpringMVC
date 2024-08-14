/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ttnhat.data.dao;

import java.util.List;
import ttnhat.data.model.Products;

/**
 *
 * @author nhatt
 */
public interface ProductsDao {
    public List<Products> findAll();
    public boolean insert(Products product);
    public boolean update(Products product);
    public boolean dalete(int id);
    public boolean find(int id);
}
