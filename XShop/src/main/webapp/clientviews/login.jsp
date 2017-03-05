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
    <form action="/XShop/signin" method="post">
            <div class="form-group">
                <label for="email">Email</label>
                <input name="loginemail" type="text" class="form-control" id="email" required style="padding:10px" value="<c:out value="${param.loginemail}" ></c:out>">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input name="loginpassword" type="password" class="form-control" required  id="password" style="padding:10px" value=>
            </div>
                <c:if test="${!empty requestScope.error}">
            <p style="color: #e74c3c; text-align: center">wrong email or password</p>
            </c:if>
            <div class="text-center">
                <button type="submit" class="btn btn-primary" style="border-radius: 3px;"><i class="fa fa-sign-in"></i> Log in</button>
            </div>
        </form>  

</div>
