
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <jsp:include page="clientviews/head.jsp" />

    <body>
        <jsp:include page="clientviews/header.jsp" />  
        
        <div id="all">
            
            <div id="content">
                <div class="container">
                    <div class="col-md-6">
                        <jsp:include page="clientviews/signup.jsp" />
                    </div>

                    <div class="col-md-6">
                        <jsp:include page="clientviews/login.jsp" />
                    </div>
                </div>
            </div>Ï
            
            <jsp:include page="footer" />
        </div>
        <jsp:include page="clientviews/scripts.jsp" />
    </body>
</html>