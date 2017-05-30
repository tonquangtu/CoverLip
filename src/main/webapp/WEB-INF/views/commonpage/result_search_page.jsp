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
    <link rel="stylesheet" href="../../../resources/styles/result_search_page_style.css">
    <script src="../../../resources/scripts/one_card_script.js"></script>
    <script src="../../../resources/scripts/more_item_script.js"></script>
    <script src="/resources/scripts/main_header_script.js"></script>


</head>
<body>
<c:choose>
    <c:when test="${type eq 1}">
        <c:set var="targetPage" scope="request" value="cover_home_page"/>
    </c:when>
    <c:otherwise>
        <c:set var="targetPage" scope="request" value="lip_sync_home_page"/>
    </c:otherwise>
</c:choose>

<%@include file="../common/main_header.jsp" %>

<content>
    <c:set var="urlSearch" value="/search-all?searchString=${searchString}&limit=9&type=${type}"/>
    <div style="height:20px; width: 100%; clear: both"></div>
    <div id="main_content_hot_cover" class="container">
        <div id="content_page" class="container">
            <div id="cover_list" class="col-md-9">
                <c:if test="${resultType eq 1 || resultType eq 3}">
                    <div>
                        <h3 class="page-header">
                            <c:choose>
                                <c:when test="${type eq 1}">
                                    <span>Kết quả tìm kiếm cover "${searchString}"</span>
                                </c:when>
                                <c:when test="${type eq 2}">
                                    <span>Kết quả tìm kiếm lipsync "${searchString}"</span>
                                </c:when>
                            </c:choose>
                            <c:if test="${resultType eq 3}">
                                <a href="${urlSearch}&resultType=1">Xem
                                    tất cả <i class="fa fa-caret-right" aria-hidden="true"></i>
                                </a></c:if>
                        </h3>
                        <c:forEach var="item" items="${searchData.videoSearchList}" varStatus="i">
                            <c:if test="${i.index % 3 == 0}">
                                <div class="row item_not_first">
                            </c:if>
                            <div class="col-md-4">
                                <%@ include file="../common/one_card.jsp" %>
                            </div>
                            <c:if test="${i.index % 3 == 2 || i.index == (searchData.videoSearchList.size() - 1)}">
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </c:if>
                <c:if test="${resultType eq 2 || resultType eq 3}">
                    <div class="row">
                        <div class="top_idol" style="margin-left: 6px; margin-right: 6px;">
                            <h3 class="page-header" style="margin: 40px 0 20px;">
                                <span>Kết quả tìm kiếm ca sĩ "${searchString}" </span>
                                <c:if test="${resultType eq 3}">
                                    <a href="${urlSearch}&resultType=2">Xem
                                        tất cả <i class="fa fa-caret-right" aria-hidden="true"></i>
                                    </a>
                                </c:if>
                            </h3>
                            <div class="col-md-12">
                                <c:forEach items="${searchData.accountSearchList}" var="item1" varStatus="i">
                                    <c:if test="${i.index<8}">
                                        <c:if test="${i.index%4==0}">
                                            <div class="row">
                                        </c:if>
                                        <div class="col-md-3 one_member text-center">
                                            <a href="/account/${item1.id}">
                                                <div class="avatar">
                                                    <img src="${item1.avatarThumbnail}"
                                                         alt="${item1.fullname}"
                                                         class="img-responsive img-circle">
                                                    <button class="button-transparent button-follow first-position-button-follow ">
                                                        Follow
                                                    </button>
                                                </div>
                                                <div class="name_of_member">
                                                    <p>${item1.fullname}</p>
                                                </div>
                                            </a>
                                        </div>
                                        <c:if test="${i.index%4==3||i.index == (searchData.accountSearchList.size() - 1)}">
                                            </div>
                                        </c:if>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </c:if>
                <c:if test="${resultType eq 1|| resultType eq 2}">
                    <div style="text-align:center">
                        <div>
                            <div class="pagination">
                                <c:if test="${currentPage > 1}">
                                    <a href="${urlSearch}&resultType=${resultType}&page=1">Đầu</a>
                                    <a href="${urlSearch}&resultType=${resultType}&page=${currentPage-1}">&laquo;</a>
                                </c:if>
                                <c:choose>
                                    <c:when test="${currentPage-2>0}">
                                        <c:choose>
                                            <c:when test="${currentPage+2<lastPage}">
                                                <c:set var="beginPage" value="${currentPage-2}"/>
                                                <c:set var="endPage" value="${currentPage+2}"/>
                                            </c:when>
                                            <c:otherwise>
                                                <c:set var="beginPage" value="${currentPage-2}"/>
                                                <c:set var="endPage" value="${lastPage}"/>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${5<lastPage}">
                                                <c:set var="beginPage" value="1"/>
                                                <c:set var="endPage" value="5"/>
                                            </c:when>
                                            <c:otherwise>
                                                <c:set var="beginPage" value="1"/>
                                                <c:set var="endPage" value="${lastPage}"/>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:otherwise>
                                </c:choose>

                                <c:forEach varStatus="indexPage" begin="${beginPage}" end="${endPage}">
                                    <a href="${urlSearch}&resultType=${resultType}&page=${indexPage.index}"
                                       class="${indexPage.index == currentPage ? 'active' : ''}">${indexPage.index}</a>
                                </c:forEach>
                                <c:if test="${currentPage < lastPage}">
                                    <a href="${urlSearch}&resultType=${resultType}&page=${currentPage+1}">&raquo;</a>
                                    <a href="${urlSearch}&resultType=${resultType}&page=${lastPage}">Cuối</a>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </c:if>
            </div>
            <div class="col-md-3 top_cover_layout">
                <div class="top_cover">
                    <%--<div id="top_cover_idol">--%>
                    <a href="/top-cover"><h3 id="title_top_cover">BXH TOP COVER</h3></a>
                    <ul class="top_cover_list">
                        <c:forEach var="topCoverItem" items="${coverTopList.items}" varStatus="i" end="5">
                            <li class="video-item">
                                <a href="${topCoverItem.toVideoWrapper().fullLink}">
                                    <div class="video-thumbnail-box">
                                        <img class="video-thumbnail" src="${topCoverItem.video.videoThumbnailLink}">
                                    </div>
                                </a>
                                <a href="${topCoverItem.toVideoWrapper().fullLink}">
                                    <div class="thumb-mask"></div>
                                </a>
                                <div class="video-info">

                                    <div class="video-owner-box pull-left">
                                        <a class="video-owner-thumbnail"
                                           style="background-image: url('${topCoverItem.video.account.avatarThumbnail}');"
                                           href="/account/${topCoverItem.video.account.id}"></a>
                                        <a class="video-owner-name center-vertical"
                                           href="/account/${topCoverItem.video.account.id}">${topCoverItem.video.account.fullname}</a>
                                    </div>

                                    <div>
                                        <a class="video-title center-vertical-content"
                                           href="${topCoverItem.toVideoWrapper().fullLink}">${topCoverItem.coverName}</a>
                                    </div>

                                </div>

                                <a href="${topCoverItem.toVideoWrapper().fullLink}">
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