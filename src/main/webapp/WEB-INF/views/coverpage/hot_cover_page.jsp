<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>CoverLip</title>

    <%@include file="../common/common_lib.jsp"%>

    <link rel="stylesheet" href="../../../resources/styles/hot_cover_page_style.css">
    <%--<link rel="stylesheet" href="/resources/styles/main_navigation_style.css">--%>
    <link rel="stylesheet" href="/resources/styles/main_header_style.css">
    <link rel="stylesheet" href="/resources/styles/main_footer_style.css">
    <link rel="stylesheet" href="/resources/styles/one_card_style.css">
    <script src="/resources/scripts/main_header_script.js"></script>

</head>
<body>
<c:set var="targetPage" scope="request" value="cover_home_page"/>
<%@include file="../common/main_header.jsp"%>

<content>
    <div style="height:20px; width: 100%; clear: both"></div>
    <div id="main_content_hot_cover" class="container">

        <div id="cover_page" class="container">
            <img src="/resources/storage/image/normal_image/owner_image/cover_hot.jpg" height="250px" width="100%">
            <div id="title_cover">
                <h1 style="color: white;">COVER HOT</h1>
                <p style="color: white;">Tổng hợp những cover hot nhất trên thế giới</p>
            </div>
        </div>

        <div id="content_page" class="container">
            <div class="row">
                <div id="cover_list" class="col-md-9">


                        <c:forEach var="item" items="${hotCoverList}" varStatus="i">

                            <c:choose>

                                <c:when test="${i.index < 2}">
                                    <c:if test="${i.index == 0}">

                                        <div class="row item_first">
                                    </c:if>
                                        <div class="col-md-6">

                                            <%@ include file="../common/one_card.jsp" %>
                                        </div>

                                     <c:if test="${i.index == 1}">

                                         </div>
                                     </c:if>

                                </c:when>

                                <c:otherwise>
                                    <%--dong tiep theo bat dau phan tu la 2 3 4--%>
                                    <c:if test="${i.index % 3 == 2}">

                                        <div class="row item_not_first">
                                    </c:if>
                                        <div class="col-md-4">

                                            <%@ include file="../common/one_card.jsp" %>
                                        </div>

                                     <c:if test="${i.index % 3 == 1 || i.index == (hotCoverList.size() - 1)}">
                                        </div>
                                     </c:if>
                                </c:otherwise>

                            </c:choose>

                        </c:forEach>
                </div>
                <div  class="col-md-3 top_cover_idol_layout">
                    <%--<div id="top_cover_idol">--%>
                        <%--<h3 id="title_top_cover_idol">TOP COVER IDOL</h3>--%>
                        <%--<ul>--%>
                            <%--<c:forEach var="item1" items="${listTopCoverIdols}" varStatus="i">--%>
                                <%--<li class="item_top_cover_idol">--%>
                                    <%--<img src="${item1.user.avatarThumbnail}" class="img-circle" alt="top cover idol">--%>
                                    <%--<div class="idol_info">--%>
                                        <%--<p><strong>${item1.user.account.fullname}</strong></p>--%>
                                        <%--<p>${item1.user.numHaveFollowed}</p>--%>
                                    <%--</div>--%>
                                    <%--<button type="button" class="btn btn-success btn-sm">Theo doi</button>--%>
                                <%--</li>--%>
                            <%--</c:forEach>--%>
                        <%--</ul>--%>
                    <%--</div>--%>
                        <c:set var="listHot" value="${listTopCoverIdols}" scope="request"/>
                        <%@include file="../common/top_idol_card.jsp" %>
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