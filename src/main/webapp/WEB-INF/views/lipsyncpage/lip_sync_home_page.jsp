<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Lip-Sync</title>

    <%@include file="../common/common_lib.jsp" %>

    <%--<link rel="stylesheet" href="/resources/styles/main_navigation_style.css">--%>
    <link rel="stylesheet" href="/resources/styles/main_header_style.css">
    <link rel="stylesheet" href="/resources/styles/main_footer_style.css">
    <script src="/resources/scripts/main_header_script.js"></script>
    <link rel="stylesheet" href="/resources/styles/lip_sync_home_page_style.css">

</head>

<body>

<c:set var="targetPage" scope="request" value="lip_sync_home_page"/>
<%@include file="../common/main_header.jsp" %>

<div class="top_member">
    <!-- Page Header -->
    <div class="row title">
        <div class="col-lg-12">
            <h2 class="page-header"><a href="">Top Người Đăng Nổi Bật</a></h2>
        </div>
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="top_idol">
            <div class="col-md-3">
                <div class="one_member text-center subject" style="padding-bottom:10px;box-shadow:unset;border-top-right-radius: 32px;">
                    <a href="">
                        <div class="avatar">
                            <img src="${topIdolList.get(0).user.account.avatarThumbnail}" alt="${topIdolList.get(0).user.account.fullname}"
                                 class="img-responsive" style="width:100%">
                            <span class="numberOne">01</span>
                        </div>
                        <div class="name_of_member">
                            <p>${topIdolList.get(0).user.account.fullname}</p>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-md-9">
                <c:forEach items="${topIdolList}" var="item1" varStatus="i" begin="1">
                    <c:if test="${i.index<9}">
                        <c:if test="${(i.index+3)%4==0}">
                            <div class="row">
                        </c:if>
                        <div class="col-md-3 one_member text-center">
                            <a href="">
                                <div class="avatar">
                                    <img src="${item1.user.account.avatarThumbnail}" alt="${item1.user.account.fullname}"
                                         class="img-responsive img-circle">
                                    <span>0${i.index+1}</span>
                                </div>
                                <div class="name_of_member">
                                    <p>${item1.user.account.fullname}</p>
                                </div>
                            </a>
                        </div>
                        <c:if test="${(i.index+3)%4==3}">
                            </div>
                        </c:if>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>

</div>

</body>
</html>
