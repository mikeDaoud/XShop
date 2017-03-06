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
@WebServlet(name = "AddToCart", urlPatterns = {"/addtocart"})
public class AddToCart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
//        Servlet called with AJAX that does the following:
//        1. gets Product ID from request
//        2. check product stock in database
//        3. update stock in database (-1)
//        4. adds the product to the cart object on the session 
//        5. reply with a response of one string "true" or "false"
        boolean isNew = true;
        PrintWriter out = response.getWriter();
        String productId = request.getAttribute("productId").toString();
        DBController dbc = new DBController();
        if(productId != null){
            Product product = dbc.getProduct(productId);
            if(product!= null && product.getStock() >= 1){
                int newStock = product.getStock() - 1;
                product.setStock(newStock);
                dbc.updateProduct(product);
                ArrayList<CartItem> cartItems;
                HttpSession session = request.getSession(false);
                if (session == null){
                    session = request.getSession(true);
                    cartItems = new ArrayList<>();
                }else{
                    cartItems = (ArrayList<CartItem>) session.getAttribute(Constants.CART_ITEMS);
                }
                for(CartItem item:cartItems){
                    if(item.getProduct().getId().equals(productId)){
                        item.addOne();
                        isNew = false;
                    }
                }
                if(isNew){
                    CartItem newItem = new CartItem(product, 1);
                    cartItems.add(newItem);
                }
                session.setAttribute(Constants.CART_ITEMS, cartItems);
                out.write("true");
            }else{
                out.write("false");
            }
        }else{
            out.write("false");
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
