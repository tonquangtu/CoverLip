<%--
  Created by IntelliJ IDEA.
  User: nguyenthanhtung
  Date: 25/04/2017
  Time: 08:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CoverLip</title>
    <%@ include file="../common/common_lib.jsp" %>

    <link rel="stylesheet" href="/resources/styles/main_navigation_style.css"/>
    <link rel="stylesheet" href="/resources/styles/main_header_style.css"/>
    <link rel="stylesheet" href="/resources/styles/main_footer_style.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/styles/home_cover_style.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/styles/one_card_style.css"/>
    <script src="/resources/libs/scrollslide/courial.js"></script>
    <script src="/resources/scripts/one_card_script.js"></script>
    <script src="/resources/scripts/scroll_card_script.js"></script>
    <script src="/resources/scripts/home_cover_script.js"></script>

</head>
<body>
<%@include file="../common/main_header.jsp" %>

<content>
    <div id="slider" class="container">
        <div id="carousel-id" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carousel-id" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-id" data-slide-to="1" class=""></li>
                <li data-target="#carousel-id" data-slide-to="2" class=""></li>
            </ol>
            <div class="carousel-inner">
                <div class="item active">
                    <img class="img-responsive" data-src="" alt="First slide"
                         src="/resources/storage/image/normal_image/slide_image/phiasaumotcogai.jpg">
                    <div class="background-gadian"></div>
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Phia Sau Mot Co Gai</h1>
                            <p>Mot ban cover di vao long nguoi cua hot girl Beo La</p><br>
                            <p><a class="btn btn-lg btn-primary" href="#" role="button">Xem ngay</a></p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="img-responsive" data-src="" alt="Second slide"
                         src="/resources/storage/image/normal_image/slide_image/didetrove.jpg">
                    <div class="background-gadian"></div>
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Di De Tro Ve</h1>
                            <p>Le Roi tro lai voi ban hit dinh dam "Di de tro ve"</p><br>
                            <p><a class="btn btn-lg btn-primary" href="#" role="button">Xem ngay</a></p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="img-responsive" data-src="" alt="Third slide"
                         src="/resources/storage/image/normal_image/slide_image/lactroi.jpg">
                    <div class="background-gadian"></div>
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Lac Troi</h1>
                            <p>Girl Xinh Maria Ozawa cover hit Lac Troi cua Son Tung MTP</p><br>
                            <p><a class="btn btn-lg btn-primary" href="#" role="button">Xem ngay</a></p>
                        </div>
                    </div>
                </div>
            </div>
            <a class="left carousel-control" href="#carousel-id" data-slide="prev"><span
                    class="glyphicon glyphicon-chevron-left"></span></a>
            <a class="right carousel-control" href="#carousel-id" data-slide="next"><span
                    class="glyphicon glyphicon-chevron-right"></span></a>
        </div>
    </div> <!-- slider -->
    <div id="main_content" class="container">
        <!-- List video -->
        <div class="new_list_content">
            <!-- Page Header -->
            <div class="row title">
                <div class="col-lg-12">
                    <h1 class="page-header">Mới Đăng
                        <!-- <small>Secondary Text</small> -->
                        <div class="action_slide">
                            <div class="btn-group">
                                <button type="button" class="btn btn-primary next_first"><span
                                        class="glyphicon glyphicon-chevron-up"></span></button>
                                <button type="button" class="btn btn-primary prev_first"><span
                                        class="glyphicon glyphicon-chevron-down"></span></button>
                            </div>
                        </div>
                    </h1>
                </div>
            </div>
            <!-- /.row -->

            <!-- Projects Row -->
            <div class="row" style="overflow:hidden;">
                <div class="col-md-3 text-center">
                    <div class="subject">
                        <a href="#">
                            <img class="img-responsive"
                                 src="/resources/storage/image/normal_image/slide_image/singer.jpg" alt="">
                        </a>
                        <h3>
                            <a href="#">Mới Đăng</a>
                        </h3>
                        <!-- <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p> -->
                        <a href=""><button type="button" class="btn btn-primary">Xem toàn bộ</button></a>
                    </div>
                </div>

                <div class="col-md-9" style="padding-right:0;padding-left:0;">
                    <% int m=0; %>
                    <c:forEach var="item" items="${newCoverList}" varStatus="i">
                        <c:if test="${i.index<12}">
                            <c:if test="${i.index%4==0}" >
                                <ul id="demo_first_<%= m++%>" class="one_list">
                            </c:if>
                                <c:set var="item" value="${item}" scope="request"/>
                                <%@ include file="../common/one_card.jsp" %>
                            <c:if test="${i.index%4==3}">
                                </ul>
                            </c:if>
                        </c:if>
                    </c:forEach>

                    <br><br>

                    <div style="display:none!important;">
                        <button class="next_first_1"></button>
                        <button class="next_first_2"></button>
                        <button class="next_first_3"></button>
                        <button class="prev_first_1"></button>
                        <button class="prev_first_2"></button>
                        <button class="prev_first_3"></button>
                    </div>
                </div>
            </div>
            <!-- /.row -->
        </div>

        <div class="hot_list_content">
            <!-- Page Header -->
            <div class="row title">
                <div class="col-lg-12">
                    <h1 class="page-header">Cover Hot
                        <!-- <small>Secondary Text</small> -->
                        <div class="action_slide">
                            <div class="btn-group">
                                <button type="button" class="btn btn-primary next_second"><span
                                        class="glyphicon glyphicon-chevron-up"></span></button>
                                <button type="button" class="btn btn-primary prev_second"><span
                                        class="glyphicon glyphicon-chevron-down"></span></button>
                            </div>
                        </div>
                    </h1>
                </div>
            </div>
            <!-- /.row -->

            <!-- Projects Row -->
            <div class="row" style="overflow:hidden;">
                <div class="col-md-3 text-center">
                    <div class="subject">
                        <a href="#">
                            <img class="img-responsive"
                                 src="/resources/storage/image/normal_image/slide_image/singer.jpg" alt="">
                        </a>
                        <a href="#">
                            <h3>
                            Cover Hot
                            </h3>
                        </a>
                        <!-- <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p> -->
                        <a href="#"><button type="button" class="btn btn-primary">Xem toàn bộ</button></a>
                    </div>
                </div>

                <div class="col-md-9" style="padding-right:0;padding-left:0;">
                    <% m=0; %>
                    <c:forEach var="item" items="${hotCoverList}" varStatus="i">
                        <c:if test="${i.index<12}">
                            <c:if test="${i.index%4==0}" >
                                <ul id="demo_second_<%= m++%>" class="one_list">
                            </c:if>
                                <c:set var="item" value="${item}" scope="request"/>
                                <%@ include file="../common/one_card.jsp" %>
                            <c:if test="${i.index%4==3}">
                                </ul>
                            </c:if>
                        </c:if>
                    </c:forEach>
                    <br><br>
                    <div style="display:none!important;">
                        <button class="next_second_1"></button>
                        <button class="next_second_2"></button>
                        <button class="next_second_3"></button>
                        <button class="prev_second_1"></button>
                        <button class="prev_second_2"></button>
                        <button class="prev_second_3"></button>
                    </div>
                </div>
            </div>
            <!-- /.row -->
        </div>


        <!-- Cover hay moi ngay -->
        <div class="cover_list_content">
            <!-- Page Header -->
            <div class="row title">
                <div class="col-lg-12">
                    <a href="#"><h1 class="page-header">Cover Hay Mỗi Ngày</h1></a>
                </div>
            </div>
            <!-- /.row -->

            <!-- Projects Row -->
            <div class="row" style="overflow:hidden;">

                <div class="col-md-12" style="padding-right:0;padding-left:0;">
                    <c:forEach var="item" items="${newCoverList}" varStatus="i">
                        <c:if test="${i.index<12}">
                            <c:if test="${i.index%4==0}">
                                <div class="row" style="margin-right: 0px; margin-left: 15px;">
                            </c:if>
                            <div class="col-md-3" style="padding-right:12px; padding-left:0">
                                <c:set var="item" value="${item}" scope="request"/>
                                <%@include file="../common/one_card.jsp" %>
                            </div>
                            <c:if test="${i.index%4==3}">
                                </div>
                            </c:if>
                        </c:if>
                    </c:forEach>
                    <br><br>
                </div>
            </div>
            <!-- /.row -->
        </div>

        <div class="top_member">
            <!-- Page Header -->
            <div class="row title">
                <div class="col-lg-12">
                    <a href=""><h1 class="page-header">Top Người Đăng Nổi Bật
                    </h1></a>
                </div>
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-md-3">
                    <div class="one_member text-center subject" style="padding-bottom:10px;box-shadow:unset">
                        <a href="">
                            <img src="${topIdolList.get(0).user.account.avatarThumbnail}" alt="${topIdolList.get(0).user.account.fullname}"
                                 class="img-responsive" style="width:100%">
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
                                    <img src="${item1.user.account.avatarThumbnail}" alt="${item1.user.account.fullname}"
                                         class="img-responsive img-circle">
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
    </div> <!-- main content -->
</content>

<%@ include file="/WEB-INF/views/common/main_footer.jsp" %>
</body>
</html>
