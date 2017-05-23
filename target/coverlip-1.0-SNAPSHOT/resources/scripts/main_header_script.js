/**
 * Created by Dell on 18-May-17.
 */

$(document).ready(function () {

    var urlServer = "http://localhost:8080/hot-cover/json";
    var status = true;
    var limit = 5;
    var loading_search = $('#loading_search');
    loading_search.hide();
    var string='';
    $('#txtSearch').click(function () {
        if(status){
            $.ajax({
                type:"GET",
                url:urlServer,
                data:{limit:limit},
                beforeSend:function(){
                    loading_search.show();
                },
                success:function(data){
                    $.each(data,function(i, item){
                        string+= getOneSuggess(item,i);
                    });
                    $('#ulTopKeyWord').append(string);
                    loading_search.remove();
                    status=false;
                },
                error:function(){

                },
                complete:function(){
                    setTimeout(function () {
                        loading_search.hide();
                    },5000);
                }
            });
        }
        var suggestionContent = $('#divSuggestion');
        suggestionContent.removeClass("hideShowCase");

    });

    function getOneSuggess(item, i){
        return '<li id="li'+i+'" class="top-search" rel="'+i+'">' +
            '<a class="tkw" href="'+item.fullLink+'">' +
            '<span class="top-number top-number-'+(i+1)+'">'+(i+1)+'</span>' +
            '<span>'+item.videoName+'</span>' +
            '</a>' +
            '</li>';
    }
    $(document).click(function (event) {
        if (!$(event.target).closest('#txtSearch').length) {
            if ($('#divSuggestion').is(":visible")) {
                $('#divSuggestion').addClass("hideShowCase");
            }
        }
    })


});