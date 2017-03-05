/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop.cart;

import com.jetsmad.xshop.util.beans.CartItem;
import com.jetsmad.xshop.util.beans.Product;
import com.jetsmad.xshop.util.beans.Constants;
import com.jetsmad.xshop.util.database.DBController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author michael
 */
@WebServlet(name = "RemoveFromCart", urlPatterns = {"/removefromcart"})
public class RemoveFromCart extends HttpServlet {
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
//        Servlet called with AJAX that does the following:
//        1. gets the product ID from the request
//        2. remove the product from the session
//        3. update the product stock in the database(+1)
//        4. reply with nothing (none needed)
        String productId = request.getAttribute("productId").toString();
        HttpSession session = request.getSession(false);
        if(productId != null && session != null ){
            ArrayList<CartItem> cartItems = (ArrayList<CartItem>) session.getAttribute(Constants.CART_ITEMS);
            for(CartItem item:cartItems){
                if(item.getProduct().getId().equals(productId)){
                    if(item.removeOne()){
                        DBController dbc = new DBController();
                        Product product = dbc.getProduct(productId);
                        int newStock = product.getStock() + 1;
                        product.setStock(newStock);
                        dbc.updateProduct(product);
                    }
                }
            }
            session.setAttribute(Constants.CART_ITEMS, cartItems);
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
