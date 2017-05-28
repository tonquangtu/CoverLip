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
    <link rel="stylesheet" type="text/css" href="../../../resources/libs/jb/hover-min.css"/>
    <link rel="stylesheet" href="../../../resources/styles/all_cover_page_style.css">
    <link rel="stylesheet" href="../../../resources/styles/result_search.css">
    <script src="../../../resources/scripts/one_card_script.js"></script>
    <script src="../../../resources/scripts/more_item_script.js"></script>


</head>
<body>
<c:set var="targetPage" scope="request" value="cover_home_page"/>
<%@include file="../common/main_header.jsp" %>

<content>
    <div style="height:20px; width: 100%; clear: both"></div>
    <div id="main_content_hot_cover" class="container">
        <div id="content_page" class="container">
            <div id="cover_list" class="col-md-9">
                <div>
                    <h3 class="page-header">Kết quả tìm kiếm cover "abc"</h3>
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

                <!-- /.row -->
                <div class="row">
                    <div class="top_idol" style="margin-left: 6px; margin-right: 6px;">
                        <h3 class="page-header"><span>Kết quả tìm kiếm ca sĩ "" </span></h3>
                        <div class="col-md-12">
                            <c:forEach items="${topIdolList}" var="item1" varStatus="i">
                                <c:if test="${i.index<8}">
                                    <c:if test="${i.index%4==0}">
                                        <div class="row">
                                    </c:if>
                                    <div class="col-md-3 one_member text-center">
                                        <a href="/user/${item1.user.account.id}">
                                            <div class="avatar">
                                                <img src="${item1.user.account.avatarThumbnail}"
                                                     alt="${item1.user.account.fullname}"
                                                     class="img-responsive img-circle">
                                            </div>
                                            <div class="name_of_member">
                                                <p>${item1.user.account.fullname}</p>
                                            </div>
                                        </a>
                                    </div>
                                    <c:if test="${i.index%4==3}">
                                        </div>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>

            </div>
            <div class="col-md-3 top_cover_layout">
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
                                        <a class="video-owner-thumbnail"
                                           style="background-image: url('${topCoverItem.video.account.avatarThumbnail}');"
                                           href="#"></a>
                                        <a class="video-owner-name center-vertical"
                                           href="#">${topCoverItem.video.account.fullname}</a>
                                    </div>

                                    <div>
                                        <a class="video-title center-vertical-content"
                                           href="#">${topCoverItem.coverName}</a>
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
<%@ include file="/WEB-INF/views/common/main_footer.jsp" %>
</body>
</html>