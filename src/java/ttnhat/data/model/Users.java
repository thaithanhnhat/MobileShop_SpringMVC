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
public class Users {
    private String email;
    private int id;
    private String name;
    private String password;
    private String phone;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public Users() {
        this.email=null;
    }
    public Users(String email, int id, String name, String password, String phone) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    public Users(ResultSet rs) throws SQLException {
            this.id =rs.getInt("id");
            this.name = rs.getString("name");
            this.email = rs.getString("email");
            this.phone =rs.getString("phone");
            this.password = rs.getString("password");
            this.role = rs.getString("role");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
