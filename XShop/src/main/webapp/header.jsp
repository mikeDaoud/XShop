<%-- 
    Document   : header
    Created on : Feb 28, 2017, 7:29:12 PM
    Author     : michael
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Brand</a>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <a href="#">Login</a>
            </li>
            
            <li>
                <c:if test="${empty sessionScope.userName}"> 
                    color="red"
                </c:if>
                    
                <c:otherwise>
                        color = "blue"
                </c:otherwise>
            </li>
            
            <li>
                <a href="#"><i class="fa fa-shopping-cart fa-2x" aria-hidden="true"></i><span class="badge">0</span></a>
            </li>
            <li>
                <a href="#"><i class="fa fa-bars fa-2x" aria-hidden="true"></i></a>
            </li>
        </ul>
    </div>
</nav>
