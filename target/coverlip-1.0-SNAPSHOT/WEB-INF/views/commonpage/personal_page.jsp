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
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CoverLip</title>
    <%@ include file="../common/common_lib2.jsp" %>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="../../../resources/styles/main_navigation_style.css"/>
    <link rel="stylesheet" href="../../../resources/styles/main_header_style.css"/>
    <link rel="stylesheet" href="../../../resources/styles/main_footer_style.css"/>
    <link rel="stylesheet" href="../../../resources/styles/personal_style.css">

    <script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>

    <script type="text/javascript" src="../../../resources/scripts/personal_script.js"></script>

</head>
<body>
<%@include file="../common/main_header.jsp" %>

<content>
    <div class="container">
        <div class="">
            <div class="col-md-3 float-left menu_right" role="navigation">
                <nav class="menu" type="${type}">
                    <h3 class="menu_heading">
                        Quản Lý Cá Nhân
                    </h3>
                    <a href="/personal/information" class="selected">Thông Tin</a>
                    <a href="/personal/change-password">Thay Đổi Mật Khẩu</a>
                    <a href="">Upload</a>
                    <a href="/user/${userInfo.account.id}">Kênh Của Tôi</a>
                    <a href="/personal/my-cover">Cover Đã Đăng</a>
                    <a href="/personal/my-lipsync">LipSync Đã Đăng</a>
                    <a href="/personal/my-playlist">Playlist Đã Đăng</a>
                    <a href="/personal/my-idol">Idol Đang Theo Dõi</a>
                    <a href="/personal/my-fan">Người Đăng Ký</a>
                </nav>
            </div>
            <div class="col-md-9 float-left main_person">
                <!-- Public Profile -->
                <c:choose>
                    <c:when test="${type.equals('information')}">
                        <c:set var="userInfo" scope="request" value="${userInfo}"/>
                        <%@include file="personalpage/information.jsp"%>
                    </c:when>
                    <c:when test="${type.equals('change-password')}">
                        <%@include file="personalpage/change_password.jsp"%>
                    </c:when>
                    <c:when test="${type.equals('my-cover')}">
                        <%@include file="personalpage/my_cover.jsp"%>
                    </c:when>
                    <c:when test="${type.equals('my-lipsync')}">
                        <%@include file="personalpage/my_lipsync.jsp"%>
                    </c:when>
                    <c:when test="${type.equals('my-playlist')}">
                        <%@include file="personalpage/my_playlist.jsp"%>
                    </c:when>
                    <c:when test="${type.equals('my-idol')}">
                        <%@include file="personalpage/my_idol.jsp"%>
                    </c:when>
                    <c:when test="${type.equals('my-fan')}">
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

