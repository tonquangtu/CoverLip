/**
 * Created by nguyenthanhtung on 25/04/2017.
 */
$(document).ready(function () {
    slide('demo_first_0', 'next_first', 'prev_first', 1000);
    slide('demo_first_1', 'next_first_1', 'prev_first_1', 1200);
    slide('demo_first_2', 'next_first_2', 'prev_first_2', 1400);
    slide('demo_first_3', 'next_first_3', 'prev_first_3', 1600);

    slide('demo_second_0', 'next_second', 'prev_second', 1000);
    slide('demo_second_1', 'next_second_1', 'prev_second_1', 1200);
    slide('demo_second_2', 'next_second_2', 'prev_second_2', 1400);
    slide('demo_second_3', 'next_second_3', 'prev_second_3', 1600);
    // $('.caroufredsel_wrapper').height($('.caroufredsel_wrapper').height());
    $('.next_first').on('click', function () {
        $('.next_first_1').click();
    });
    $('.next_first_1').on('click', function () {
        $('.next_first_2').click();
    });
    $('.next_first_2').on('click', function () {
        $('.next_first_3').click();
    });

    $('.next_second').on('click', function () {
        $('.next_second_1').click();
    });
    $('.next_second_1').on('click', function () {
        $('.next_second_2').click();
    });
    $('.next_second_2').on('click', function () {
        $('.next_second_3').click();
    });

    $('.prev_first').on('click', function () {
        $('.prev_first_1').click();
    });
    $('.prev_first_1').on('click', function () {
        $('.prev_first_2').click();
    });
    $('.prev_first_2').on('click', function () {
        $('.prev_first_3').click();
    });

    $('.prev_second').on('click', function () {
        $('.prev_second_1').click();
    });
    $('.prev_second_1').on('click', function () {
        $('.prev_second_2').click();
    });
    $('.prev_second_2').on('click', function () {
        $('.prev_second_3').click();
    });
});
function slide(id, classNext, classPrev, duration) {
    $('#' + id).carouFredSel({
        auto: false,
        prev: '.' + classPrev,
        next: '.' + classNext,
        // // pagination: "#pager2",
        mousewheel: true,
        swipe: {
            onMouse: true,
            onTouch: true
        },
        items: 2,
        direction: "up",
        scroll: {
            items: 2,
            effect: "easeOutBounce",
            duration: duration,
            pauseOnHover: true
        }
    });
}