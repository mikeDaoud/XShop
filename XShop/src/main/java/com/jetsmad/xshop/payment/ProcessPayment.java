/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop.payment;

import com.jetsmad.xshop.util.beans.CartItem;
import com.jetsmad.xshop.util.beans.Constants;
import com.jetsmad.xshop.util.beans.Order;
import com.jetsmad.xshop.util.creditcards.CreditCard;
import com.jetsmad.xshop.util.creditcards.CreditCardDataBase;
import com.jetsmad.xshop.util.database.DBController;
import java.io.IOException;
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
 * @author markoiti
 */
@WebServlet(name = "ProcessPayment", urlPatterns = {"/ProcessPayment"})
public class ProcessPayment extends HttpServlet {

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
        
        //1- get creditCard data from request  and put it in Obj
        CreditCard creditCard = new CreditCard();
        creditCard.setCreditCardNumber(request.getParameter("number").trim());
        creditCard.setExpiryMonth(request.getParameter("expiry").trim());
        creditCard.setExpiryYear(request.getParameter("expiry").trim());
        creditCard.setSecurityCode(request.getParameter("cvc").trim());

        CreditCardDataBase creditCardDB = new CreditCardDataBase();
        //2- check if this card valid in our DB or Not 
        if (creditCardDB.validateCreditCard(creditCard)) {
            //FOCUS!!,,send "totalPrice" with request..
            //double totalPrice = Double.parseDouble((String)request.getParameter("totalPrice")); 
            //3- send total price to make payment processing and update balance in DB ..
            HttpSession session = request.getSession();
                Order order = (Order) session.getAttribute(Constants.Order);
            if (creditCardDB.processPayment(creditCard.getCreditCardNumber(), order.getTotal())) {
                // completed the payment process successfully
                new DBController().insertOrder(order);
                session.setAttribute("cart", new ArrayList<CartItem>());
                request.setAttribute("success", "Successful Transaction");
                RequestDispatcher rd = request.getRequestDispatcher("transaction.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("err", "Not Enough Credit in this card");
                RequestDispatcher rd = request.getRequestDispatcher("transaction.jsp");
                rd.forward(request, response);
                //  Balance not enough
            }
        } else {
                request.setAttribute("err", "Invalid Card Data");
                RequestDispatcher rd = request.getRequestDispatcher("transaction.jsp");
                rd.forward(request, response);
            // creditCard not Vaild
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
