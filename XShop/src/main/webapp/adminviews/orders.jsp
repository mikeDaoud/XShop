<%-- 
    Document   : orders
    Created on : Mar 8, 2017, 6:09:54 AM
    Author     : michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="pendingList" value="${requestScope.pending}"></c:set>
<c:set var="historyList" value="${requestScope.history}"></c:set>
    <!DOCTYPE html>
    <html>

        <head>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Orders</title>


            <link href="${pageContext.request.contextPath}/resources/admin/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/admin/css/bootstrap-table.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/admin/css/styles.css" rel="stylesheet">
        <style media="screen">
            .editbtn{
                border: 1px solid #30a5ff;
                background: transparent;
                color: #30a5ff;
                padding-top: 2px;
                padding-bottom: 2px;
            }
        </style>

        <!--Icons-->
        <script src="${pageContext.request.contextPath}/resources/admin/js/lumino.glyphs.js"></script>
        <!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

    </head>

    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"><span>XShop</span>Admin</a>
                    <ul class="user-menu">
                        <li class="dropdown pull-right">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Admin <span></span></a>
                        </li>
                    </ul>
                </div>

            </div>
            <!-- /.container-fluid -->
        </nav>

        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
            <form role="search">

            </form>
            <ul class="nav menu">
                <li ><a href="AdminHome"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> Dashboard</a></li>
                <li ><a href="GetAllProducts"><svg class="glyph stroked tag"><use xlink:href="#stroked-tag"/></svg>
                        Products</a></li>
                <li><a href="GetAllUsers"><svg class="glyph stroked male user "><use xlink:href="#stroked-male-user"/></svg>
                        Users</a></li>
                <li class="active"><a href="GetAllOrders"><svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg>
                        Orders</a></li>



            </ul>

        </div>
        <!--/.sidebar-->

        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Orders</h1>
                </div>
            </div>
            <!--/.row-->




            <div class="row">
                <div class="col-md-12">

                    <div class="panel panel-default chat">
                        <div class="panel-heading" id="accordion"><svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg> Pending Orders </div>

                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="">
                                    <table data-toggle="table" >
                                        <thead>
                                            <tr>
                                                <th data-field="id" data-align="center">Order ID</th>
                                                <th data-field="name">User ID</th>
                                                <th data-field="price">date</th>
                                                <th data-field="stock">Phone</th>
                                                <th data-field="state">Total</th>
                                                <th data-field="editbtn">Action</th>
                                            </tr>
                                        </thead>
                                        <c:forEach var="order" items="${pendingList}">
                                        <tr>
                                            <td>${order.orderID}</td>
                                            <td>${order.userID}</td>
                                            <td>${order.date}</td>
                                            <td>${order.phone}</td>
                                            <td>$<c:out value="${order.total}"></c:out></td>
                                            <td>
                                                <a  class="btn btn-success editbtn" href="cancelorder?orderid=${order.orderID}&status=delivered&user=admin">Deliver</a>
                                                <a type="submit" class="btn btn-danger editbtn" href="cancelorder?orderid=${order.orderID}&status=canceled&user=admin">Cancel</a>
                                            </td>
                                        </tr>


                                    </table>
                                </div>
                            </div>

                        </div>


                    </div>


                </div>
                <!--/.row-->
            </div>
            <!--/.main-->

            <div class="row">
                <div class="col-md-12">

                    <div class="panel panel-default chat">
                        <div class="panel-heading" id="accordion"><svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg> Orders History </div>

                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="">
                                    <table data-toggle="table" >
                                        <thead>
                                            <tr>
                                                <th data-field="id" data-align="right">Order ID</th>
                                                <th data-field="name">User ID</th>
                                                <th data-field="price">Date</th>
                                                <th data-field="stock">Total</th>
                                                <th data-field="state">Status</th>
                                            </tr>
                                        </thead>
                                        <tr>
                                            <td>id23462</td>
                                            <td>id46345</td>
                                            <td>23/3/2017</td>
                                            <td>$sdh</td>
                                            <td>  <span class="label label-info">Pending</span></td>
                                        </tr>
                                        <tr>
                                            <td>id23462</td>
                                            <td>id46345</td>
                                            <td>23/3/2017</td>
                                            <td>$sdh</td>
                                            <td>  <span class="label label-success">Delivered</span></td>
                                        </tr>
                                        <tr>
                                            <td>id23462</td>
                                            <td>id46345</td>
                                            <td>23/3/2017</td>
                                            <td>$sdh</td>
                                            <td>  <span class="label label-danger">Canceled</span></td>
                                        </tr>
                                    </table>
                                </div>
                            </div>

                        </div>
                    </div>


                </div>
                <!--/.row-->
            </div>
            <!--/.main-->

            <script src="${pageContext.request.contextPath}/resources/admin/js/jquery-1.11.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/resources/admin/js/bootstrap.min.js"></script>
            <script src="${pageContext.request.contextPath}/resources/admin/js/chart.min.js"></script>
            <script src="${pageContext.request.contextPath}/resources/admin/js/chart-data.js"></script>
            <script src="${pageContext.request.contextPath}/resources/admin/js/easypiechart.js"></script>
            <script src="${pageContext.request.contextPath}/resources/admin/js/easypiechart-data.js"></script>
            <script src="${pageContext.request.contextPath}/resources/admin/js/bootstrap-datepicker.js"></script>
            <script src="${pageContext.request.contextPath}/resources/admin/js/bootstrap-table.js"></script>
            <script>
                $('#calendar').datepicker({});

                !function ($) {
                    $(document).on("click", "ul.nav li.parent > a > span.icon", function () {
                        $(this).find('em:first').toggleClass("glyphicon-minus");
                    });
                    $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
                }(window.jQuery);

                $(window).on('resize', function () {
                    if ($(window).width() > 768)
                        $('#sidebar-collapse').collapse('show')
                })
                $(window).on('resize', function () {
                    if ($(window).width() <= 767)
                        $('#sidebar-collapse').collapse('hide')
                })
            </script>
    </body>

</html>
