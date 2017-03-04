<%-- 
    Document   : login
    Created on : Mar 4, 2017, 6:18:39 PM
    Author     : markoiti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="box">
    <h1>Login</h1>

    <p class="lead">Already our customer?</p>

    <hr>
    <form action="" method="post">
            <div class="form-group">
                <label for="email">Email</label>
                <input name="email" type="text" class="form-control" id="email" style="padding:10px" value="<c:out value="${requestScope.user_email}"></c:out>">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input name="password" type="password" class="form-control" id="password" style="padding:10px" value=>
            </div>
            <p style="color: #e74c3c; text-align: center">Error Message to show here</p>
            <div class="text-center">
                <button type="submit" class="btn btn-primary" style="border-radius: 3px;"><i class="fa fa-sign-in"></i> Log in</button>
            </div>
        </form>
    <c:if test="${!empty requestScope.user_email}">
        <c:set var="user" value="${requestScope.user_email}"></c:set>
        <form action="" method="post">
            <div class="form-group">
                <label for="email">Email</label>
                <input name="email" type="text" class="form-control" id="email" style="padding:10px" value="<c:out value="${user}"></c:out>">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input name="password" type="password" class="form-control" id="password" style="padding:10px" value=>
            </div>
            <p style="color: #e74c3c; text-align: center">Error Message to show here</p>
            <div class="text-center">
                <button type="submit" class="btn btn-primary" style="border-radius: 3px;"><i class="fa fa-sign-in"></i> Log in</button>
            </div>
        </form>
    </c:if>
        <c:if test="${user==null}"> 
        <form action="customer-orders.html" method="post">
            <div class="form-group">
                <label for="email">Email</label>
                <input name="email" type="text" class="form-control" id="email" style="padding:10px">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input name="password" type="password" class="form-control" id="password" style="padding:10px">
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-primary" style="border-radius: 3px;"><i class="fa fa-sign-in"></i> Log in</button>
            </div>
        </form>
    </c:if>
</div>
