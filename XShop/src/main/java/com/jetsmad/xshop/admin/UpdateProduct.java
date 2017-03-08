/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop.admin;

import com.jetsmad.xshop.util.beans.Product;
import com.jetsmad.xshop.util.database.DBController;
import java.io.IOException;
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
@WebServlet(name = "UpdateProduct", urlPatterns = {"/UpdateProduct"})
public class UpdateProduct extends HttpServlet {

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
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            response.setContentType("text/html;charset=UTF-8");
            String product_id = request.getParameter("productObjUbdate");
            Product product = new Product();
            DBController dbController = new DBController();
            product.setId(product_id);
            product.setName(request.getParameter("name"));
            product.setPrice(Float.parseFloat((String) request.getParameter("price")));
            product.setStock(Integer.parseInt(request.getParameter("stock")));
            product.setCategory(request.getParameter("category"));
            product.setDesc(request.getParameter("desc"));
            product.setActive(Boolean.parseBoolean(request.getParameter("productStatus")));
            //product.setImg(request.getParameter("img"));
            System.out.println("product geh hena" + product.getName());
            dbController.updateProduct(product);
            RequestDispatcher rd = request.getRequestDispatcher("GetAllProducts");
            rd.forward(request, response);
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
