/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop;

import com.mysql.cj.api.Session;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author markoiti
 */
@WebServlet(name = "SignInAdminService", urlPatterns = {"/SignInAdmin"})
public class SignInAdminService extends HttpServlet {

    String adminUserName;
    String adminPassword;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        System.out.println(userName);
        System.out.println(password);

        getAdminXmlData(request.getServletContext().getRealPath(""));

        if (userName != null && password != null && adminPassword != null && adminUserName != null) {
            if (adminUserName.trim().equals(userName) && adminPassword.trim().equals(password)) {
                request.getSession(true).setAttribute("admin_name", userName);
                request.getRequestDispatcher("adminviews/admin.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Wrong user name or Password");
                request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
            }
        } else {
            //emptey data
            request.setAttribute("error", "no data entered");
            request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public void getAdminXmlData(String path) {
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bfname = false;
                boolean blname = false;

                @Override
                public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
                    super.startElement(uri, localName, qName, attributes);
                    if (qName.equals("userName")) {
                        bfname = true;
                    }
                    if (qName.equals("password")) {
                        blname = true;
                    }
                }

                @Override
                public void characters(char ch[], int start, int length) {
                    if (bfname) {
                        adminUserName = new String(ch, start, length);
                        bfname = false;
                    }
                    if (blname) {
                        adminPassword = new String(ch, start, length);
                        blname = false;
                    }
                }
            };

            saxParser.parse(path + "/resources/xml/admin.xml", handler);
//            saxParser.parse("src/main/webapp/resources/xml/admin.xml", handler);
        } catch (ParserConfigurationException | org.xml.sax.SAXException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
