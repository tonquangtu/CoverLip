$(function () {

    var win = $(window); // or $box parent container
    var adminName = $(".admin-name");
    var adminContent = $(".admin-content");

    win.on("click.Bst", function (event) {
        if (
            adminName.has(event.target).length == 0 //checks if descendants of $box was clicked
            && !adminName.is(event.target) //checks if the $box itself was clicked
        ) {
            adminContent.hide();
        } else {
            adminContent.slideToggle(200);
        }
    });

    $(".left-nav-content-main").on("click", function () {
        var speed = 300;
        var self = $(this);
        var v = $(".left-nav-content-main").not(this);
        var p = v.parent();
        if (self.parent().hasClass("list-active")) {
            self.next().slideUp(speed);
            self.parent().removeClass("list-active");
        } else {
            if (p.hasClass("list-active")) {
                v.next().slideUp();
                p.removeClass("list-active");
            }
            self.next().slideDown(speed);
            self.parent().addClass("list-active");
        }
    });

    $("input[name='select-all']").on("click", function () {
        var select = $("input[name='selected[]']");
        if ($(this).is(":checked")) {
            select.prop("checked", true);
            // select.parent().parent().css();
        } else {
            select.prop("checked", false);
        }
    });

    // var str = $("tbody").html();
    // for (var i = 0; i < 15; ++i) {
    //     $("tbody").append(str);
    // }
    var v = true;
    $(".toggle-open").on("click", function () {
        //alert("clicked");
        if (v) {
            $("#left-nav").css("width", "17.7%");
            $("#main-content").css("margin-left", "17.7%");
            v = false;
        } else {
            $("#left-nav").css("width", "0");
            $("#main-content").css("margin-left", "0");
            v = true;
        }
    });

    $("#logout").on("click", function() {
        $("#logoutForm").submit();
    });

});

function myFunction(x) {
    x.classList.toggle("change");
    $("#left-nav").hide(1000);
}