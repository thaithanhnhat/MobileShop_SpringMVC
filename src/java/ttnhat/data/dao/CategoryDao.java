/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ttnhat.data.dao;
import java.util.List;
import ttnhat.data.model.Categories;
/**
 *
 * @author nhatt
 */
public interface CategoryDao {
    public List<Categories> findAll();
    public boolean insert(Categories categories);
    public boolean update(Categories categories);
    public boolean dalete(int id);
    public boolean find(int id);
}
