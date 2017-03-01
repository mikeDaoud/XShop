<%-- 
    Document   : index
    Created on : Feb 20, 2017, 11:59:13 AM
    Author     : mosta
--%>

<%@page import="com.jetsmad.xshop.util.beans.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jetsmad.xshop.util.database.DBController"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="productsList" value="${requestScope.products}"></c:set>


<c:forEach var="prdct" items="${productsList}">
    <div class=" product-holder col-md-4">
        <div class="product-item text-center">
            <img class="product-img img-responsive" src="/resources/images/example.png"/>
            <h3 class="product-title"><c:out value="${prdct.name}"></c:out></h3>
                <div class="h4 product-price">
                    <span>$<c:out value="${prdct.price}"></c:out></span>
                </div>
                <div class="buttons-holder">
                    <a class="btn btn-default btn-quick-view hidden-xs" rel="tooltip" title="Quick View" href="/product/blue-headphones"><i class="fa fa-eye"></i></a>
                    <input type="hidden" name="productId" value="1"/>
                    <a class="btn btn-danger btn-add-cart" href="#">Add to Cart</a>
                </div>
            </div>
        </div>
</c:forEach>


