/**
 * Created by Khanh Nguyen on 23/5/2017.
 */
$(function () {

    $(".update-btn").prop("disabled", true);

    $("select").on("change", function() {
        var currentSelect = $(this);
        var trCurrent = currentSelect.parentsUntil("tr").parent();
        var btnCurrent = trCurrent.find('button');
        btnCurrent.prop("disabled", false);
    });

    $(".update-btn").on("click", function () {
        var id = $(this).attr("id");
        var trCurrent = $(this).parentsUntil("tr").parent();
        var selectCurrent = trCurrent.find('select');
        var status = selectCurrent.find('option:selected').attr('value');
        sendAjax(id, status);
        $(this).prop("disabled", true);
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
                console.log(data);
                alert("Thành công");
            },
            error: function (xhr, textStatus, error) {
                console.log("error status: " + xhr.status);
            }
        });
    }
});