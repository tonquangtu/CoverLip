/**
 * Created by nguyenthanhtung on 05/05/2017.
 */
$(document).ready(function(){
    var width = $(".avatar").clientWidth;
    // alert(width);
    $(".avatar").css("height",width);

    $( "#calendar" ).datepicker();

});