$(document).ready(function () {

    var buttonFollow = $("#btn-follow");
    var urlFollowIdol = "/follow_idol"
    var status = 1;
    buttonFollow.click(function () {
        var idolId = $(this).attr("accountFollowId");
        var statusFollow = $(this).attr("statusFollow");
        //alert("trung");
        if (status === 1){
            ajaxFollowIdol(idolId, statusFollow, $(this));
        }
    });

    function ajaxFollowIdol(idolId, statusFollow, button) {
        $.ajax({
            type: "get",
            url: urlFollowIdol,
            data: {idolId: idolId, statusFollow: statusFollow},
            before: function () {
                status = 0;
            },
            success: function (data) {
                status = 1;
                if (data === 1) {
                    if (statusFollow === "0") {
                        button.attr("statusFollow", "1");
                        follow(button)
                    }
                    else {
                        button.attr("statusFollow", "0");
                        unFollow(button);
                    }
                }
                else {
                    // window.location = "/WEB-INF/views/commonpage/error_page.jsp";
                }
            }
        })
    }

    function follow(button) {
        button.text("Đã theo dõi");
        button.css("color", "#00c853");
        button.css("background-color", "#ffffff");
        button.css("border-color", "#00c853");
    }

    function unFollow(button) {
        button.text("Theo dõi Idol");
        button.css("color", "#ffffff");
        button.css("background-color", "#00c853");
        button.css("border-color", "#00c853");
    }
});/**
 * Created by mrgnu on 29/05/2017.
 */
