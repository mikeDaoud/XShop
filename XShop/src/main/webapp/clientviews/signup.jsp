<%-- 
    Document   : signup
    Created on : Mar 4, 2017, 6:18:55 PM
    Author     : markoiti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.jetsmad.xshop.util.beans.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="user" value="${requestScope.user_object}"></c:set>
    <div class="box">
        <h1>New account</h1>

        <p class="lead">Not our registered customer yet?</p>
        <p>With registration with us new world of fashion, fantastic discounts and much more opens to you! The whole process will not take you more than a minute!</p>

        <hr>    
        <form action="/XShop/signup" method="post">
            <div class="form-group">
                <label for="name">Name *</label>
                <input name="name" type="text" class="form-control" required id="name" style="padding:10px" value="<c:out value="${param.name}"></c:out>">
            </div>
            <div class="form-group">
                <label for="email">Email *</label>
                <input name="email" type="email" class="form-control" required id="email" style="padding:10px" value="<c:out value="${param.email}"></c:out>">
            <c:if test="${!empty requestScope.erroremail}"> 
                <span class="pull-right" style="color: #e74c3c">Email Already Exists</span>
            </c:if>
        </div>

        <div class="form-group">
            <label for="password">Password *</label>
            <input name="password" type="password" class="form-control" required id="password" style="padding:10px" >
        </div>

        <div class="form-group">
            <label for="password">Confrim Password *</label>
            <input name="repeatedPassword" type="password" class="form-control" required id="password" style="padding:10px">
            <c:if test="${!empty requestScope.errorpassword}"> 
                <span class="pull-right" style="color: #e74c3c">passowords don't match</span>
            </c:if>
        </div>

        <div class="form-group">
            <label for="name">Job</label>
            <input name="job" type="text" class="form-control" id="name" style="padding:10px" value="<c:out value="${param.job}"></c:out>">
            </div>

            <div class="form-group">
                <label for="name">Address</label>
                <input name="address" type="text" class="form-control" id="name" style="padding:10px" value="<c:out value="${param.address}"></c:out>">
            </div>

            <div class="form-group">
                <label for="name">Date of Birth</label>
                <input name="dOB" type="date" class="form-control" id="name" style="padding:5px" value="<c:out value="${param.dob}"></c:out>">
        </div>

        <legend>What are your interests ?</legend>

        <div class="form-group">
            <div class="col-md-6">
                <input type="checkbox" name="interest" value="clothes" /> Clothes<br/>
                <input type="checkbox" name="interest" value="electronics"/> Electronics<br/>
                <input type="checkbox" name="interest" value="watches"/> Watches<br />
            </div>
            <div class="col-md-6">
                <input type="checkbox" name="interest" value="jewlery"/> Jewlery<br/>
                <input type="checkbox" name="interest" value="electronics"/> Electronics<br/>
                <input type="checkbox" name="interest" value="watches"/> Watches<br />
            </div>
        </div>

        <small>* required fields</small>
        <div class="text-center">
            <button type="submit" class="btn btn-primary" style="border-radius: 3px;" ><i class="fa fa-user-md"></i> Register</button>
        </div>
    </form>  
</div>