<%--
  Created by IntelliJ IDEA.
  User: nguyenthanhtung
  Date: 05/05/2017
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CoverLip</title>
    <%@ include file="../common/common_lib.jsp" %>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="../../../resources/styles/main_header_style.css"/>
    <link rel="stylesheet" href="../../../resources/styles/main_footer_style.css"/>
    <link rel="stylesheet" href="../../../resources/styles/one_card_style.css">
    <link rel="stylesheet" href="../../../resources/styles/card_playlist_cover_style.css">
    <link rel="stylesheet" href="../../../resources/styles/personal_style.css">

    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src = "../../../resources/scripts/one_card_script.js"></script>
    <script src="../../../resources/scripts/more_item_script.js"></script>
    <script type="text/javascript" src="../../../resources/scripts/personal_script.js"></script>
    <script src="/resources/scripts/main_header_script.js"></script>

</head>
<body>
<c:set var="targetPage" scope="request" value="cover_home_page"/>
<%@include file="../common/main_header.jsp" %>

<content>
    <div style="height:20px; width: 100%; clear: both"></div>
    <div class="container">
        <div class="">
            <div class="col-md-3 float-left menu_right" role="navigation">
                <nav class="menu" type="${type}">
                    <h3 class="menu_heading">
                        Quản Lý Cá Nhân
                    </h3>
                    <a href="/personal/information" class="selected">Thông Tin</a>
                    <a href="/personal/change-password">Thay Đổi Mật Khẩu</a>
                    <a href="/personal/upload">Upload</a>
                    <a href="/account/${userInfo.account.id}">Kênh Của Tôi</a>
                    <a href="/personal/my-cover">Cover Đã Đăng</a>
                    <a href="/personal/my-lipsync">LipSync Đã Đăng</a>
                    <a href="/personal/my-playlist">Playlist Đã Đăng</a>
                    <a href="/personal/my-idol">Idol Đang Theo Dõi</a>
                    <a href="/personal/my-fan">Người Đăng Ký</a>
                </nav>
            </div>
            <div class="col-md-9 float-left">
                <!-- Public Profile -->
                <c:choose>
                    <c:when test="${type.equals('information')}">
                        <c:set var="userInfo" scope="request" value="${userInfo}"/>
                        <%@include file="personalpage/information.jsp"%>
                    </c:when>
                    <c:when test="${type.equals('change-password')}">
                        <%@include file="personalpage/change_password.jsp"%>
                    </c:when>
                    <c:when test="${type.equals('upload')}">
                        <c:set var="message" scope="request" value="${message}"/>
                        <c:set var="userInfo" scope="request" value="${userInfo}"/>
                        <%@include file="personalpage/upload_video_page.jsp"%>
                    </c:when>
                    <c:when test="${type.equals('my-cover')}">
                        <c:set var="videoList" scope="request" value="${videoList}"/>
                        <c:set var="type" scope="request" value="${type.substring(3)}"/>
                        <c:set var="userInfo" scope="request" value="${userInfo}"/>
                        <%@include file="personalpage/my_cover.jsp"%>
                    </c:when>
                    <c:when test="${type.equals('my-lipsync')}">
                        <c:set var="videoList" scope="request" value="${videoList}"/>
                        <c:set var="type" scope="request" value="${type.substring(3)}"/>
                        <c:set var="userInfo" scope="request" value="${userInfo}"/>
                        <%@include file="personalpage/my_lipsync.jsp"%>
                    </c:when>
                    <c:when test="${type.equals('my-playlist')}">
                        <c:set var="playlistList" scope="request" value="${playlistList}"/>
                        <c:set var="type" scope="request" value="${type.substring(3)}"/>
                        <c:set var="userInfo" scope="request" value="${userInfo}"/>
                        <%@include file="personalpage/my_playlist.jsp"%>
                    </c:when>
                    <c:when test="${type.equals('my-idol')}">
                        <c:set var="idolList" scope="request" value="${idolList}"/>
                        <c:set var="type" scope="request" value="${type.substring(3)}"/>
                        <c:set var="userInfo" scope="request" value="${userInfo}"/>
                        <%@include file="personalpage/my_idol.jsp"%>
                    </c:when>
                    <c:when test="${type.equals('my-fan')}">
                        <c:set var="fanList" scope="request" value="${fanList}"/>
                        <c:set var="type" scope="request" value="${type.substring(3)}"/>
                        <c:set var="userInfo" scope="request" value="${userInfo}"/>
                        <%@include file="personalpage/my_fan.jsp"%>
                    </c:when>
                    <c:otherwise>

                    </c:otherwise>
                </c:choose>

            </div>
        </div>
    </div>
</content>
<%@ include file="/WEB-INF/views/common/main_footer.jsp" %>
</body>
</html>

