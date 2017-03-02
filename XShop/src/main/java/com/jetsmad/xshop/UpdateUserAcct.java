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
import java.util.UUID;
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
@WebServlet(name = "UpdateUserAcct", urlPatterns = {"/updateaccount"})
public class UpdateUserAcct extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

//        Servlet called with AJAX that does the following:
//        1. gets the new data from the request
//        2. Checks the database for the mail if exists -> if exists reply with "false"
//        3. update the user data in the database
//        4. reply with "true" or "false" string
        //String user_id = (String) request.getAttribute(SessionAttrs.USER_ID);
        String user_id = "12";
        if (user_id != null) {
            User currUser = (new DBController()).getUserById(user_id);
            String user_email = (String) request.getParameter("email");
            if ((user_email != null && user_email.equals(currUser.getEmail())) || (new DBController()).getUser(user_email) == null) {
                User user = new User();
                user.setId(user_id);
                user.setName(request.getParameter("name"));
                user.setEmail(request.getParameter("email"));
                user.setDob(request.getParameter("dOB"));
                user.setPassword(request.getParameter("password"));
                user.setAddress(request.getParameter("address"));
                user.setJob(request.getParameter("job"));
                user.setInterests(request.getParameterValues("interest"));
                (new DBController()).ubdateUser(user);
                HttpSession session = request.getSession(false);
                if (session == null) {
                    session.setAttribute(SessionAttrs.USER_ID, user.getId());
                    session.setAttribute(SessionAttrs.USER_NAME, user.getName());
                    //TODO:redirect to profil page

                } else {
                    session.setAttribute(SessionAttrs.USER_ID, user.getId());
                    session.setAttribute(SessionAttrs.USER_NAME, user.getName());
                    //TODO:redirect to card page

                }
            } else {
                // show error email found
            }
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
