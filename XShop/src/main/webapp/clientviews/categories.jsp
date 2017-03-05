<%-- 
    Document   : categories
    Created on : Feb 28, 2017, 7:29:26 PM
    Author     : michael
--%>

<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="categories" value="${requestScope.categories_arraylist}"></c:set>
    
        <div class="panel panel-default sidebar-menu">

            <div class="panel-heading">
                <h3 class="panel-title">Categories</h3>
            </div>

            <div class="panel-body">
                <ul class="nav nav-pills nav-stacked category-menu">
                    <li class="active">
                        <a href="category.html">All</a>
                    </li>
                <c:forEach var="category" items="${categories}">
                    <li>
                        <a href="category.html"><c:out value="${category}"></c:out> </a>
                        </li>
                </c:forEach>

            </ul>

        </div>
    </div>
