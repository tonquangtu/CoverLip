/**
 * Created by Dell on 18-May-17.
 */

$(document).ready(function () {
    var storageUrl = 'http://zmp3-photo-td.zadn.vn/thumb/240_135/';
    var lastVideoId = $('.load-more-box').attr('lastVideoId');
    var list = $('.lip-syncs');
    var loading = false;
    var footerHeight = $('.main-footer').height();

    loadMoreData();

    function loadMoreData() {

        $(window).scroll(function (scroll)
        {
            var windowHeight = $(window).height();
            var documentHeight = $(document).height();
            var scrollBarHeight = windowHeight * (windowHeight / documentHeight);
            var offset = documentHeight - $(window).scrollTop() - scrollBarHeight  - footerHeight;

            if (offset < 300) {
                if (!loading) {
                    fetchData(scroll);
                }
            }

        });
    }

    function fetchData(scroll) {

        console.log("Loading daata : last video id: " + lastVideoId);
        $.ajax({
            url: "http://localhost:8080/hot-lip-sync/fetchdata",
            type: "POST",
            data:  {
                type: "hot_lip_sync",
                lastVideoId: lastVideoId
            },
            dataType : "json",

            beforeSend: function(){
                loading = true;
                $(".load-more-box").css("display","block");
            },

            complete: function(){
                // console.log("complete");
                loading = false;
                $(".load-more-box").css("display", "none");

            },

            success: function(data){

                // console.log("success");
                if (data.message === "no_data") {
                    $(window).off(scroll);
                    $(".load-more-box").remove();
                }

                addMoreData(data.result);
            },
            error: function(){
                console.log("error");
            }
        });
    }

    function addMoreData(data) {

        if (data !== null && data.length > 0) {

            lastVideoId = data[data.length - 1].video.id;
            var stringHtml = '';
            $.each(data, function (i, item) {

                if (i % 3 === 0){
                    stringHtml += '<div class="row" style=" margin-left: 0px;">';
                }
                stringHtml +=
                    '<div class="col-md-4" style="padding-right:15px; padding-left:0;">' +
                        createLipSyncCard(item) +
                    '</div>';
                if (i % 3 === 2 || i === data.length - 1) {
                    stringHtml += '</div>';
                }
            });
            list.append(stringHtml);
        }

    }

    function createLipSyncCard(item) {
        return '<div class="one_card col-md-12">' +
            '<div class="header_card">' +
            '<div class="img-circle avatar_member">' +
            '<img class="img-responsive img-circle" src="' + item.video.account.avatarThumbnail + '" alt="' + item.video.account.fullname + '">' +
            '</div>' +
            '<div class="name_member">' +
            '<a href="/user/' + item.video.account.id + '"><h2>' + item.video.account.fullname + '</h2></a>' +
            '</div>' +
            '<div class="option_card" role="button">' +
            '<img src="../../../resources/icons/icon_more_vertical.svg" alt="" class="icon_more_vertical">' +

            '</div>' +
            '</div>' +
            '<div class="content_card">' +
            '<div class="media">' +
            '<li class="item_singer_video ">' +
            '<div class="singer_video_box">' +
            '<div class="thumbnail_video_box">' +
            '<a class="thumbnail_video" href="' + item.fullLink + '" title="' + item.videoName + '">' +
            '<span class="icon_play"></span>' +
            '<img src="' + storageUrl + item.video.videoThumbnailLink + '" alt="' + item.videoName + '" title="' + item.videoName + '">' +
            '<div class="background_one_card"></div>' +
            '</a>' +
            '</div>' +
            '<div class="info_singer_video_box">' +
            '<span>' + compactNameCover(item.videoName, 5) + '</span>' +
            '</div>' +
            '</div>' +
            '</li>' +
            '</div>' +
            '</div>' +
            '<div class="footer_card">' +
            '<ul class="interaction">' +
            '<li class="like">' +
            '<img src="../../../resources/icons/icon_like.svg" alt="" class="icon_react">&nbsp;' +
            '<span class="like_counter">' + item.video.numLike + '</span>' +
            '</li>' +
            '<li class="comment">' +
            '<a href="#">' +
            '<img src="../../../resources/icons/icon_comment.svg" alt="" class="icon_react">&nbsp;' + item.video.numComment +
            '</a>' +
            '</li>' +
            '<li class="view">' +
            '<span> <img src="../../../resources/icons/icon_view.svg" alt="" class="icon_react">&nbsp;' + item.video.numView + '</span>' +
            '</li>' +
            '</ul>' +
            '<div style="clear:both;"></div>' +
            '</div>' +
            '</div>';
    }

    function compactNameCover(string, numWord) {
        var arr = string.split(' ');
        if (numWord < arr.length) {
            arr = arr.slice(0, numWord);
            return arr.join(' ') + '...';
        } else {
            return string;
        }
    }

    // function printConsole() {
    //     console.log("windown scrollTop: " + $(window).scrollTop());
    //     console.log("window height: " + $(window).height());
    //     console.log("document height: " + $(document).height());
    //     console.log("footer height: " + footerHeight);
    //     console.log("scrollBarHeight: " + scrollBarHeight);
    //     console.log("offset: " + offset );
    //     console.log("---------------------------------------------------------------------------")
    // }
});
