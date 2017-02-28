<%-- 
    Document   : Login
    Created on : Feb 28, 2017, 1:18:21 PM
    Author     : Merna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Login</title>
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">Ï
        <link href="resources/css/custom.css" rel="stylesheet">
        <link href="resources/css/font-awesome.css" rel="stylesheet">
    </head>
    <body>
        <!-- ******** start top Bar ******* -->
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <a class="navbar-brand" href="#">Brand</a>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><font size="4">Login</font></a>
                    </li>
                    <li><a href="#"><i class="fa fa-shopping-cart fa-2x" aria-hidden="true"></i><span class="badge">0</span></a>
                    </li>s
                    <li><a href="#"><i class="fa fa-bars fa-2x" aria-hidden="true"></i></a>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- ******** end top Bar ******* -->

        <div id="content">
            <div class="box">
                <section class="page-section row col-split-2">
                    <!-- ***** create new account ***** -->
                    <div class="col-xs-12 col-sm-6 col-md-4 col-md-offset-1" >
                        <h2>Create an account</h2>
                       
                        <small>* required fields</small>
                        <form action="signup" method="post">
                            <div class="form-group">
                                <label for="name">Name *</label>
                                <input name="name" type="text" class="form-control" id="name" placeholder="Ahmed Mohamed" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email *</label>
                                <input name="email" type="email" class="form-control" id="email" placeholder="ahmed_mohamed@gmail.com" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password *</label>
                                <input name="password" type="password" class="form-control" id="password" placeholder="a memorable password" required>
                            </div>
                            
                            <div class="form-group">
                                <label for="password">Confirm Password *</label>
                                <input name="repeatedPassword" type="password" class="form-control" id="repeatedPassword" placeholder="repeat the password" required>
                            </div>
                            
                            <div class="form-group" >
                                <label for="job">Job</label>
                                <input name="job" type="text" class="form-control" id="job" placeholder="Teacher">
                            </div>
                            <div class="form-group" >
                                <label for="address">Address</label>
                                <input name="address" type="text" class="form-control" id="address" placeholder="El zohoor city, Heliopolis">
                            </div>
                            <div class="form-group" >
                                <label for="date">Date of Birth</label>
                                <input name="dOB" type="date" class="form-control" id="date">
                            </div>
                            <!-- <div class="form-group"> -->
                            <legend>What are your interests ?</legend>

                            <div class="col-md-6">
                                <input type="checkbox" name="interest" value="clothes" /> Clothes<br/>
                                <input type="checkbox" name="interest" value="electronics"/> Electronics<br/>
                                <input type="checkbox" name="interest" value="watches"/> Watches<br />
                            </div>
                            <div class="col-md-6">
                                <input type="checkbox" name="interest" value="clothes"/> Clothes<br/>
                                <input type="checkbox" name="interest" value="electronics"/> Electronics<br/>
                                <input type="checkbox" name="interest" value="watches"/> Watches<br />
                            </div>

                            <div class="col-md-12 text-center">
                                <div class="cgroup">
                                    <button type="submit" class="btn btn-primary">Register</button>
                                </div>
                            </div>

                        </form>
                    </div>
                    <!-- ***** end create new account ***** -->

                    <!-- ***** login ***** -->
                    <div class="col-xs-12 col-sm-6 col-md-4 col-md-offset-2">
                        <h2>Login</h2>
                        <hr>
                        <form action="signin" method="post">
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input name="email" type="email" class="form-control" id="email" placeholder="your_mail@gmail.com">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input name="password" type="password" class="form-control" id="password" placeholder="your password">
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">Log in</button>
                            </div>
                        </form>
                    </div>
                    <!-- ***** end login ***** -->
                </section>
            </div>
        </div>
    </body>
</body>
</html>
