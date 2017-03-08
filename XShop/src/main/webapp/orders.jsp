<%-- 
    Document   : orders
    Created on : Mar 7, 2017, 8:18:04 PM
    Author     : markoiti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <jsp:include page="clientviews/head.jsp" />

    <body>
        <jsp:include page="clientviews/header.jsp" />  
        
        <div id="all">
            
            <div id="content container">
                <div class="container">
                    <jsp:include page="clientviews/ordersdetails.jsp" />  
                
            </div>
            
            <jsp:include page="footer" />
        </div>
        <jsp:include page="clientviews/scripts.jsp" />
    </body>
</html>
