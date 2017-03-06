<%-- 
    Document   : search
    Created on : Mar 5, 2017, 5:36:34 PM
    Author     : michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="panel panel-default sidebar-menu">

    <div class="panel-heading">
        <h3 class="panel-title">Search</h3>
    </div>

    <div class="panel-body">

        <form action="productslist" method="post" class="searchByMinMax">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search by name" name="query">
            </div>
            <div class="form-group">
                <div class="col-md-12" style="margin-bottom: 10px;">
                    <div class="input-group">
                        <span class="input-group-addon">Min</span>
                        <input type="number" class="form-control" aria-label="Amount (to the nearest dollar)" name="min">
                        <span class="input-group-addon">$</span>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-12" style="margin-bottom: 10px;">
                    <div class="input-group">
                        <span class="input-group-addon">Max</span>
                        <input type="number" class="form-control" aria-label="Amount (to the nearest dollar)" name="max">
                        <span class="input-group-addon">$</span>
                    </div>
                </div>
            </div>
            <input type="hidden" name="type" value="search">
            <p class="text-center">
                <button class="btn btn-primary" style="border-radius: 2px;"><i class="fa fa-search"></i> Search</button>
            </p>

        </form>
    </div>
</div>