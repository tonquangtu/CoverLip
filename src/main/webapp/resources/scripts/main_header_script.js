/**
 * Created by Dell on 18-May-17.
 */

$(document).ready(function () {

    $('#txtSearch').click(function () {

        var suggestionContent = $('#divSuggestion');
        // if (suggestionContent.is(':hidden')) {
        //     suggestionContent.removeClass("hideShowCase");
        // }
        suggestionContent.removeClass("hideShowCase");

    });

    $(document).click(function(event) {
        if(!$(event.target).closest('#txtSearch').length) {
            if($('#divSuggestion').is(":visible")) {
                $('#divSuggestion').addClass("hideShowCase");
            }
        }
    })


});