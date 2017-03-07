<%-- 
    Document   : add product
    Created on : Mar 7, 2017, 8:43:28 AM
    Author     : mosta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Lumino - Dashboard</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-table.css" rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet">
        <style media="screen">
            thead {
                text-align: center;
            }

            .editbtn {
                border: 1px solid #30a5ff;
                background: transparent;
                color: #30a5ff;
                padding-top: 2px;
                padding-bottom: 2px;
            }
        </style>

        <!--Icons-->
        <script src="js/lumino.glyphs.js"></script>
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
                <li><a href="index.html"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> Dashboard</a></li>
                <li class="active"><a href="products.html"><svg class="glyph stroked tag"><use xlink:href="#stroked-tag"/></svg>
                        Products</a></li>
                <li><a href="users.html"><svg class="glyph stroked male user "><use xlink:href="#stroked-male-user"/></svg>
                        Users</a></li>
                <li><a href="tables.html"><svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg>
                        Orders</a></li>



            </ul>

        </div>
        <!--/.sidebar-->

        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Products</h1>
                </div>
            </div>
            <!--/.row-->




            <div class="row">
                <div class="col-md-12">

                    <div class="panel panel-default chat">
                        <div class="panel-heading" id="accordion"><svg class="glyph stroked tag"><use xlink:href="#stroked-tag"/></svg> Add New product </div>

                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="" style="padding: 20px">

                                    <form class="" action="AddNewProduct" method="post" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <label>Product Name</label>
                                            <input class="form-control" placeholder="Product Name" name="productName">
                                        </div>

                                        <div class="form-group">
                                            <label>Product Description</label>
                                            <textarea class="form-control" rows="3" placeholder="Enter a product description to show to your customers" name="productDescription"></textarea>
                                        </div>

                                        <div class="col-md-12">

                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Price</label>
                                                    <div class="input-group">
                                                        <div class="input-group-addon">$</div>
                                                        <input type="number" class="form-control" id="exampleInputAmount" placeholder="item's price" name="productPrice">
                                                    </div>
                                                </div>
                                            </div>


                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Stock</label>
                                                    <input type="number" class="form-control" placeholder="stock" name="productStock">
                                                </div>
                                            </div>

                                        </div>


                                        <div class="col-md-12">
                                            <div class="col-md-6">
                                                <label>Category</label>
                                                <input class="form-control" placeholder="Category" name="productCategory">
                                            </div>

                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Upload an  image </label>
                                                    <input type="file" name="productImg" size="60" />
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <div class="text-center" style="margin-top: 20px;">
                                                <!-- <div class="form-group"> -->
                                                <button class="btn btn-primary" type="submit" name="button">Add Product</button>
                                                <!-- </div> -->

                                            </div>
                                        </div>

                                        <div class="text-center" style="margin-top: 50px;">
                                            <!-- <div class="form-group"> -->
                                            <div style="color: transparent">format</div>
                                            <!-- </div> -->

                                        </div>
                                        <input type="hidden" name="" value="">



                                    </form>

                                </div>

                            </div>

                        </div>
                    </div>

                </div>

            </div>

            <!--/.row-->
        </div>
        <!--/.main-->

        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/chart.min.js"></script>
        <script src="js/chart-data.js"></script>
        <script src="js/easypiechart.js"></script>
        <script src="js/easypiechart-data.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script src="js/bootstrap-table.js"></script>
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

