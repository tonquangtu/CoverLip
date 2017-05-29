<%--
Created by IntelliJ IDEA.
User: nguyenthanhtung
Date: 25/04/2017
Time: 08:36
To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CoverLip</title>
    <%@ include file="../common/common_lib.jsp" %>

    <%--<link rel="stylesheet" href="/resources/styles/main_navigation_style.css"/>--%>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/styles/main_header_style.css"/>
    <link rel="stylesheet" href="/resources/styles/main_footer_style.css"/>
    <link rel="stylesheet" href="/resources/styles/top_idol_card_style.css">
    <link rel="stylesheet" href="/resources/libs/jb/hover-min.css">
    <link rel="stylesheet" type="text/css" href="/resources/styles/top_cover_page_style.css"/>
    <script src="/resources/scripts/main_header_script.js"></script>


    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" type="text/javascript"></script>
    <script src="../../../resources/scripts/top_cover_script.js"></script>
</head>
<body>
<c:set var="targetPage" scope="request" value="cover_home_page"/>
<%@include file="../common/main_header.jsp" %>

<content>
    <div style="height:20px; width: 100%; clear: both"></div>
    <div class="container">
        <div class="col-md-12" style="padding:0">
            <div class="title_top_cover text-center">
                <span class="background_gadent"></span>
                <h1>Bảng Xếp Hạng</h1>
                <p>Cập nhật vào Thứ Hai hàng tuần, các bản cover được tổng hợp đánh giá dựa trên nhiều tiêu chí để đem
                    đến một bảng xếp hạng tuyệt vời nhất dành cho bạn.</p>
            </div>
        </div>
        <div class="col-md-8" style="padding-left:0; padding-right:0;">
            <div id="main_page" class="border_common">
                <div class="box_view_week">
                    <c:if test="${numWeek >1}">
                        <a id="prev_foo_video_more" class="prev" href="/top-cover/Bang-Xep-Hang-Lan-${numWeek-1}"
                           style="display: block;"
                           title="Bảng xếp hạng trước"></a>
                    </c:if>
                    <h2><strong>Lần ${numWeek}</strong> (${coverTopList.formatTimestamp(coverTopList.timeTopStart)}
                        - ${coverTopList.formatTimestamp(coverTopList.timeEndStart)})</h2>
                    <c:if test="${numWeek!=nowNumWeek}">
                        <a id="next_foo_video_more" class="next" href="/top-cover/Bang-Xep-Hang-Lan-${numWeek+1}"
                           style="display: block;"
                           title="Bảng xếp hạng kế tiếp"></a>
                    </c:if>

                    <span title="Chọn ngày" class="select_date" id="select_date" role="button"></span>
                    <a href="" class="active_play" title="Nghe Toàn Bộ"><span class="icon_playall"></span>Nghe Toàn
                        Bộ</a>
                </div>
                <div class="list-item">
                    <c:choose>
                        <c:when test="${coverTopList.items.size()==0}">
                            <p class="not_data">Chưa Có Dữ Liệu...</p>
                        </c:when>
                        <c:otherwise>
                            <ul>
                                <c:forEach var="item" items="${coverTopList.items}" begin="0" end="9" varStatus="i">
                                    <li class="one-video">
                                        <span class="priority">${i.count}</span>
                                        <span class="change">
			            		<span class=""></span>
			            		<p>${10-i.index}</p>
			            	</span>
                                        <a class="thumb-video" href="${item.toVideoWrapper().fullLink}"
                                           title="${item.coverName} - ${item.video.account.fullname}">
                                            <img class="img-responsive" alt="${item.coverName}"
                                                 src="${item.video.videoThumbnailLink}"
                                                 style="width:170px">
                                            <span class="icon-circle-play icon-small"></span>
                                        </a>
                                        <div class="tool-video">
                                            <div class="icon-download"><a title="Download" class="link-download"
                                                                          href="${item.mp3Link}" target="_blank"></a>
                                            </div>
                                            <div class="icon-addlist"><a title="Thêm vào" class="link-addlist"></a>
                                            </div>
                                            <div class="icon-share"><a title="Chia sẻ" class="link-share"></a></div>
                                        </div>
                                        <div style="width:100%;">
                                            <h3 class="title-video">
                                                <a class="" href="${item.toVideoWrapper().fullLink}"
                                                   title="Bài hát ${item.coverName} - ${item.video.account.fullname}">${item.coverName}</a>
                                            </h3>
                                            <span class="singer">
				                    <h4><a href="/account/${item.video.account.id}"
                                           title="Nghệ sĩ ${item.video.account.fullname}">${item.video.account.fullname}</a></h4>
				                </span>
                                            <div class="footer_card">
                                                <ul class="interaction">
                                                    <li class="like">
                                                        <img src="../../../resources/icons/icon_like.svg"
                                                             alt="Lượt thích"
                                                             class="icon_react">&nbsp;<span
                                                            class="like_counter">${item.video.numLike}</span>
                                                    </li>
                                                    <li class="comment">
                                                        <a href="${item.toVideoWrapper().fullLink}">
                                                            <img src="../../../resources/icons/icon_comment.svg"
                                                                 alt="Bình luận"
                                                                 class="icon_react">&nbsp;${item.video.numComment}
                                                        </a>
                                                    </li>
                                                    <li class="view">
                                                <span> <img src="../../../resources/icons/icon_view.svg" alt="Lượt xem"
                                                            class="icon_react">&nbsp;${item.video.numView} </span>
                                                    </li>
                                                </ul>
                                                <div style="clear:both;"></div>
                                            </div>
                                        </div>

                                        <div style="clear:both;"></div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>
        </div>
        <div class="col-md-4" style="padding-left:30px; padding-right:0">
            <div id="hot_list" class="border_common">
                <div class="box_title">
                    <h3 class="name"><a href="/hot-cover">HOT PLAYLIST</a></h3>
                </div>
                <div class="box_content">
                    <ul class="list_playlist_table">
                        <c:forEach var="item" items="${hotPlayListCover}" begin="0" end="4" varStatus="i">
                            <li class="playlist">
                                <div class="one_playlist">
                                    <a class="image_playlist" href="">
                                        <img class="thumb"
                                             src="http://${item.playlistThumbnaiLink}"
                                             alt="${item.description}"
                                             width="55" height="55">
                                    </a>
                                    <div class="info-table">
                                        <h4 class="name_playlist">
                                            <a href="" title="${item.playlistName}">${item.playlistName}</a>
                                        </h4>
                                        <div class="member_post">
                                            <a href="/account/${item.account.id}" title="Nghệ sĩ ${item.account.fullname}">
                                                <img src="${item.account.avatarThumbnail}"
                                                     class="img-circle avatar_member">
                                                <p>${item.account.fullname}</p>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <c:set var="listHot" value="${topIdolList}" scope="request"/>
            <%@include file="../common/top_idol_card.jsp" %>
        </div>
    </div>
</content>

<%@ include file="/WEB-INF/views/common/main_footer.jsp" %>
</body>
</html>
