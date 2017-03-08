/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop.admin;

import com.jetsmad.xshop.util.beans.Order;
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
 * @author markoiti
 */
@WebServlet(name = "AdminHome", urlPatterns = {"/AdminHome"})
public class AdminHome extends HttpServlet {

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
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("admin_name") != null) {
            String[] dashboardData = new DBController().getDashboardData();
            ArrayList<Order> orders = new DBController().getAllOrders();
            ArrayList<Order> ordersToView = new ArrayList<>();
            if (!orders.isEmpty()) {
                if (orders.size() > 10) {
                    for (int i = 0; i < 10; i++) {
                        ordersToView.add(orders.get(i));
                    }

                } else {
                    for (int i = 0; i < orders.size(); i++) {
                        ordersToView.add(orders.get(i));
                    }
                }

            }
            request.setAttribute("usersnumber", dashboardData[0]);
            request.setAttribute("productsnumber", dashboardData[1]);
            request.setAttribute("ordersnumber", dashboardData[2]);
            request.setAttribute("pendingordersnumber", dashboardData[3]);
            request.setAttribute("orderstoview", ordersToView);
            RequestDispatcher rd = request.getRequestDispatcher("adminviews/admin.jsp");
            // bug in view
            rd.include(request, response);
        } else {
            request.setAttribute("error", "Admin not logged in");
            request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
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
