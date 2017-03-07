<%-- 
    Document   : reviewOrder
    Created on : Mar 7, 2017, 6:59:02 PM
    Author     : markoiti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <jsp:include page="clientviews/head.jsp" />

    <body>
        <jsp:include page="clientviews/header.jsp" />  
        
        <div id="all">
            
            <div id="content">
                <div class="container">
                    <jsp:include page="clientviews/checkout1.jsp" />  
                </div>
            </div>
            
            <jsp:include page="footer" />
        </div>
        <jsp:include page="clientviews/scripts.jsp" />
    </body>
</html>