<%-- 
    Document   : ordersdetails
    Created on : Mar 7, 2017, 8:17:37 PM
    Author     : markoiti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var="orders" value="${requestScope.orders}"></c:set>

                <div class="col-md-3">
                    <!-- *** CUSTOMER MENU ***
 _________________________________________________________ -->
                    <div class="panel panel-default sidebar-menu">

                        <div class="panel-heading">
                            <h3 class="panel-title">My Account</h3>
                        </div>

                        <div class="panel-body">

                            <ul class="nav nav-pills nav-stacked">
                                <li>
                                    <a href="customer-orders.html"><i class="fa fa-user"></i> My account</a>
                                </li>
                                <li class="active">
                                    <a href="customer-account.html"><i class="fa fa-list"></i> My orders</a>
                                </li>
                                <li>
                                    <a href="index.html"><i class="fa fa-sign-out"></i> Logout</a>
                                </li>
                            </ul>
                        </div>

                    </div>
                    <!-- /.col-md-3 -->

                    <!-- *** CUSTOMER MENU END *** -->
                </div>
                <div class="col-md-9" id="customer-orders">
                    <div class="box">
                        <h1>My orders</h1>

                        <p class="lead">Your orders in one place.</p>
                        <hr>

                        <div class="table-responsive">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Order</th>
                                        <th>Date</th>
                                        <th>Total</th>
                                        <th>Status</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    
                                <c:forEach var="order" items="${orders}">
                                     
                                    <tr>
                                        <th><c:out value="${order.orderID}"></c:out></th>
                                        <td><c:out value="${order.orderID}"></c:out></td>
                                        <td>$<c:out value="${order.orderID}"></c:out> </td>
                                        <td>
                                        <c:choose>
                                            <c:when test="${order.status == 'received'}">
                                                <span class="label label-success">Received</span>
                                            </td>
                                            <td></td>
                                            </c:when>
                                            <c:when test="${order.status == 'canceled'}">
                                                <span class="label label-danger">Canceled</span>
                                                </td>
                                            <td></td>
                                            </c:when>
                                            <c:otherwise>
                                                 <span class="label label-info">Pending</span>
                                                 </td>
                                        
                                        <td><a href="cancelorder?orderid=${order.orderID}" class="text-danger">Cancel</a>
                                        </td>
                                            </c:otherwise>
                                        </c:choose>
                                        
                                    </tr>
                                </c:forEach>
                                    
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
