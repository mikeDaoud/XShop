/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop;

import com.jetsmad.xshop.util.beans.SessionAttrs;
import com.jetsmad.xshop.util.beans.User;
import com.jetsmad.xshop.util.database.DBController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author markoiti
 */
@WebServlet(name = "EditAccount", urlPatterns = {"/EditAccount"})
public class EditAccount extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String userId = (String) request.getAttribute(SessionAttrs.USER_ID);
        System.out.println(userId);
        User currUser = (new DBController()).getUserById(userId);
        request.setAttribute(SessionAttrs.CURRENT_USER_OBJECT, currUser);

        RequestDispatcher rd = request.getRequestDispatcher("updateAccount.jsp");
        rd.forward(request, response);

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
