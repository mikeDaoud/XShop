/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop;

import com.jetsmad.xshop.util.beans.Constants;
import com.jetsmad.xshop.util.beans.User;
import com.jetsmad.xshop.util.database.DBController;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "SignUpService", urlPatterns = {"/signup"})
public class SignUpService extends HttpServlet {

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
        System.out.println("signup in");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            User user = new User();
            DBController dbc = new DBController();
            if (dbc.checkEmail(request.getParameter("email"))) {
                if (request.getParameter("password").equals(request.getParameter("repeatedPassword"))) {
                    user.setId(UUID.randomUUID().toString().substring(10));
                    user.setName(request.getParameter("name"));
                    user.setEmail(request.getParameter("email"));
                    user.setDob(request.getParameter("dOB"));
                    user.setPassword(request.getParameter("password"));
                    user.setAddress(request.getParameter("address"));
                    user.setJob(request.getParameter("job"));
                    user.setInterests(request.getParameterValues("interest"));
                    dbc.addUser(user);
                    HttpSession session = request.getSession(true);
                    session.setAttribute(Constants.USER_ID, user.getId());
                    session.setAttribute(Constants.USER_NAME, user.getName());
                    //TODO:redirect to card page
                } else {
                    request.setAttribute("errorpassword", "passowords don't match");
                    RequestDispatcher rd = request.getRequestDispatcher("clientviews/register.jsp");
                    rd.include(request, response);
                }
            } else {

                //TODO:redirect to signup page with message to change email becouse it used before
//                out.println("repeated email");
                request.setAttribute("erroremail", "Email already exists");
                RequestDispatcher rd = request.getRequestDispatcher("clientviews/register.jsp");
                rd.include(request, response);
            }
            
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
