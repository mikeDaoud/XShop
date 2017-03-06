/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//------ Merna --------
$(document).on("click", ".eye-btn", function (event) {
//    var $form = $(this);
    $.post("getProductDetails", {productId:event.target.name}, function (response) {
        $(".items").html(response);
    });
    return false;
});
//------ End Merna --------

//------ Mikke --------
//------ End Mikke --------

//------ Markoz --------
//------ End Markoz --------

//------ Mustafa --------
//------ End Mustafa --------