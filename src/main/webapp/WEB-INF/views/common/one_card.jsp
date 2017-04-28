<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="one_card col-md-12">
    <div class="header_card">
        <div class="img-circle avatar_member">
            <img class="img-responsive" src="${item.getUserInfo().getAvatarThumbnail()}" alt="Avatar Member">
        </div>
        <div class="name_member">
            <h2>${item.getAccount().getFullname()}</h2>
        </div>
        <div class="option_card">
            <img src="/resources/icons/icon_more_vertical.svg" alt="${item.getCoverInfo().getCoverName()}" class="icon_more_vertical">
        </div>
    </div>
    <div class="content_card">
        <div class="media">
            <li class="item_singer_video ">
                <div class="singer_video_box">
                    <div class="thumbnail_video_box">
                        <a class="thumbnail_video" href="#"
                           title="${item.getCoverInfo().getCoverName()}">
                            <span class="icon_play"></span>
                            <img src="${item.getVideoInfo().getVideoThumbnailLink()}" alt="${item.getCoverInfo().getCoverName()}"
                                 title="${item.getCoverInfo().getCoverName()}">
                        </a>
                    </div>

                    <div class="info_singer_video_box">
                        <span>${item.getCoverInfo().getCoverName()}</span>
                    </div>
                </div>
            </li>
        </div>
    </div>
    <div class="footer_card">
        <ul class="interaction">
            <li class="like">
                <img src="/resources/icons/icon_like.svg" alt="" class="icon_react">&nbsp;<span
                    class="like_counter">${item.getVideoInfo().getNumLike()}</span>
            </li>
            <li class="comment">
                <a href="#">
                    <img src="/resources/icons/icon_comment.svg" alt="" class="icon_react">&nbsp;${item.getVideoInfo().getNumComment()}
                </a>
            </li>
            <li class="view">
                <span> <img src="/resources/icons/icon_view.svg" alt="" class="icon_react">&nbsp;${item.getVideoInfo().getNumView()} </span>
            </li>
        </ul>
        <%--<div class="facebook">--%>

            <%--<div class="col-md-6">--%>
                <%--<div class="fb-like" data-href="https://developers.facebook.com/docs/plugins/"--%>
                     <%--data-layout="button" data-action="like" data-size="large"--%>
                     <%--data-show-faces="false" data-share="false"></div>--%>
            <%--</div>--%>
            <%--<div class="col-md-6">--%>
                <%--<div class="fb-share-button"--%>
                     <%--data-href="https://developers.facebook.com/docs/plugins/"--%>
                     <%--data-layout="button" data-size="large" data-mobile-iframe="false"><a--%>
                        <%--class="fb-xfbml-parse-ignore" target="_blank"--%>
                        <%--href="https://www.facebook.com/sharer/sharer.php?u=https%3A%2F%2Fdevelopers.facebook.com%2Fdocs%2Fplugins%2F&amp;src=sdkpreparse">Share</a>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
        <div style="clear:both;"></div>
    </div>
</div>