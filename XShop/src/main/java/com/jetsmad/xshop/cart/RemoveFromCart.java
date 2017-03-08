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
import javax.servlet.RequestDispatcher;
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
        String productId = request.getParameter("productId");
        ///----- merna ---
        String qty = request.getParameter("qty");
        Boolean flag= false;
        System.out.println(" from remove servlet >><< " + productId);
        //---- End merna ---
        HttpSession session = request.getSession(true);
        if (productId != null && session != null) {
            ArrayList<CartItem> cartItems = (ArrayList<CartItem>) session.getAttribute(Constants.CART_ITEMS);
           CartItem item;
            for (int i=0;i<=cartItems.size();i++) {
                item=cartItems.get(i);
                if (item.getProduct().getId().equals(productId)) {
                    if (item.getQuantity()>= 1 ) {
                        DBController dbc = new DBController();
                        Product product = dbc.getProduct(productId);
                        System.out.println("qty=" + Integer.parseInt(qty));
                        int newStock = product.getStock() + Integer.parseInt(qty); // note hyzod el qty msh 1 bs -_-
                        product.setStock(newStock);
                        dbc.updateProduct(product);
                        flag= true;
                    }
                    cartItems.remove(i);
                }
            }
            session.setAttribute(Constants.CART_ITEMS, cartItems);
        } 
        //----- merna -----
        if(flag == true){
            System.out.println(" i'm done remove >><< ");
            RequestDispatcher rd = request.getRequestDispatcher("clientviews/basket.jsp");
            rd.include(request, response);
        }else{
            PrintWriter out = response.getWriter();
            out.write("false");
        }
        //----- end merna ----
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
