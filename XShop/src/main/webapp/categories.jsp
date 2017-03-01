<%-- 
    Document   : categories
    Created on : Feb 28, 2017, 7:29:26 PM
    Author     : michael
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.jetsmad.xshop.util.database.DBController"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% ArrayList<String> categories = new DBController().getCategories(); 

    for (String category : categories) {
            out.println("<a href=\"#\" class=\"list-group-item\">" + category +"</a>");
        }
%> 

