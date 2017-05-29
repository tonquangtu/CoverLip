/**
 * Created by Dell on 18-May-17.
 */

$(document).ready(function () {
    setActiveItemMenu();
    var urlServerCover = "/hot-cover/json";
    var urlServerLipSync = "/hot-lip-sync/json";
    var status = true;
    var limit = 5;
    var loading_search = $('#loading_search');
    var active = $('.super-menu').children('.active');
    var typeHot = active.attr('href').indexOf('cover')!==-1?1:2;
    loading_search.hide();
    var string = '';
    $('#txtSearch').click(function () {
        if (status) {
            $.ajax({
                type: "GET",
                url: typeHot===1?urlServerCover:urlServerLipSync,
                data: {limit: limit},
                beforeSend: function () {
                    loading_search.show();
                },
                success: function (data) {
                    $.each(data, function (i, item) {
                        string += getOneSuggess(item, i);
                    });
                    $('#ulTopKeyWord').append(string);
                    loading_search.remove();
                    status = false;
                },
                error: function () {

                },
                complete: function () {
                    setTimeout(function () {
                        loading_search.hide();
                    }, 5000);
                }
            });
        }
        var suggestionContent = $('#divSuggestion');
        suggestionContent.removeClass("hideShowCase");

    });

    function getOneSuggess(item, i) {
        return '<li id="li' + i + '" class="top-search" rel="' + i + '">' +
            '<a class="tkw" href="' + item.fullLink + '">' +
            '<span class="top-number top-number-' + (i + 1) + '">' + (i + 1) + '</span>' +
            '<span>' + item.videoName + '</span>' +
            '</a>' +
            '</li>';
    }

    $(document).click(function (event) {
        if (!$(event.target).closest('#txtSearch').length) {
            if ($('#divSuggestion').is(":visible")) {
                $('#divSuggestion').addClass("hideShowCase");
            }
        }
    });

    getResultSearch();
    function getResultSearch() {
        var distance = 0;
        var a;
        var startTime;
        $('#txtSearch').on('keyup', function () {
            clearInterval(a);
            startTime = new Date();
            a = setInterval(function () {
                distance = new Date() - startTime;
                if (distance >= 1000) {
                    // console.log("vl");
                    clearInterval(a);
                    if($('#txtSearch').val().trim()!==''){
                            sendAjax($('#txtSearch').val().trim(),6, typeHot);
                    }else{
                        $('#contentSuggestion').show();
                        $('#result_search').hide();
                    }
                }
            }, 500);
        });
    }

    function sendAjax(searchString, limit, type) {
        $.ajax({
            type: "GET",
            url: "/search",
            data:{searchString: searchString, limit:limit, type:type},
            beforeSend:function(){
                $('#best_search').text("");
                $('#list_singer_table').text("");
                $('#list_video_table').text("");
            },
            success:function(data){
                var string = '';
                var string1 = '';
                var string2='';
                if(data.bestSearchType===1){
                    string = getOneItem(1, data.bestVideoSearch);
                }else{
                    string = getOneItem(2, data.bestAccountSearch);
                }
                $('#best_search').append(string);
                $.each(data.videoSearchList, function(i, item){
                   string1+=getOneItem(1,item);
                });
                $.each(data.accountSearchList,function(j,item){
                    string2+=getOneItem(2,item);
                });
                $('#contentSuggestion').hide();
                $('#list_video_table').append(string1);
                $('#list_singer_table').append(string2);
                $('#result_search').show();
            },
            error:function(){

            }
        });
    }
    function getOneItem(type, item){
        if(type===1)
        return '<li class="item">'+
            '<div class="one_item">'+
            '<a class="image_item" href="">'+
            '<img class="thumb" src="'+item.video.videoThumbnailLink+'" alt="'+item.videoName+'" width="38.5" height="38.5">'+
            '</a>'+
            '<div class="info-table">'+
            '<h4 class="name_item">'+
            '<a href="'+item.fullLink+'" title="'+item.videoName+'">'+item.videoName+'</a>'+
            '</h4>'+
            '<div class="member_post">'+
            '<a href="/account/' + item.video.account.id+'" title="Nghệ sĩ '+item.video.account.fullname+'">'+
            '<img src="'+item.video.account.avatarThumbnail+'" class="img-circle avatar_member">'+
            '<p>'+item.video.account.fullname+'</p>'+
            '</a>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '</li>';
        else if(type===2){
            return '<li class="item">'+
                '<div class="one_item">'+
                '<a class="image_item" href="/account/'+item.id+'">'+
                '<img src="'+item.avatarThumbnail+'" alt="'+item.fullname+'" class="img-responsive img-circle" width="38.5" height="38.5">'+
                '</a>'+
                '<div class="info-table">'+
                '<p class="name_item" style="margin-bottom: 0;line-height: 38px;">'+
                '<a href="" title="'+item.fullname+'">'+item.fullname+'</a>'+
            '</p>'+
            '</div>'+
            '</div>'+
            '</li>';
        }
    }
    function setActiveItemMenu(){
        var url = window.location.href;
        var type = url.substring(url.lastIndexOf('/'), url.length);
        var allItem = $('#menuTop').children('li');
        $.each(allItem, function(i, item){
            var temp = $(this).children('a');
            if(temp.attr('href')===type){
                temp.addClass('active');
            }else{
                temp.removeClass('active');
            }
        });
    }
});