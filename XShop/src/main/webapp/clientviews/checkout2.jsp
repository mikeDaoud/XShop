<%-- 
    Document   : checkout2
    Created on : Mar 7, 2017, 5:42:34 PM
    Author     : markoiti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-md-9" id="checkout">

    <div class="box">
        <form method="post" action="PlaceOrder">
            <h1>Checkout - Delivery Address</h1>
            <ul class="nav nav-pills nav-justified">
                <li><a href="#"><i class="fa fa-eye"></i><br>Order Review</a>
                </li>
                <li class="active"><a href="checkout1.html"><i class="fa fa-map-marker"></i><br>Address</a>
                </li>
                <li class="disabled"><a href="#"><i class="fa fa-money"></i><br>Payment</a>
                </li>

            </ul>

            <div class="content" style="padding-right: 20px; padding-left: 20px;">
                <div class="row">
                    <div class="form-group">
                        <label for="street">Street Address</label>
                        <input type="text" class="form-control" name="street" id="street" required>

                    </div>
                </div>
                <!-- /.row -->

                <div class="row">

                    <div class="form-group">
                        <label for="city">City</label>
                        <input type="text" class="form-control" name="city" id="city" required>
                    </div>

                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="form-group">
                        <label for="gov">Governorate</label>
                        <input type="text" class="form-control" name="governorate" id="gov" required>

                    </div>

                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="form-group">
                        <label for="phone">Phone Number</label>
                        <input type="tel" class="form-control" name="phone" id="phone" required="">

                    </div>
                </div>
                <!-- /.row -->


            </div>
            <!-- /.content -->

            <div class="box-footer">
                <div class="pull-left">
                    <a href="basket.html" class="btn btn-default"><i class="fa fa-chevron-left"></i>Back to Order Review</a>
                </div>
                <div class="pull-right">
                    <button type="submit" class="btn btn-primary">Continue to Payment<i class="fa fa-chevron-right"></i>
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
