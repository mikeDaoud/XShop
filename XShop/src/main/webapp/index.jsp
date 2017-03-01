<%-- 
    Document   : index
    Created on : Mar 1, 2017, 6:41:30 PM
    Author     : michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title> Welcome to XShop </title>
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">Ï
        <link href="resources/css/custom.css" rel="stylesheet">
        <link href="resources/css/font-awesome.css" rel="stylesheet">
        <link href="resources/css/slider.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <jsp:include page="carousel.jsp" />
        <div id="content">
            <div class="list-group col-md-3">
                <jsp:include page="categories.jsp" />
            </div>
            
            <div class="items col-md-9">
                <jsp:include page="/productslist" />
            </div>

        </div>
    </body>
</html>
