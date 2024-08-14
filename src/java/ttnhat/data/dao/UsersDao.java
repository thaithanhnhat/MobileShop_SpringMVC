/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ttnhat.data.dao;

import java.util.List;
import ttnhat.data.model.Categories;
import ttnhat.data.model.Users;

/**
 *
 * @author nhatt
 */
public interface UsersDao {

    public Users findUser(String emailphone,String password);
    public Users findUser(String emailphone);
    public void insertUser(String name,String email,String phone, String password);

}
