/**
 * Created by Dell on 21-Mar-17.
 */

$(document).ready(function(){

    var videoId = $('.video-box').attr('videoId');

    $("#btn-view-more-suggestion").click(function(){

        var btnViewMoreSuggestion = $(this);
        var span = $(this).children("span");
        var listSuggestion2 = $(".list-suggestion2");

        listSuggestion2.slideToggle("slow", function () {

            if (listSuggestion2.is(':visible')) {
                span.text("Rút gọn");
                btnViewMoreSuggestion.removeClass("btn-view-more-suggestion");
                btnViewMoreSuggestion.addClass("btn-collapsed-suggestion");

            } else {
                span.text("Xem thêm gợi ý");
                btnViewMoreSuggestion.addClass("btn-view-more-suggestion");
                btnViewMoreSuggestion.removeClass("btn-collapsed-suggestion");
            }
        });

    });

    increaseNumView();
    
    
    function increaseNumView() {
        console.log("video id: " + videoId);
        $.ajax({

            url: "/video/update-view",
            type: "GET",
            data : {

                videoId: videoId,
            },
            dataType : "json",
            complete : function () {

            },
            success : function (data) {
               console.log("success: " + data.success);

            },
            error : function () {
                console.log("error while update num view");
            }
        });
    }


});