<%-- 
    Document   : cart
    Created on : Mar 5, 2017, 6:27:55 PM
    Author     : michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <jsp:include page="clientviews/head.jsp" />

    <body>
        <jsp:include page="clientviews/header.jsp" />  
        
        <div id="all">
            
            <div id="content">
                <div class="container" id="basketDiv">
                    <jsp:include page="clientviews/basket.jsp" />  
                </div>
            </div>
            
            <jsp:include page="footer" />
        </div>
        <jsp:include page="clientviews/scripts.jsp" />
    </body>
</html>
