$(document).ready(function () {

    $('body').on('click', '.option_card', function () {
        $('.main_action').remove();
        if($(this).hasClass('selected')){
            $(this).removeClass('selected');
            $(this).children('.main_action').remove();
        }else{
            var string = '<div class="main_action">' +
                '<ul>' +
                '<li>' +
                '<span class="report" role="button">' +
                '<i class="glyphicon glyphicon-remove"></i> Báo cáo' +
                '</span>' +
                '</li>' +
                '</ul>' +
                '</div>';
            $(this).append(string);
            $(this).addClass('selected');
        }
    });
    //Set default when click outer
    $(document).click(function (e) {
        var container = $(".option_card");

        if (!container.is(e.target) && container.has(e.target).length === 0) {
            $('.main_action').remove();
            container.removeClass('selected');
        }
    });
});