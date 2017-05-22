<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>CoverLip</title>

    <%@include file="../common/common_lib.jsp"%>

    <link rel="stylesheet" href="../../../resources/styles/all_cover_page_style.css">
    <link rel="stylesheet" href="/resources/styles/main_navigation_style.css">
    <link rel="stylesheet" href="/resources/styles/main_header_style.css">
    <link rel="stylesheet" href="/resources/styles/main_footer_style.css">
    <link rel="stylesheet" href="/resources/styles/one_card_style.css">
    <link rel="stylesheet" href="/resources/libs/jb/hover-min.css">

</head>
<body>

<%@include file="../common/main_header.jsp"%>

<content>
    <div id="main_content_hot_cover" class="container">

        <div id="cover_page" class="container">
            <img src="/resources/storage/image/normal_image/owner_image/cover_hot.jpg" height="250px" width="100%">
            <div id="title_cover">
                <h1 style="color: white;">COVER HOT</h1>
                <p style="color: white;">Tổng hợp những cover hot nhất trên thế giới</p>
            </div>
        </div>

        <div id="content_page" class="container">
            <div id="cover_list" class="col-md-9">

                <c:forEach var="item" items="${coverList}" varStatus="i">
                    <c:if test="${i.index % 3 == 0}">
                        <div class="row item_not_first">
                    </c:if>
                    <div class="col-md-4">
                        <%@ include file="../common/one_card.jsp" %>
                    </div>
                    <c:if test="${i.index % 3 == 2 || i.index == (coverList.size() - 1)}">
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <div  class="col-md-3 top_cover_layout">
                <div class="top_cover">
                    <%--<div id="top_cover_idol">--%>
                    <a href=""><h3 id="title_top_cover">BXH TOP COVER</h3></a>
                    <ul class="top_cover_list">
                        <c:forEach var="topCoverItem" items="${coverTopList.items}" varStatus="i" end="5">
                            <li class="video-item">
                                <a href="#">
                                    <div class="video-thumbnail-box">
                                        <img class="video-thumbnail" src="${topCoverItem.video.videoThumbnailLink}">
                                    </div>
                                </a>
                                <a href="#">
                                    <div class="thumb-mask"></div>
                                </a>
                                <div class="video-info">

                                    <div class="video-owner-box pull-left">
                                        <a class="video-owner-thumbnail" style="background-image: url('${topCoverItem.video.account.avatarThumbnail}');" href="#"></a>
                                        <a class="video-owner-name center-vertical" href="#">${topCoverItem.video.account.fullname}</a>
                                    </div>

                                    <div>
                                        <a class="video-title center-vertical-content" href="#">${topCoverItem.coverName}</a>
                                    </div>

                                </div>

                                <a href="#">
                                    <span class="icon-play"></span>
                                </a>
                                <c:choose>
                                    <c:when test="${i.index == 0}">
                                        <span class="numberOne order_number">01</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="order_number">0${i.index + 1}</span>
                                    </c:otherwise>
                                </c:choose>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div> <!-- main content -->
</content>
<%@include file="../common/main_footer.jsp"%>

<script type="text/javascript">
    w3IncludeHTML();
</script>

</body>
</html>