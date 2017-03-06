/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//------ Merna --------
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