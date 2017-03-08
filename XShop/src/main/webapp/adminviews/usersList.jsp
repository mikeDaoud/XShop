<%-- 
    Document   : usersList
    Created on : Mar 4, 2017, 5:20:30 PM
    Author     : Merna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
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
        <c:set var="usersList" value="${requestScope.users_arraylist}"></c:set>
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
                    <li><a href="GetAllProducts"><svg class="glyph stroked tag"><use xlink:href="#stroked-tag"/></svg>
                            Products</a></li>
                    <li class="active"><a href="GetAllUsers"><svg class="glyph stroked male user "><use xlink:href="#stroked-male-user"/></svg>
                            Users</a></li>
                    <li><a href="GetAllOrders"><svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg>
                            Orders</a></li>

                </ul>

            </div>
            <!--/.sidebar-->
            <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">

                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Users</h1>
                    </div>
                </div>
                <!--/.row-->




                <div class="row">
                    <div class="col-md-12">

                        <div class="panel panel-default chat">
                            <div class="panel-heading" id="accordion"><svg class="glyph stroked male user "><use xlink:href="#stroked-male-user"/></svg> Registered Users </div>

                            <div class="col-md-12">
                                <div class="panel panel-default">
                                    <div class="">
                                        <table data-toggle="table" >
                                            <thead>
                                                <tr>
                                                    <th data-field="id" data-align="center">User ID</th>
                                                    <th data-field="name">Name</th>
                                                    <th data-field="price">Email</th>
                                                    
                                                    <th data-field="editbtn"></th>
                                                </tr>
                                            </thead>
                                        <c:forEach var="user" items="${usersList}">
                                            <tr>
                                            <form>
                                                <td><c:out value="${user.id}"></c:out></td>
                                                <td><c:out value="${user.name}"></c:out></td>
                                                <td><c:out value="${user.email}"></c:out></td>
                                                    
                                                    <td><a href="GetUserDetails?userId=${user.id}" name="userId" value="${user.id}" class="btn btn-primary editbtn">View</a></td>
                                            </form>
                                            </tr>
                                        </c:forEach>
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
