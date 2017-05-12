<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CoverLip</title>
    <%@ include file="../common/common_lib2.jsp" %>

    <link rel="stylesheet" href="/resources/styles/main_navigation_style.css"/>
    <link rel="stylesheet" href="/resources/styles/main_header_style.css"/>
    <link rel="stylesheet" href="/resources/styles/main_footer_style.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/styles/user_style.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/styles/one_card_style.css"/>
    <script src="/resources/libs/scrollslide/courial.js"></script>
    <script src="/resources/scripts/one_card_script.js"></script>
    <script src="/resources/scripts/scroll_card_script.js"></script>
    <script src="/resources/scripts/home_cover_script.js"></script>
    <link rel="stylesheet" href="/resources/styles/top_idol_card_style.css">


</head>
<body>
<%@include file="../common/main_header.jsp" %>

<content>
    <div class="container">
        <div id="header">
            <div id="background_header">
                <img src="https://lh3.googleusercontent.com/-ZUwvi-q7W64/V35mAzJp_tI/AAAAAAAAA2I/-MtU4lWxLPU4GeeOzW6AaucNnHuABqfIQCL0B/w256-h86-n-no/CDO%2B-%2Bgoogleplus-channel-cover.jpg"
                     alt="Ảnh bìa hồ sơ" width="256" height="86">
            </div>
            <div id="content_header">
                <a href="">
                    <img src="https://lh3.googleusercontent.com/-hwqsKUFurB4/AAAAAAAAAAI/AAAAAAAAA1w/TeAKXdDII1Q/s60-p-no/photo.jpg"
                         alt="Ảnh hồ sơ" class="avatar_member">
                </a>
                <div class="col-md-9 text_content">
                    <div class="username" role="button">Cambridge Dictionary
                    </div>
                    <div class="follower">7.626 người theo dõi -
                        <div class="description" role="button">
                            The most popular online dictionary and thesaurus for learners of English
                        </div>
                    </div>

                </div>
                <div class="right_header">
                    <div role="button" class="follow_button">
                        <span class="">
                            <div class="content_button">Following</div>
                        </span>
                    </div>
                </div>
            </div>
        </div>
        <div id="main">
            <div class="section-nav">
                <div class="width-limit">
                    <ul class="col-md-5 col-md-offset-4">
                        <li><a class="posted_history selected" href="">Bài Đã
                            Đăng</a></li>
                        <li><a class="liked_history" href="">Bài Đã Thích</a></li>
                        <li><a class="commented_history" href="">Bài Đã Bình
                            Luận</a></li>
                    </ul>
                </div>
            </div>
            <div style="clear:both; margin-bottom:20px;"></div>
            <div style="overflow:hidden">
                <div id="addHistoryFeed" class="col-md-8" style="padding-right:5px; padding-left:0;">
                    <!-- Main-->
                    <c:forEach var="item" items="${newCoverList}" varStatus="i" end="3">
                        <c:if test="${i.index<12}">
                            <c:if test="${i.index%2==0}">
                                <div class="row" style="margin-left:0; margin-right: -20px;">
                            </c:if>
                            <div class="col-md-6" style="padding-right:20px; padding-left:0">
                                <c:set var="item" value="${item}" scope="request"/>
                                <%@include file="../common/one_card.jsp" %>
                            </div>
                            <c:if test="${i.index%2==1}">
                                </div>
                            </c:if>
                        </c:if>
                    </c:forEach>
                </div>
                <div class="col-md-4" style="padding-right:0;">
                    <div class="top_idol">
                        <div id="top_cover_idol">
                            <h3 id="title_top_cover_idol">TOP COVER IDOL</h3>
                            <ul>
                                <c:forEach begin="0" end="4" varStatus="i">
                                    <li class="item_top_cover_idol">
                                        <img src="/resources/storage/image/thumbnail/owner_thumbnail/avatar1.jpg"
                                             class="img-circle" alt="top cover idol">
                                        <div class="idol_info">
                                            <p><strong>Minh Anh</strong></p>
                                            <p><fmt:formatNumber>30000</fmt:formatNumber></p>
                                        </div>
                                        <button type="button" class="btn btn-success btn-sm">Theo doi</button>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div id="addHistoryFeed2" style="padding-right:5px; padding-left:0;">
                <!-- Main-->
                <c:forEach var="item" items="${newCoverList}" varStatus="i" begin="4">
                    <c:if test="${i.index<12}">
                        <c:if test="${(i.index+2)%3==0}">
                            <div class="row" style="margin-left:0; margin-right: -20px;">
                        </c:if>
                        <div class="col-md-4" style="padding-right:20px; padding-left:0">
                            <c:set var="item" value="${item}" scope="request"/>
                            <%@include file="../common/one_card.jsp" %>
                        </div>
                        <c:if test="${(i.index+2)%3==2}">
                            </div>
                        </c:if>
                        <c:if test = "${i.index==11&&(i.index+2)%3!=2}">
                            </div>
                        </c:if>
                    </c:if>
                </c:forEach>
                <br><br>

            </div>
            <div class="show_box" feedid="">
                <div class="modal fade" id="show_box_report">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                                </button>
                                <h4 class="modal-title">Hãy nói cho chúng tôi điều gì xảy ra với bài đăng này</h4>
                            </div>
                            <div class="modal-body">
                                <div class="img_report">
                                    <img src="" class="img-responsive">
                                </div>
                                <div class="content_report">
                                    <div class="radio">
                                        <label><input name="choose_report" value="2" type="radio">Có tôi trong bài
                                            đăng này, tôi không muốn mọi người xem.</label>
                                    </div>
                                    <div class="radio">
                                        <label><input name="choose_report" value="3" type="radio">Đây là spam, không
                                            đúng chủ đề.</label>
                                    </div>
                                    <div class="radio">
                                        <label><input name="choose_report" value="4" type="radio">Bài đăng chứa nội
                                            dung nhạy cảm, không phù hợp.</label>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary send_report" disabled="">Gửi</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="loading" currentfeedid="" type="posted">
                <span><img class="loadicon" src="/resources/icons/loadding.svg" style="width:50px"></span>
                <span>Đang tải dữ liệu...</span>
            </div>
        </div>
    </div>
</content>
<%@ include file="/WEB-INF/views/common/main_footer.jsp" %>
</body>
</html>