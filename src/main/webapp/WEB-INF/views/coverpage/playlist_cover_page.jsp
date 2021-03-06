<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Playlist</title>

    <%@include file="../common/common_lib.jsp" %>

    <%--<link rel="stylesheet" href="/resources/styles/main_navigation_style.css">--%>
    <link rel="stylesheet" href="/resources/styles/main_header_style.css">
    <link rel="stylesheet" href="/resources/styles/main_footer_style.css">
    <link rel="stylesheet" type="text/css" href="/resources/styles/card_playlist_cover_style.css">
    <link rel="stylesheet" type="text/css" href="/resources/styles/playlist_cover_page_style.css">
    <script src="/resources/scripts/main_header_script.js"></script>

</head>
<body>
<c:set var="targetPage" scope="request" value="cover_home_page"/>
<%@include file="../common/main_header.jsp" %>

<content>
    <div style="height:20px; width: 100%; clear: both"></div>
    <div id="main_content_playlist" class="container">
        <div id="cover_page" class="container">
            <img src="/resources/storage/image/normal_image/owner_image/top_cover_background.jpg" height="250px" width="100%">
            <div id="title_cover">
                <h1 style="color: white;">PLAYLIST</h1>
                <p style="color: white; font-weight: bold">Tổng hợp những playlist cover hay nhất trên thế giới</p>
            </div>
        </div>

        <%--<h1>Tổng hợp playlist cover</h1>--%>

        <div class="container" style="padding-left:0;">
            <div class=content_page_playlist>
                <%--<div class="order">--%>
                <%----%>
                <%--<p>Sắp xếp</p>--%>
                <%--<div class="dropdown">--%>
                <%----%>
                <%--<button type="button" class="btn btn-primary dropdown-toggle btn-xs" data-toggle=dropdown>--%>
                <%--Ngày--%>
                <%--<span class="caret"></span>--%>
                <%--</button>--%>
                <%--<ul class="dropdown-menu">--%>
                <%--<li><a href="#">Ngày</a></li>--%>
                <%--<li><a href="#">Tháng</a></li>--%>
                <%--<li><a href="#">Năm</a></li>--%>
                <%--</ul>--%>
                <%--</div>--%>
                <%--</div>--%>

                <c:forEach var="item" items="${playlistList}" varStatus="i">
                    <c:if test="${i.index % 4 == 0}">
                        <div class="row list_playlist">
                    </c:if>
                    <div class="col-md-3">
                        <c:set scope="request" var="item" value="${item}"/>
                        <%@include file="../common/playlist_card.jsp"%>
                    </div>

                    <c:if test="${i.index % 4 == 3 || i.index == (playlistList.size() - 1)}">
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>
</content>

<%@include file="../common/main_footer.jsp" %>

</body>
</html>