/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttnhat.utils;

import java.util.List;
import ttnhat.data.model.Cart;

/**
 *
 * @author nhatt
 */
public class API {
    public static String getName(String fullname){
        String s ="";
        for(int i = fullname.length()-1;i>=0;i--){
            if(fullname.charAt(i)==' ')break;
            s =fullname.charAt(i)+s;
        }
        return s;
    }
   
}
