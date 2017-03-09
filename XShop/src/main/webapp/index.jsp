<%-- 
    Document   : index
    Created on : Mar 1, 2017, 6:41:30 PM
    Author     : michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <jsp:include page="clientviews/head.jsp" />
    <style>
        .greenalert, .redalert{
            text-align: center;
            position: fixed;
            display: block;
            top: 0;
            z-index: 1;
            transition: 1s;
        }
    </style>

    <body>
        <div class="greenalert container hidden"> 
            <div class="alert alert-success">
                <strong>Success!</strong> Product added successfully to your cart.
            </div>
        </div>

        <div class="redalert container hidden">
            <div class="alert alert-danger">
                <strong>Fail!</strong> Unfortunately this product is out of stock.
            </div>
        </div>
        <jsp:include page="clientviews/header.jsp" />  

        <div id="all">

            <div id="content" class="container">

                <div class="container">
                    <jsp:include page="clientviews/carousel.jsp" />
                    <div class="list-group col-md-3">                    
                        <jsp:include page="GetCategories" /> 
                        <jsp:include page="clientviews/search.jsp" />
                    </div>
                    <div class="items col-md-9 box" id="scrollfoo">
                        <jsp:include page="productslist" />
                    </div>

                </div>
            </div>
            <jsp:include page="footer" />
        </div>
        <jsp:include page="clientviews/scripts.jsp" />
    </body>
</html>

<%--<jsp:include page="clientviews/header.jsp" />--%>
<%--<jsp:include page="clientviews/carousel.jsp" />--%>
