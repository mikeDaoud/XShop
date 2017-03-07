/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop.cart;

import com.jetsmad.xshop.util.beans.CartItem;
import com.jetsmad.xshop.util.beans.Constants;
import com.jetsmad.xshop.util.beans.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;
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
@WebServlet(name = "PlaceOrder", urlPatterns = {"/PlaceOrder"})
public class PlaceOrder extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

//        Servlet that does the following:
//        1. get the details of the form from the request
//        2. get the cart items from the session
//        3. Create a unique Id for the order
//        4. get the userID from the session
//        5. get the system date into a string (hint check simpledatefromat class)
//        6. Create an order object with all that data (Status: pending)
//        7. Add teh Order object on the session
//        8. upon success forward to the payment step in checkout (to be done later)
        // let that the names of filed the same in the bean 
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        HttpSession session = request.getSession(false);
        Order order;
        if (session != null) {
            order = new Order(UUID.randomUUID().toString().substring(20), (String) session.getAttribute(Constants.USER_ID), (String) request.getAttribute("street"), (String) request.getAttribute("city"), (String) request.getAttribute("governorate"), (String) request.getAttribute("phone"), dtf.format(now).toString(), (ArrayList<CartItem>) (session.getAttribute(Constants.CART_ITEMS)), "pending");
            session.setAttribute(Constants.Order, order);
            RequestDispatcher rd = request.getRequestDispatcher("transaction.jsp");
            rd.forward(request, response);
            // forward for what 
        }

    }

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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
