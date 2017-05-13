/**
 * Created by Dell on 21-Mar-17.
 */

$(document).ready(function(){
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
});