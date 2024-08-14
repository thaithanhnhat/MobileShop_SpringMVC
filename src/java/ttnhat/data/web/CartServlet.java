/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ttnhat.data.web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import ttnhat.data.dao.Database;
import ttnhat.data.model.Cart;
import ttnhat.data.model.Products;
import ttnhat.data.model.Users;

/**
 *
 * @author nhatt
 */
public class CartServlet extends HttpServlet {

 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("title", "CART PAGE");
       
        List<Products> listProducts = Database.getProductsDao().findAll();
        request.setAttribute("listProducts",listProducts);
        
        Users user = (Users) request.getSession().getAttribute("user");
        if(user!=null){           
            List<Cart> listCarts = Database.getCartDao().dataOrder(user.getId());
            request.setAttribute("listCarts",listCarts);
        }              
        request.getRequestDispatcher( "./views/Cart.jsp").include(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.removeAttribute("listProducts");
            request.removeAttribute("listCarts");
            Users user = (Users) request.getSession().getAttribute("user");                     
            Database.getCartDao().delete(user.getId(),Integer.parseInt(request.getParameter("delete")));
            List<Products> listProducts = Database.getProductsDao().findAll();
            request.setAttribute("listProducts",listProducts);
            List<Cart> listCarts = Database.getCartDao().dataOrder(user.getId());
            request.setAttribute("listCarts",listCarts);
            request.getRequestDispatcher( "./views/Cart.jsp").include(request,response);
    }

   
    

}
