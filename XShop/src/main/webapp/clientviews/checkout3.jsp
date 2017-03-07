<%-- 
    Document   : checkout3
    Created on : Mar 7, 2017, 5:41:57 PM
    Author     : michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<div id="content">
    <div class="container">

        <div class="col-md-9" id="checkout">

            <div class="box">
                <form method="post" action="ProcessPayment">
                    <h1>Checkout - Payment</h1>
                    <ul class="nav nav-pills nav-justified">
                        <li><a href="checkout4.html"><i class="fa fa-eye"></i><br>Order Review</a>
                        <li><a href="checkout1.html"><i class="fa fa-map-marker"></i><br>Address</a>
                        </li>
                        <li class="active"><a href="#"><i class="fa fa-money"></i><br>Payment</a>
                        </li>

                        </li>
                    </ul>

                    <div class="content">
                        <div class="content" style="padding-right: 90px; padding-left: 90px;">
                            <div class="card-wrapper"></div>
                            <div class="form-group">
                                <label for="name">Card Holder's name</label>
                                <input  class="form-control" type="text" name="name" id="name" placeholder="Name on the Card" required>
                            </div>
                            <label for="number">Card Number</label>
                            <div class="form-group">
                                <input width="50px;" class="form-control" type="text" name="number" id="number" placeholder="•••• •••• •••• ••••" required>
                            </div>

                            <div class="col-md-12">
                                <div class="col-md-6">
                                    <label for="expiry">Card Expiry date mm/yyyy</label>
                                    <div class="form-group">
                                        <input width="50px;" class="form-control" type="text" name="expiry" id="expiry" placeholder="••/••••" required>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <label for="cvc">Security number CVC</label>
                                    <div class="form-group">
                                        <input width="50px;" class="form-control" type="text" name="cvc"id="cvc" placeholder="•••" required>
                                    </div>
                                </div>
                            </div>

                            <input type="text"  disabled="" name="" value="" style="color: transparent; border:none; padding:0; margin:0; max-height:2px;">

                        </div>
                        <!-- /.row -->

                    </div>
                    <!-- /.content -->

                    <div class="box-footer">
                        <div class="pull-left">
                            <a href="index.jsp" class="btn btn-default"><i class="fa fa-chevron-left"></i>Back to Address</a>
                        </div>
                        <div class="pull-right">
                            <button type="submit" class="btn btn-primary">Place an Order<i class="fa fa-chevron-right"></i>
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
                                <th>$446.00</th>
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
                                <th>$456.00</th>
                            </tr>
                        </tbody>
                    </table>
                </div>

            </div>

        </div>
        <!-- /.col-md-3 -->

    </div>
</div>
