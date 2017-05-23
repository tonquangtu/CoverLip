$(document).ready(function () {
    
    var buttonFollow = $(".btn-follow");
    var urlFollowIdol = "http://localhost:8080/follow_idol";
    buttonFollow.click(function () {
        var idolId = $(this).attr("topIdolId");
        var acoundId = "3";
        var statusFollow = $(this).attr("statusFollow");
        var numFollow = $(this).parent().children(".idol_info").children("p").children("span");
        ajaxFollowIdol(acoundId, idolId, statusFollow, $(this), numFollow);
    });
    
    function ajaxFollowIdol(acoundId, idolId, statusFollow, button, numFollow) {
        $.ajax({
            type: "post",
            url: urlFollowIdol,
            data: {acoundId: acoundId, idolId: idolId, statusFollow: statusFollow},
            success: function (data) {
                if (data === 1){
                    if (statusFollow === "0"){
                        button.attr("statusFollow", "1");
                        follow(button, numFollow)

                    }
                    else{
                        button.attr("statusFollow", "0");
                        unFollow(button, numFollow);
                    }
                }
                else{
                    window.location = "/WEB-INF/views/commonpage/error_page.jsp";
                }

            }
        })

    }

    function follow(button, numFollow) {
        button.text("Đã theo dõi");
        button.css("color", "#4cae4c");
        button.css("background-color", "#ffffff");
        button.css("boder-color", "#4cae4c");
        var text = numFollow.text();
        numFollow.text(parseInt(text) + 1);
    }

    function unFollow(button, numFollow) {
        button.text("Theo dõi");
        button.css("color", "#ffffff");
        button.css("background-color", "#5cb85c");
        button.css("boder-color", "#4cae4c");
        var text = numFollow.text()
        if (text > 0){
            numFollow.text(text - 1);
        }

    }
});