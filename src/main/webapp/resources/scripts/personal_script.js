/**
 * Created by nguyenthanhtung on 05/05/2017.
 */
$(document).ready(function(){
    var width = $(".avatar").clientWidth;
    // alert(width);
    $(".avatar").css("height",width);

    $( "#calendar" ).datepicker();
    $( "#calendar" ).datepicker( "option", "dateFormat", "dd/mm/yy" );
    $('#choose_file').on('change',function(){
        var imgPath = $(this).val();
        var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
        var avatar = $('.avatar_person');
        if (extn === "gif" || extn === "png" || extn === "jpg" || extn === "jpeg") {
            if (typeof(FileReader) !== "undefined") {

                var reader = new FileReader();
                reader.onload = function(e) {
                    avatar.attr('src',e.target.result);
                };
                reader.readAsDataURL($(this)[0].files[0]);

            } else {
                alert("This browser does not support FileReader.");
            }
        } else {
            alert("Hãy lựa chọn ảnh để upload");
        }
    });

    var type = $('.menu').attr('type');
    var atag= $('.menu a');
    atag.removeClass('selected');
    $.each(atag, function(){
        var uri = $(this).attr('href');
        if(type===uri.substring(uri.lastIndexOf('/')+1, uri.length)){
            $(this).addClass('selected');
            return false;
        }
    });
    // validateUpload();

    function validateUpload(){
        $('#submit').attr("disabled","disabled");
        $('#choose_video').on('change',function(){
            var videoPath = $(this).val();
            var extn = videoPath.substring(videoPath.lastIndexOf('.') + 1).toLowerCase();
            if (extn === "webm" || extn === "mp4" || extn === "flv" || extn === "mkv" || extn==="3gp") {
                $('#submit').prop("disabled",false);
            } else {
                $('#submit').attr("disabled","disabled");
                alert("Hãy lựa chọn video để upload");
            }
        });

        $('#submit').on('click',function(){
           if($('input[name="title"]').val().trim()==='' || $('input[name="description"]').val().trim()===''){
               alert("Hãy điền đầy đủ thông tin");
               return false;
           }else{
               $('form').submit();
           }
        });
    }


});