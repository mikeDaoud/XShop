<%-- 
    Document   : productDetails
    Created on : Mar 6, 2017, 12:46:42 PM
    Author     : Merna
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="col-md-12">

    <div class="row" id="productMain">
        <div class="col-sm-6">
            <div id="mainImage">
                <c:choose>
                    <c:when test="${empty requestScope.productObj.img}">		
                        <img src="${pageContext.request.contextPath}/resources/client/img/detailbig1.jpg" alt="" class="img-responsive">		
                    </c:when>		
                    <c:otherwise>		
                        <img src="resources/images/${requestScope.productObj.img}" alt="" class="img-responsive">		
                    </c:otherwise>   		
                </c:choose>        
            </div>

        </div>
        <div class="col-sm-6">
            <div class="">
                <h1 class="text-center">${requestScope.productObj.name}</h1>
                <p class="text-center">${requestScope.productObj.desc}</a>
                </p>

                <p class="price">$${requestScope.productObj.price}</p>

                <c:choose>
                    <c:when test="${requestScope.productObj.stock gt 0}">
                        <p class="text-center" style="color: green;">IN STOCK</p>
                    </c:when>
                    <c:otherwise>
                        <p class="text-center" style="color: red;">OUT OF STOCK</p>
                    </c:otherwise>   
                </c:choose>

                <p class="text-center buttons">
                    <a href="#" name="${requestScope.productObj.id}" class="btn btn-primary cart-btn <c:if test="${requestScope.productObj.stock lt 1}">disabled</c:if>" ><i class="fa fa-shopping-cart"></i> Add to cart</a>

                </p>


            </div>


        </div>

    </div>



</div>
<!-- /.col-md-9 -->
