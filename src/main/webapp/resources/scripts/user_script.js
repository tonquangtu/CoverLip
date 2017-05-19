/**
 * Created by nguyenthanhtung on 17/05/2017.
 */
$(document).ready(function () {
    var storageUrl = 'http://zmp3-photo-td.zadn.vn/thumb/240_135/';
    var urlServer = 'http://localhost:8080/user';
    var loading = $('#loading');
    var type = loading.attr('type');
    if (type === 'cover')
        onlyItemSelected('.cover_history', '.lipsync_history', '.playlist_history');
    else if (type === 'lipsync')
        onlyItemSelected('.lipsync_history', '.cover_history', '.playlist_history');
    else if (type === 'playlist')
        onlyItemSelected('.playlist_history', '.cover_history', '.lipsync_history');
    else {
        onlyItemSelected('.cover_history', '.lipsync_history', '.playlist_history');
    }
    loadMoreVideo();

    function loadMoreVideo() {

        var accountId = loading.attr('accountid');
        var currentVideoId = loading.attr('currentVideoId');
        // var window = $(window);
        var limit = 6;

        var status = true;
        var addVideo = $('#addVideo');
        $(window).scroll(function (tt) {
            if ($(this).scrollTop() / ($(document).height() - $(this).scrollTop()) > 0.8 && status) {
                $.ajax({
                    type: 'get',
                    url: urlServer,
                    data: {currentVideoId: currentVideoId, limit: limit, accountId: accountId, type: type},
                    beforeSend: function () {
                        status = false;
                    },
                    success: function (data) {
                        if (data !== null && data.length > 0) {
                            currentVideoId = data[data.length - 1].video.id;
                            var string = '';

                            $.each(data, function (i, item) {
                                if (i % 3 === 0) {
                                    string += '<div class = "row" style = "margin-left:0; margin-right: -20px;" >';
                                }
                                string += '<div class="col-md-4" style="padding-right:20px; padding-left:0">';
                                string += oneCard(item);
                                string += '</div>';
                                if (i % 3 === 2 || ((i === data.length - 1) && (i % 3 !== 2))) {
                                    string += '</div>';
                                }
                            });
                            addVideo.append(string);
                        } else {
                            loading.remove();
                            $(window).off(tt);
                        }

                    },
                    complete: function () {
                        status = true;
                    }
                });
            }
        });
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
            '<a class="thumbnail_video" href="#" title="' + item.coverName + '">' +
            '<span class="icon_play"></span>' +
            '<img src="' + storageUrl + item.video.videoThumbnailLink + '" alt="' + item.coverName + '" title="' + item.coverName + '">' +
            '<div class="background_one_card"></div>' +
            '</a>' +
            '</div>' +
            '<div class="info_singer_video_box">' +
            '<span>' + compactNameCover(item.coverName, 5) + '</span>' +
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

    function onlyItemSelected(a, b, c) {
        $(a).addClass('selected');
        $(b + ', ' + c).removeClass('selected');
    }
});