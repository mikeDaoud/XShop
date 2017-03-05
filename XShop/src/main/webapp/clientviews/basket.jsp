
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.jetsmad.xshop.util.beans.CartItem"%>
<%@page import="com.jetsmad.xshop.util.beans.Product"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cart" value="${sessionScope.cart}"></c:set>
<c:set var="total" value="${0}"></c:set>


    <div class="col-md-9" id="basket">

        <div class="box">

            <form method="post" action="checkout1.html">

                <h1>Shopping cart</h1>
                <p class="text-muted">You currently have 3 item(s) in your cart.</p>
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <th colspan="2">Product</th>
                                <th>Quantity</th>
                                <th>Unit price</th>
                                <th colspan="2">Total</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${cart}">
                            <tr>
                                <td>
                                    <a href="#">
                                        <img src="img/detailsquare.jpg" alt="White Blouse Armani">
                                    </a>
                                </td>
                                <td><c:out value="${item.product.name}"></c:out>
                                    </td>
                                    <td>
                                        <input type="number" value="<c:out value="${item.quantity}"></c:out>">
                                    </td>
                                    <td>$<c:out value="${item.product.price}"></c:out></td>
                                    <c:set var="itemtotal" value="${item.product.price * item.quantity}"></c:set>
                                    <td>$<c:out value="${pageScope.itemtotal}"></c:out></td>
                                    <td><a href="#"><i class="fa fa-trash-o"></i></a>
                                    </td>
                                </tr>
                            <c:set var="total" value="${pageScope.total + pageScope.itemtotal }"></c:set>
                        </c:forEach>
                       
                    </tbody>
                    <tfoot>
                        <tr>
                            <th colspan="4">Total</th>
                            <th colspan="2">$<c:out value="${pageScope.total}"></c:out></th>
                        </tr>
                    </tfoot>
                </table>

            </div>
            <!-- /.table-responsive -->

            <div class="box-footer">
                <div class="pull-left">
                    <a href="category.html" class="btn btn-default"><i class="fa fa-chevron-left"></i> Continue shopping</a>
                </div>
                <div class="pull-right">

                    <button type="submit" class="btn btn-primary">Proceed to checkout <i class="fa fa-chevron-right"></i>
                    </button>
                </div>
            </div>

        </form>

    </div>
    <!-- /.box -->





</div>
<!-- /.col-md-9 -->

<div class="col-md-3">
    <div class="box" id="order-summary">
        <div class="box-header">
            <h3>Order summary</h3>
        </div>
        <p class="text-muted">Shipping and additional costs are calculated based on the values you have entered.</p>

        <div class="table-responsive">
            <table class="table">
                <tbody>
                    <tr>
                        <td>Order subtotal</td>
                        <th>$<c:out value="${pageScope.total}"></c:out></th>
                    </tr>
                    <tr>
                        <td>Shipping and handling</td>
                        <th>$10.00</th>
                    </tr>
                    <tr>
                        <td>Tax</td>
                        <th>$0.00</th>
                    </tr>
                    <tr class="total">
                        <td>Total</td>
                        <th>$<c:out value="${pageScope.total + 10}"></c:out></th>
                    </tr>
                </tbody>
            </table>
        </div>

    </div>
</div>
<!-- /.col-md-3 -->
