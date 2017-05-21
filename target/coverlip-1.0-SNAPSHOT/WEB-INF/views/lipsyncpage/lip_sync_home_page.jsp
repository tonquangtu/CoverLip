
<!DOCTYPE html>
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

    <link rel="stylesheet" href="/resources/styles/lip_sync_home_page_style.css">
    <link rel="stylesheet" href="/resources/styles/one_card_style.css">

    <script src="/resources/scripts/lip_sync_home_page_script.js"></script>
    <script src="/resources/scripts/main_header_script.js"></script>

</head>

<body>

<c:set var="targetPage" scope="request" value="lip_sync_home_page"/>
<%@include file="../common/main_header.jsp" %>

<div class="root">
    <div style="height:20px; width: 100%; clear: both"></div>
    <div class="container">

        <div class="top_member">
            <!-- /.row -->
            <div class="row">
                <div class="top_idol">

                    <h3 class="title-top-idol">
                        <a href="">Top idol lip-sync</a>
                    </h3>
                    <div class="col-md-3">
                        <div class="one_member text-center subject first-idol">
                            <a href="">
                                <div class="avatar">
                                    <img src="${topIdolList.get(0).user.account.avatarThumbnail}" alt="${topIdolList.get(0).user.account.fullname}"
                                         class="img-responsive" style="width:100% ; height:88%;">
                                    <span class="numberOne">01</span>
                                    <button class="button-transparent button-follow first-position-button-follow ">Follow</button>

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

                                            <button class="button-transparent button-follow position-button-follow">Follow</button>
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
        <div class="hot-lip-sync">
            <div class="col-md-12 lip-syncs" style="padding-right: 0px; padding-left:0px; margin-bottom: 15px;">
                <c:forEach var="item" items="${hotLipSyncs}" varStatus="i">
                    <%--<c:if test="${i.index<12}">--%>
                        <c:if test="${i.index%3==0}">
                            <div class="row" style=" margin-left: 0px;">
                        </c:if>
                        <div class="col-md-4" style="padding-right:15px; padding-left:0;">
                            <c:set var="item" value="${item}" scope="request"/>
                            <c:set var="subBaseUrl" value="${subBaseUrl}" scope="request"/>
                            <%@include file="../common/lip_sync_card.jsp" %>
                        </div>
                        <c:if test="${i.index%3==2 || i.index == hotLipSyncs.size() -1}">
                            </div>
                        </c:if>

                    <%--</c:if>--%>
                </c:forEach>

            </div>

        </div>

        <c:set var="lastVideoId" value="-1"/>
        <c:if test="${hotLipSyncs != null && hotLipSyncs.size() > 0}">
            <c:set var="lastVideoId" value="${hotLipSyncs.get(hotLipSyncs.size() -1).video.id}"/>
        </c:if>

        <div class="load-more-box" lastVideoId ="${lastVideoId}" >
            <img src="/resources/icons/loadding.svg">

        </div>

    </div>

</div>

<div class="main-footer">
    <%@include file="../common/main_footer.jsp"%>
</div>


</body>
</html>
