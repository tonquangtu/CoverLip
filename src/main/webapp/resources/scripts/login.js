/**
 * Created by Khanh Nguyen on 9/5/2017.
 */
$(function() {
    var notifyDisabledCookie = "Bạn phải bật cookie của trình duyệt để đăng nhập!";

    $("#loginForm").on("submit", function () {
        if (navigator.cookieEnabled) {
            return true;
        } else {
            alert(notifyDisabledCookie);
            return false;
        }
    });

    if (!navigator.cookieEnabled) {
        $(".error-login-container").css("display", "block");
        $("#error-login-content").text(notifyDisabledCookie);
    }

    $(".error-login").delay(1000).fadeOut(1000);

});