$(document).ready(function () {
    
    var buttonFollow = $(".btn-follow");
    var urlFollowIdol = "/follow_idol"
    var status = 1;
    buttonFollow.click(function () {
        var idolId = $(this).attr("topIdolId");
        var statusFollow = $(this).attr("statusFollow");
        var numFollow = $(this).parent().children(".idol_info").children("p").children("span");
        if (status === 1){
            ajaxFollowIdol(idolId, statusFollow, $(this), numFollow);
        }
    });
    
    function ajaxFollowIdol(idolId, statusFollow, button, numFollow) {
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
                        follow(button, numFollow)

                    }
                    else {
                        button.attr("statusFollow", "0");
                        unFollow(button, numFollow);
                    }
                }
                else {
                    // window.location = "/WEB-INF/views/commonpage/error_page.jsp";
                }

            }
        })

    }

    function follow(button, numFollow) {
        button.text("Đã theo dõi");
        button.css("color", "#4cae4c");
        button.css("background-color", "#ffffff");
        button.css("border-color", "#4cae4c");
        var text = numFollow.text();
        numFollow.text(parseInt(text) + 1);
    }

    function unFollow(button, numFollow) {
        button.text("Theo dõi");
        button.css("color", "#ffffff");
        button.css("background-color", "#5cb85c");
        button.css("border-color", "#4cae4c");
        var text = numFollow.text()
        if (text > 0){
            numFollow.text(text - 1);
        }

    }
});