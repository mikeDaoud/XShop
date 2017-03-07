<%-- 
    Document   : admin
    Created on : Mar 1, 2017, 8:41:24 AM
    Author     : michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Lumino - Dashboard</title>


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
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="AdminHome"><span>XShop</span>Admin</a>                  
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
                <li class="active"><a href="AdminHome"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> Dashboard</a></li>
                <li><a href="GetAllProducts"><svg class="glyph stroked tag"><use xlink:href="#stroked-tag"/></svg>
                        Products</a></li>
                <li><a href="GetAllUsers"><svg class="glyph stroked male user "><use xlink:href="#stroked-male-user"/></svg>
                        Users</a></li>
                <li><a href="GetAllOrders"><svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg>
                        Orders</a></li>



            </ul>

        </div>
        <!--/.sidebar-->

        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
            <div class="row">

            </div>
            <!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Dashboard</h1>
                </div>
            </div>
            <!--/.row-->

            <div class="row">
                <div class="col-xs-12 col-md-6 col-lg-3">
                    <div class="panel panel-blue panel-widget ">
                        <div class="row no-padding">
                            <div class="col-sm-3 col-lg-5 widget-left">
                                <svg class="glyph stroked male user "><use xlink:href="#stroked-male-user"/></svg>
                            </div>
                            <div class="col-sm-9 col-lg-7 widget-right">
                                <div class="large">100</div>
                                <div class="text-muted">Registered Users</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-md-6 col-lg-3">
                    <div class="panel panel-orange panel-widget">
                        <div class="row no-padding">
                            <div class="col-sm-3 col-lg-5 widget-left">
                                <svg class="glyph stroked tag"><use xlink:href="#stroked-tag"/></svg>
                            </div>
                            <div class="col-sm-9 col-lg-7 widget-right">
                                <div class="large">150</div>
                                <div class="text-muted">Listed products</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-md-6 col-lg-3">
                    <div class="panel panel-teal panel-widget">
                        <div class="row no-padding">
                            <div class="col-sm-3 col-lg-5 widget-left">
                                <svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg>

                            </div>
                            <div class="col-sm-9 col-lg-7 widget-right">
                                <div class="large">5000</div>
                                <div class="text-muted">Total sales</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-md-6 col-lg-3">
                    <div class="panel panel-red panel-widget">
                        <div class="row no-padding">
                            <div class="col-sm-3 col-lg-5 widget-left">
                                <svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg>
                            </div>
                            <div class="col-sm-9 col-lg-7 widget-right">
                                <div class="large">12</div>
                                <div class="text-muted">Pending orders</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--/.row-->


            <div class="row">
                <div class="col-md-12">

                    <div class="panel panel-default chat">
                        <div class="panel-heading" id="accordion"><svg class="glyph stroked clipboard with paper"><use xlink:href="#stroked-clipboard-with-paper"/></svg> Orders History </div>

                        <div class="panel-body">

                            <div class="alert bg-primary" role="alert">
                                <svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg> Order no. (order no. here)  from user (User name here) on (order date here) total $(Order total here) <span style="color: #3498db;">Pending</span>
                            </div>

                            <div class="alert bg-primary" role="alert">
                                <svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg> Order no. (order no. here) from user (User name here) on (order date here) total $(Order total here) <span style="color: #2ecc71;">Delivered</span>
                            </div>

                            <div class="alert bg-primary" role="alert">
                                <svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg> Order no. (order no. here) from user (User name here) on (order date here) total $(Order total here) <span style="color: #e74c3c;">Cancelled</span>
                            </div>

                        </div>

                    </div>

                </div>
                <!--/.col-->

                <div class="col-md-4">


                </div>
                <!--/.col-->
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