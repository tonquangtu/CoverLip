/**
 * Created by nguyenthanhtung on 17/05/2017.
 */
$(document).ready(function () {
    var storageUrl = 'http://zmp3-photo-td.zadn.vn/thumb/240_135/';
    var urlServer = 'http://localhost:8080/user';
    var cardColor = ["#f44336", "#e91e63", "#9c27b0", "#673ab7", "#3f51b5", "#2196f3", "#03a9f4",
        "#009688", "#4caf50", "#8bc34a", "#cddc39", "#ffeb3b", "#ffc107", "#ff9800", "#795548", "#9e9e9e"];
    var loading = $('#loading');
    loading.hide();
    var type = loading.attr('type');
    if (type === 'cover'){
        loadMoreVideo();
    } else if (type === 'lipsync'){
        loadMoreVideo();
    } else if (type === 'playlist'){
        loadMorePlaylist();
    } else {
        loadMoreIdolFollowing();
    }


    function loadMoreVideo() {

        var accountId = loading.attr('accountid');
        var currentItemId = loading.attr('currentVideoId');
        var limit = 6;

        var status = true;
        var addItem = $('#addItem');

        ajaxLoadMore(currentItemId, limit,accountId, type, addItem, status, oneCard);
    }

    function loadMorePlaylist(){
        var accountId = loading.attr('accountid');
        var currentPlaylistId = loading.attr('currentPlaylistId');
        var limit = 4;
        var status = true;
        var addItem = $('#addItem');

        ajaxLoadMore(currentPlaylistId,limit,accountId,type,addItem,status,onePlaylist);
    }

    function loadMoreIdolFollowing(){
        var accountId = loading.attr('accountid');
        var currentItemId = loading.attr('currentItemId');
        var limit = 6;
        var status = true;
        var addItem = $('#addItem');
        ajaxLoadMore(currentItemId, limit, accountId, type, addItem, status, oneIdolFollowing);
    }

    function ajaxLoadMore(currentItemId, limit, accountId, type, addItem, status, oneItem){
        $(window).scroll(function (tt) {
            var height = heightToLoadMore();
            if (height < 300 && status) {
                $.ajax({
                    type: 'get',
                    url: urlServer,
                    data: {currentItemId: currentItemId, limit: limit, accountId: accountId, type: type},
                    beforeSend: function () {
                        status = false;
                        loading.show();
                    },
                    success: function (data) {
                        if (data !== null && data.length >0) {
                            currentItemId = data[data.length - 1].id;
                            var string = '';

                            $.each(data, function (i, item) {
                                if (i % 3 === 0) {
                                    string += '<div class = "row" style = "margin-left:0; margin-right: -20px;" >';
                                }
                                string += '<div class="col-md-4" style="padding-right:20px; padding-left:0">';
                                string += oneItem(item);
                                string += '</div>';
                                if (i % 3 === 2 || (i === data.length - 1)) {
                                    string += '</div>';
                                }
                            });
                            addItem.append(string);
                            if(data.length<limit){
                                loading.remove();
                                $(window).off(tt);
                            }
                        } else {
                            loading.remove();
                            $(window).off(tt);
                        }

                    },
                    complete: function () {
                        status = true;
                        loading.hide();
                    }
                });
            }
        });
    }

    function heightToLoadMore(){
        var windowHeight = $(window).height();
        var documentHeight = $(document).height();
        var scrollBarHeight = windowHeight * (windowHeight / documentHeight);
        var offset = documentHeight - $(window).scrollTop() - scrollBarHeight  - $('footer').height();

        return offset;
    }
    function oneCard(item) {
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
            '<a class="thumbnail_video" href="#" title="' + item.videoName + '">' +
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

    function onePlaylist(itemPlaylist) {
        var string = '';
        var rand = parseInt(Math.random()*cardColor.length);
        string += '<div class="card_playlist" style="background-color:'+cardColor[rand]+' ">' +
            '<img src="http://' + itemPlaylist.playlistThumbnaiLink + '" class="avatar_playlist">' +
            '<ul class="avatar_cover_list">';
        $.each(itemPlaylist.items, function (i, item) {
            string += '<li><img src="'+storageUrl+item.item.video.videoThumbnailLink+'" class="img-circle img-responsive"></li>';
        });
        string += '</ul>' +
            '<div class="info_card_playlist">' +
            '<p><strong>' + itemPlaylist.numView + ' view</strong></p>' +
            '<h5><strong>' + itemPlaylist.playlistName + '</strong></h5>' +
            '<div class="member_post">' +
            '<img src="/resources/storage/image/thumbnail/owner_thumbnail/avatar1.jpg" class="img-circle avatar_member">' +
            '<p>' + itemPlaylist.account.fullname + '</p>' +
            '</div>' +
            '</div>' +
            '</div>';
        return string;
    }

    function oneIdolFollowing(item){
        return '<div class="one_member text-center">'+
            '<a href="">'+
            '<div class="avatar">'+
            '<img src="'+item.account.avatarThumbnail+'" alt="'+item.account.fullname+'" class="img-responsive img-circle">'+
            '</div>'+
            '<div class="name_of_member">'+
            '<p>'+item.account.fullname+'</p>'+
            '</div>'+
            '</a>'+
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


});