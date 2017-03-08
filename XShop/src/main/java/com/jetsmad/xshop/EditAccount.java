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
@WebServlet(name = "EditAccount", urlPatterns = {"/EditAccount"})
public class EditAccount extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        if (session.getAttribute(Constants.USER_ID) != null && session.getAttribute(Constants.USER_EMAIL) != null) {
            String userId = (String) request.getAttribute(Constants.USER_ID);
            System.out.println(userId);
            User currUser = (new DBController()).getUserById(userId);
            request.setAttribute(Constants.CURRENT_USER_OBJECT, currUser);

            RequestDispatcher rd = request.getRequestDispatcher("updateAccount.jsp");
            rd.include(request, response);

        } else {
            RequestDispatcher rd = request.getRequestDispatcher("signin");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
