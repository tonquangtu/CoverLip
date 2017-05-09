
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>${cover.coverName}</title>
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge">
    <meta title="I'm Losing You">

    <%@ include file="../common/common_lib.jsp" %>
    <!--Play One Video Page Script-->
    <script src="../../../resources/scripts/video_player_script.js"></script>

    <!--Play one video style-->
    <link rel="stylesheet" href="../../../resources/styles/video_player_style.css">

    <link rel="stylesheet" href="../../../resources/styles/main_navigation_style.css">

    <link rel="stylesheet" href="../../../resources/styles/main_header_style.css">

    <link rel="stylesheet" href="../../../resources/styles/main_footer_style.css">

    <!--Lib video player-->
    <link rel="stylesheet" href="../../../resources/libs/videoplayer/mediaelementplayer.min.css">

    <!--Facebook header-->
    <meta property="og:url"           content="http://localhost:63342/CoverLip.com/html/play_one_video_page.html" />
    <meta property="og:type"          content="website" />
    <meta property="og:title"         content="I'm Losing You" />
    <meta property="og:description"   content="Cover Hay cua chang ngoc" />
    <meta property="og:image"         content="http://www.your-domain.com/path/image.jpg" />

    <!--------------------------------------------------------------------------------------->

</head>
<body>

<!-- Load Facebook SDK for JavaScript -->
<div id="fb-root"></div>
<script src="../../../resources/libs/facebooksdk/facebook_sdk_script.js"></script>
<!------------------------------------------------------------------------..---------------------->

<%@include file="../common/main_header.jsp"%>

<div class="content container">

    <div style="height:30px; width: 100%"></div>
    <div class="row">

        <div class="col-md-8 column-content">
           <div class="video-content-box box-shadow">
               <div class="media-wrapper">
                   <video id="player1" width="750" height="460">
                       <source   type="video/mp4"  src="${cover.video.videoLink}"/>


                       <!-- <track srclang="en" label="English" kind=
                       ib/mediaelement.vtt"> -->
                       <!--  <track srclang="en" kind="chapters" src="video lib/chapters.vtt">  -->
                   </video>
               </div>

               <div class="video-detail-box">

                   <div class="video-title-box">
                       <h1><a class="video-title pull-left" href="#">${cover.coverName}</a></h1>
                       <ul class="video-counter">
                           <li class="like-counter-box ">
                               <img class="icon-like" src="../../../resources/icons/icon_like.svg"/>
                               <span class="like-counter">${cover.video.numLike}</span>
                           </li>

                           <li class="comment-counter-box ">
                               <img class="icon-comment" src="../../../resources/icons/icon_comment.svg">
                               <span class="comment-counter">${cover.video.numComment}</span>
                           </li>

                           <li class="view-counter-box ">
                               <img class="icon-view" src="../../../resources/icons/icon_view.svg">
                               <span class="view-counter">${cover.video.numView}</span>
                           </li>

                       </ul>

                   </div>
                   <div class="divider"></div>
                   <div class="line-horizontal-left">
                       <div class="video-owner-box pull-left">
                           <a class="video-owner-thumbnail" style = "background-image: url('http://avatar.muvik.tv/d/iidm9c');" href="#"></a>
                           <a class="video-owner-name center-vertical" href="#">${cover.video.account.fullname}</a>
                       </div>
                   </div>
                   <div class="time-upload-video pull-right">Đăng từ <span>2 ngày trước</span></div>

                   <div class="divider"></div>

                   <div class="line-horizontal-left btn-group-interact-video">
                       <button id="btn-follow" class="btn btn-template btn-follow " type="button">Theo dõi Idol</button>
                       <button class="btn btn-template btn-add-favorite " type= "button">Thêm vào danh sách yêu thích</button>

                   </div>

                   <div class="line-horizontal-right btn-group-interact-video">
                       <button class="btn btn-template btn-download " type= "button">Tải về</button>
                       <button class="btn btn-template btn-report " type= "button">Báo cáo vi phạm</button>
                   </div>

                   <div class="fb-like"
                        data-href="http://localhost:63342/CoverLip.com/html/play_one_video_page.html"
                        data-width="700"
                        data-layout="standard"
                        data-action="like"
                        data-size="large"
                        data-show-faces="true"
                        data-share="true">
                   </div>

               </div>

               <h3 class="comment-title center-vertical-content">BÌNH LUẬN</h3>
               <div class="fb-comments custom-fb-comment"
                    data-href="http://localhost:63342/CoverLip.com/html/play_one_video_page.html"
                    data-width="100%"
                    data-numposts="5">
               </div>
           </div>

        </div>


        <!--End Column Content----------------------------------------------------------------------------------------->

        <!--Start column suggestion-->
        <div class="col-md-4 column-suggestion-video">

            <h3 class="title-box box-shadow">
                <a class="column-suggestion-title center-vertical-content" href="#" title="Xem tất cả các video liên quan">VIDEO LIÊN QUAN</a>
            </h3>
            <ul class="list-suggestion-video">
                <li class="suggestion-video-item box-shadow">

                    <a href="#">
                        <div class="video-thumbnail-box">
                            <img class="video-thumbnail" src="../../../resources/storage/image/thumbnail/owner_thumbnail/thumbnail_singer_2.jpg"/>
                        </div>
                    </a>

                    <a href="#">
                        <div class="thumb-mask"></div>
                    </a>

                    <div class="suggestion-video-info">

                        <div class="suggestion-video-owner-box pull-left">
                            <a class="suggestion-video-owner-thumbnail" style = "background-image: url('http://avatar.muvik.tv/7/iiXMWN');" href="#"></a>
                            <a class="suggestion-video-owner-name center-vertical" href="#">Thúy Phương Tạ Thi</a>
                        </div>

                        <div>
                            <a class="suggestion-video-title center-vertical-content" href="#">Vài Lần Đón Đưa - Soobin Hoàng Sơn</a>
                        </div>

                    </div>

                    <a href="#">
                        <span class="icon-play"></span>
                    </a>

                </li>

                <li class="suggestion-video-item box-shadow">

                    <a href="#">
                        <div class="video-thumbnail-box">
                            <img class="video-thumbnail" src="../../../resources/storage/image/thumbnail/owner_thumbnail/thumbnail_singer_3.jpg"/>
                        </div>
                    </a>

                    <a href="#">
                        <div class="thumb-mask"></div>
                    </a>

                    <div class="suggestion-video-info">

                        <div class="suggestion-video-owner-box pull-left">
                            <a class="suggestion-video-owner-thumbnail" style = "background-image: url('http://avatar.muvik.tv/7/iiXMWN');" href="#"></a>
                            <a class="suggestion-video-owner-name center-vertical" href="#">Thanh Trần</a>
                        </div>

                        <div>
                            <a class="suggestion-video-title center-vertical-content" href="#">Lời tỏ tình - Sơn Ngọc Minh ft Hariwon</a>
                        </div>

                    </div>

                    <a href="#">
                        <span class="icon-play"></span>
                    </a>

                </li>

                <li class="suggestion-video-item box-shadow">

                    <a href="#">
                        <div class="video-thumbnail-box">
                            <img class="video-thumbnail" src="../../../resources/storage/image/thumbnail/owner_thumbnail/thumbnail_singer_4.jpg"/>
                        </div>
                    </a>

                    <a href="#">
                        <div class="thumb-mask"></div>
                    </a>

                    <div class="suggestion-video-info">

                        <div class="suggestion-video-owner-box pull-left">
                            <a class="suggestion-video-owner-thumbnail" style = "background-image: url('http://avatar.muvik.tv/7/iiXMWN');" href="#"></a>
                            <a class="suggestion-video-owner-name center-vertical" href="#">Dương Minh Hằng</a>
                        </div>

                        <div>
                            <a class="suggestion-video-title center-vertical-content" href="#">Là con gái thật tuyệt - Khởi My</a>
                        </div>

                    </div>

                    <a href="#">
                        <span class="icon-play"></span>
                    </a>

                </li>

                <li class="suggestion-video-item box-shadow">

                    <a href="#">
                        <div class="video-thumbnail-box">
                            <img class="video-thumbnail" src="../../../resources/storage/image/thumbnail/owner_thumbnail/thumbnail_singer_5.jpg"/>
                        </div>
                    </a>

                    <a href="#">
                        <div class="thumb-mask"></div>
                    </a>

                    <div class="suggestion-video-info">

                        <div class="suggestion-video-owner-box pull-left">
                            <a class="suggestion-video-owner-thumbnail" style = "background-image: url('http://avatar.muvik.tv/7/iiXMWN');" href="#"></a>
                            <a class="suggestion-video-owner-name center-vertical" href="#">Ánh Ngọc Lê</a>
                        </div>

                        <div>
                            <a class="suggestion-video-title center-vertical-content" href="#">Em đang nghĩ gì - Hoàng Tôn</a>
                        </div>

                    </div>

                    <a href="#">
                        <span class="icon-play"></span>
                    </a>

                </li>

            </ul>

        </div>
    </div>

</div>

<%--<div w3-include-html="../common/main_footer.jsp"></div>--%>

<%--<script type="text/javascript"> w3IncludeHTML();</script>--%>

<%@include file="../common/main_footer.jsp"%>
<script src="../../../resources/libs/videoplayer/mediaelement-and-player.js"></script>
<script src="../../../resources/libs/videoplayer/video_controller.js"></script>
</body>
</html>
