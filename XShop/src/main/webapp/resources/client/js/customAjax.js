/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//------ Merna --------
$(document).on("click", ".eye-btn", function (event) {
//    var $form = $(this);
    $.post("getProductDetails", {productId: event.target.name}, function (response) {
        $(".items").html(response);
    });
    return false;
});
$(document).on("click", ".cart-btn", function (event) {
    $.post("addtocart", {productId: event.target.name}, function (response) {
        console.log(">>><<<<<" + response);
        if(response !== "false")
        $("#items-number").text(response);
    });
    return false;
});

$(document).on("click", ".qtyrightplus", function (event) {
    console.log("Inside the ajax method" + event.target.name);
    
    $.post("updatecartitemquantity", {productId:event.target.name , action:"increase"}, function (response) {
        if(response !== "false")
         $("#basketDiv").html(response);
    });
    return false;
});

$(document).on("click",".qtyrightminus", function (event) { 
    if($("#qty-input").val() > 1){
        $.post("updatecartitemquantity", {productId:event.target.name , action:"decrease"}, function (response) {
            if(response !== "false")
             $("#basketDiv").html(response);
        });
    }
    return false;
});

$(document).on("click",".trash-anchor", function (event) {
     console.log(")))))) value :"+$("#qty-input").val());
     console.log(">>>>>>>>> trash" + event.target.name);
    $.post("removefromcart", {productId: event.target.name,qty:$("#qty-input").val()}, function (response) {
        if(response !== "false"){
            $("#basketDiv").html(response);
            $("#items-number").text($("#items-number").html()-1);
        }
    });
    return false;
});
//------ End Merna --------

//------ Mikke --------
//------ End Mikke --------

//------ Markoz --------
$(document).on("click", ".searchByCategory", function (event) {
//    var $form = $(this);
    $(".searchByCategory").addClass("active");
    $(".allCategories").removeClass("active");
    
    $.post("productslist", {categoryName: event.target.name, type: "category"}, function (response) {
        $(".items").html(response);

    });
    return false;
});
$(document).on("click", ".allCategories", function (event) {
//    var $form = $(this);
    $.post("productslist", {type: event.target.name}, function (response) {
        $(".items").html(response);
        $(".searchByCategory").removeClass("active");
        $(".allCategories").addClass("active");
    });
    return false;
});

$(document).on("submit", ".searchByMinMax", function (event) {
    var $form = $(this);
    $.post($form.attr("action"), $form.serialize(), function (response) {
        $(".items").html(response);
    });
    return false;
});
//------ End Markoz --------

//------ Mustafa --------
//------ End Mustafa --------
