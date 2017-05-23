/**
 * Created by Khanh Nguyen on 23/5/2017.
 */
$(function () {
    $(".update-btn").on("click", function () {
        var id = $(this).attr("id");
        var trCurrent = $(this).parentsUntil("tr").parent();
        var selectCurrent = trCurrent.find('select');
        var status = selectCurrent.find('option:selected').attr('value');
        sendAjax(id, status);
    });

    function sendAjax(id, status) {
        var sendData = {
            accountId: id,
            statusAccount: status
        };
        $.ajax({
            url: "/admin/account/update",
            type: 'get',
            data: sendData,
            success: function (data, textStatus, xhr) {
                console.log("success status: " + xhr.status);
            },
            error: function (xhr, textStatus, error) {
                console.log("error status: " + xhr.status);
            }
        });
    }
});