<%-- 
    Document   : index
    Created on : Mar 1, 2017, 6:41:30 PM
    Author     : michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <jsp:include page="clientviews/head.jsp" />

    <body>
        <jsp:include page="clientviews/header.jsp" />  

        <div id="all">

            <div id="content" class="container">

                <div class="container">
                    <jsp:include page="clientviews/carousel.jsp" />
                    <div class="list-group col-md-3">                    
                    <jsp:include page="GetCategories" /> 
                    <jsp:include page="clientviews/search.jsp" />
                    </div>
                    <jsp:include page="productslist" />
                    
                </div>
            </div>
                    <jsp:include page="footer" />
        </div>
                    <jsp:include page="clientviews/scripts.jsp" />
    </body>
</html>

<%--<jsp:include page="clientviews/header.jsp" />--%>
<%--<jsp:include page="clientviews/carousel.jsp" />--%>
