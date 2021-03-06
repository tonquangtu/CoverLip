<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CoverLip</title>
    <%@ include file="../common/common_lib.jsp" %>

    <link rel="stylesheet" href="../../../resources/styles/main_header_style.css"/>
    <link rel="stylesheet" href="../../../resources/styles/main_footer_style.css"/>
    <link rel="stylesheet" type="text/css" href="../../../resources/styles/one_card_style.css"/>
    <link rel="stylesheet" href="../../../resources/styles/top_idol_card_style.css">
    <link rel="stylesheet" href="../../../resources/styles/card_playlist_cover_style.css">
    <link rel="stylesheet" type="text/css" href="../../../resources/styles/user_style.css"/>
    <link rel="stylesheet" type="text/css" href="../../../resources/libs/jb/hover-min.css"/>
    <script src="../../../resources/scripts/one_card_script.js"></script>
    <script src="../../../resources/scripts/more_item_script.js"></script>
    <script src="../../../resources/scripts/user_script.js"></script>
    <script src="/resources/scripts/main_header_script.js"></script>


</head>
<body>
<c:set var="targetPage" scope="request" value="cover_home_page"/>
<%@include file="../common/main_header.jsp" %>

<content>
    <div style="height:20px; width: 100%; clear: both"></div>
    <div class="container">
        <%--Header--%>
        <div id="header">
            <div id="background_header">
                <img src="${userInfo.account.coverImage}"
                     alt="Ảnh bìa hồ sơ" width="256" height="86">
            </div>

            <div id="content_header">
                <a href="">
                    <img src="${userInfo.account.avatarThumbnail}"
                         alt="Ảnh hồ sơ" class="avatar_member">
                </a>

                <div class="col-md-9 text_content">
                    <div class="username" role="button">${userInfo.account.fullname}
                    </div>
                    <div class="follower">${userInfo.numHaveFollowed} người theo dõi -
                        <div class="description" role="button">
                            ${userInfo.description}
                        </div>
                    </div>
                </div>

                <div class="right_header">
                    <div role="button" class="follow_button">
                        <span class="">
                            <div class="content_button">Following</div>
                        </span>
                    </div>
                </div>
            </div>
        </div>

        <%--Main--%>
        <div id="main">
            <div class="section-nav">
                <div class="width-limit">
                    <ul class="col-md-5 col-md-offset-4">
                        <li><a class="cover_history selected" href="/account/${userInfo.account.id}/cover">Cover</a></li>
                        <li><a class="lipsync_history" href="/account/${userInfo.account.id}/lipsync">LipSync</a></li>
                        <li><a class="playlist_history" href="/account/${userInfo.account.id}/playlist">Playlist</a></li>
                    </ul>
                </div>
            </div>
            <div style="clear:both; margin-bottom:20px;"></div>

            <div style="overflow:hidden">

                <div id="addHistoryFeed" class="col-md-8" style="padding-right:5px; padding-left:0;">
                    <!-- Main-->
                    <c:choose>
                        <c:when test="${type=='playlist'}">
                            <c:set scope="page" var="dataList" value="${playlistList}"/>
                        </c:when>
                        <c:otherwise>
                            <c:set scope="page" var="dataList" value="${videoList}"/>
                        </c:otherwise>
                    </c:choose>

                    <c:forEach var="item" items="${dataList}" varStatus="i" end="3">
                        <c:if test="${i.index%2==0}">
                            <div class="row" style="margin-left:0; margin-right: -20px;">
                        </c:if>
                        <div class="col-md-6" style="padding-right:20px; padding-left:0">
                            <c:set var="item" value="${item}" scope="request"/>
                            <c:choose>
                                <c:when test="${type=='playlist'}">
                                    <%@include file="../common/playlist_card.jsp"%>
                                </c:when>
                                <c:otherwise>
                                   <%@include file="../common/one_card.jsp"%>
                                </c:otherwise>
                            </c:choose>

                        </div>
                        <c:if test="${i.index%2==1||((i.index==dataList.size()-1)&&i.index%2==0)}">
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                <div class="col-md-4" style="padding-right:0;">
                    <c:set var="listHot" value="${topIdolList}" scope="request"/>
                    <%@include file="../common/top_idol_card.jsp" %>
                </div>
            </div>

            <div id="addHistoryFeed2" style="padding-right:5px; padding-left:0;">
                <!-- Main-->

                <c:forEach var="item" items="${dataList}" varStatus="i" begin="4" end="11">
                    <c:if test="${(i.index+2)%3==0}">
                        <div class="row" style="margin-left:0; margin-right: -26px;">
                    </c:if>
                    <div class="col-md-4" style="padding-right:20px; padding-left:0">
                        <c:set var="item" value="${item}" scope="request"/>
                        <c:choose>
                            <c:when test="${type=='playlist'}">
                                <%@include file="../common/playlist_card.jsp"%>
                            </c:when>
                            <c:otherwise>
                                <%@include file="../common/one_card.jsp"%>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <c:if test="${(i.index+2)%3==2||(i.index==dataList.size()-1)}">
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <div id="addItem"></div>

            <c:choose>
                <c:when test="${type=='playlist'}">
                    <div id="loading"
                         currentplaylistid="${(playlistList!=null&&playlistList.size()>0)?playlistList.get(playlistList.size()-1).id:0}"
                         type="${type}" accountid="${userInfo.account.id}">
                        <span><img class="loadicon" src="../../../resources/icons/loadding.svg" style="width:50px"></span>
                        <span>Đang tải dữ liệu...</span>
                    </div>
                </c:when>
                <c:otherwise>
                    <div id="loading"
                         currentvideoid="${(videoList!=null&&videoList.size()>0)?videoList.get(videoList.size()-1).video.id:0}"
                         type="${type}" accountid="${userInfo.account.id}">
                        <span><img class="loadicon" src="../../../resources/icons/loadding.svg" style="width:50px"></span>
                        <span>Đang tải dữ liệu...</span>
                    </div>
                </c:otherwise>
            </c:choose>

        </div>

    </div>
</content>
<%@ include file="/WEB-INF/views/common/main_footer.jsp" %>
</body>
</html>