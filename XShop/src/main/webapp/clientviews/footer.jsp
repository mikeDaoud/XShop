<%-- 
    Document   : footer
    Created on : Mar 5, 2017, 5:43:46 PM
    Author     : michael
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:set var="categories" value="${requestScope.footercats}"></c:set>
<div id="footer" data-animate="fadeInUp">
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-sm-4">
                    <h4>Categories</h4>
                    <ul>
                        <c:forEach var="category" items="${categories}">
                            <li>
                                <a href=""><c:out value="${category}"></c:out></a>
                            </li>
                </c:forEach>
                    </ul>

                </div>
                <!-- /.col-md-3 -->


                <!-- /.col-md-3 -->

                <div class="col-md-4 col-sm-4">

                    <h4>Where to find us</h4>

                    <p><strong>Obaju Ltd.</strong>
                        <br>13/25 New Avenue
                        <br>New Heaven
                        <br>45Y 73J
                        <br>England
                        <br>
                        <strong>Great Britain</strong>
                    </p>


                </div>
                <!-- /.col-md-3 -->

                <div class="col-md-4 col-sm-4">

                    <h4>Stay in touch</h4>

                    <p class="social">
                        <a href="#" class="facebook external"><i class="fa fa-facebook"></i></a>
                        <a href="#" class="twitter external"><i class="fa fa-twitter"></i></a>
                        <a href="#" class="instagram external"><i class="fa fa-instagram"></i></a>
                        <a href="#" class="email external"><i class="fa fa-envelope"></i></a>
                    </p>


                </div>
                <!-- /.col-md-3 -->

            </div>
            <!-- /.row -->

        </div>
        <!-- /.container -->
    </div>
    <!-- /#footer -->
    
      <!-- *** COPYRIGHT ***
 _________________________________________________________ -->
    <div id="copyright">
        <div class="container">
            <div class="col-md-6">
                <p class="pull-left">© Copyrights are reserved to the XShop team</p>

            </div>
            <div class="col-md-6">

            </div>
        </div>
    </div>
    <!-- *** COPYRIGHT END *** -->
