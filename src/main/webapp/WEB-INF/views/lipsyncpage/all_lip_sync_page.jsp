<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>CoverLip</title>

    <%@include file="../common/common_lib.jsp"%>

    <link rel="stylesheet" href="../../../resources/styles/all_lipsync_page_style.css">
    <%--<link rel="stylesheet" href="/resources/styles/main_navigation_style.css">--%>
    <link rel="stylesheet" href="/resources/styles/main_header_style.css">
    <link rel="stylesheet" href="/resources/styles/main_footer_style.css">
    <link rel="stylesheet" href="/resources/styles/one_card_style.css">
    <link rel="stylesheet" href="/resources/libs/jb/hover-min.css">
    <script src="/resources/scripts/main_header_script.js"></script>
    <script src="/resources/scripts/all_cover_lipsync_script.js"></script>

</head>
<body>
<c:set var="targetPage" scope="request" value="lip_sync_home_page"/>
<%@include file="../common/main_header.jsp"%>

<content>
    <div style="height:20px; width: 100%; clear: both"></div>
    <div id="main_content_hot_cover" class="container">

        <div id="cover_page" class="container">
            <img src="/resources/storage/image/normal_image/owner_image/all_lipsync.jpg" height="250px" width="100%">
            <%--<div id="title_cover">--%>
                <%--<h1 style="color: white;">Những bài hit lipsync mới</h1>--%>
                <%--<p style="color: white;">Chuyên mục được cập nhật vào cuối mỗi tuần.--%>
                    <%--Đây là những bài lipsync mới do những idol xinh đẹp, dễ thương thực hiện.</p>--%>
            <%--</div>--%>
        </div>

        <div id="content_page" class="container">
            <div id="cover_list" class="col-md-9">

                <c:set var="item" scope="request" value="${item}"/>
                <c:forEach var="item" items="${lipSyncList}" varStatus="i">

                    <c:if test="${i.index % 3 == 0}">

                        <div class="row item_not_first">
                    </c:if>
                    <div class="col-md-4">

                        <%@ include file="../common/one_card.jsp" %>
                    </div>

                    <c:if test="${i.index % 3 == 2 || i.index == (lipSyncList.size() - 1)}">
                        </div>
                    </c:if>
                </c:forEach>

                <div id="addVideo"></div>

                <div id="loading"
                     currentvideoid="${(lipSyncList!=null&&lipSyncList.size()>0)?lipSyncList.get(lipSyncList.size()-1).video.id:0}"
                     type="lipsync">
                    <span><img class="loadicon" src="../../../resources/icons/loadding.svg" style="width:50px"></span>
                    <span>Đang tải dữ liệu...</span>
                </div>
            </div>
            <div  class="col-md-3 top_cover_idol_layout">
                <c:set var="listHot" value="${listTopLipSyncIdols}" scope="request"/>
                <%@include file="../common/top_idol_card.jsp" %>
            </div>
        </div>
    </div> <!-- main content -->
</content>

<%@include file="../common/main_footer.jsp"%>

</body>
</html>