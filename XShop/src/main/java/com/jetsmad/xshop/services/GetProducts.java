/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop.services;

import com.jetsmad.xshop.util.beans.Product;
import com.jetsmad.xshop.util.beans.Constants;
import com.jetsmad.xshop.util.database.DBController;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author michael
 */
@WebServlet(name = "getProducts", urlPatterns = {"/productslist"})
public class GetProducts extends HttpServlet {

// get param "type" from request
// if equals "all" -> check parameter "pagenum" and get products at this page
// if equals "category" check parameter "categoryName" and get products of this category
// if equals "search" check parameters "query" "min" "max" and get products with this search query
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("sdfdsjfdsjkfhfdsjk");
        String type = (String) request.getParameter("type");
        DBController db = new DBController();
        ArrayList<Product> allProducts = new ArrayList<>();
        ArrayList<Product> productsToShow = new ArrayList<>();
        System.out.println(type);

        if (type == null || type.equals("all")) {
            System.out.println("all case >>>>>" + type);
            allProducts = db.getAllProducts();
        } else if (type.equals("category")) {
            String categoryName = request.getParameter("categoryName").toString();
            System.out.println("categoty case >>>>>" + type);
            System.out.println(categoryName);
            allProducts = db.getCategoryProducts(categoryName);
        } else if (type.equals("search")) {
            Float min;
            Float max;
            System.out.println("query search case >>>>>");
            allProducts = null;
            String query = request.getParameter("query").toString();
            if (query != null && !(query.trim().equals(""))) {
                System.out.println("query search case >>>>>1");

                if (request.getParameter("min") != null && !(request.getParameter("min").trim().equals(""))) {
                    min = Float.parseFloat((String) request.getParameter("min"));
                } else {
                    min = 0f;
                }
                if (request.getParameter("max") != null && !(request.getParameter("max").trim().equals(""))) {
                    max = Float.parseFloat((String) request.getParameter("max"));
                } else {
                    max = 10000000f;
                }

                allProducts = db.getPriceLimitProducts(query, max, min);
            } else {
                if (request.getParameter("min") != null && !(request.getParameter("min").trim().equals(""))) {
                    min = Float.parseFloat((String) request.getParameter("min"));
                } else {
                    min = 0f;
                }
                if (request.getParameter("max") != null && !(request.getParameter("max").trim().equals(""))) {
                    max = Float.parseFloat((String) request.getParameter("max"));
                } else {
                    max = 10000000f;
                }

                allProducts = db.getPriceLimitProducts(max, min);
            }
        }

//        Integer pagenum = (Integer)request.getParameter("pagenum");
//        if(pagenum == null){
//            pagenum = 1;
//        }
//        if(allProducts.size() >= (pagenum*12)){
//            for(int i = ((pagenum - 1)*12);i < (pagenum*12);i++){
//                productsToShow.add(allProducts.get(i));
//            }
//        }else{
        if (allProducts != null) {
            for (int j = 0; j < allProducts.size(); j++) {
                productsToShow.add(allProducts.get(j));
            }
        } else {
// error not found
        }
//        }
//        

        request.setAttribute(Constants.PRODUCTS_LIST, productsToShow);

        request.getRequestDispatcher("clientviews/products.jsp").include(request, response);

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
