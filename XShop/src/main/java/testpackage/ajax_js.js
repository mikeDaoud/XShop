/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//.someform - > class name
// rediredt - > servlet url path
// 

$(document).on("click", ".someform", function (event) {
//    var $form = $(this);
    $.post("redirect", {name:event.target.name}, function (response) {
        $("#demo").html(response);
    });
    return false;
});


$(document).on("click", ".someform2", function (event) {
    var $form = $(this);
    $.post("redirect", {name:event.target.id}, function (response) {
        $("#demo").html(response);
    });
    return false;
});
