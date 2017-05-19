<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"--%>
         <%--pageEncoding="ISO-8859-1"%>--%>
<header id="header">
    <div id="main_header">
        <div class="container">
            <div id="logo" class="col-md-2">
                <a href="/"><img src="/resources/icons/youtube_logo.png" class="img-responsive"/></a>
            </div><!-- /logo -->
            <div id="menu" class="col-md-3">
                <ul>
                    <li class="col-md-4  text-center active_menu"><a href="#">Cover</a></li>
                    <li class="col-md-4 text-center "><a href="#">Lipsync</a></li>
                    <li class="col-md-4 text-center "><a href="#">Karaoke</a></li>
                </ul>
            </div><!-- /menu -->
            <div id="search" class="col-md-4">
                <form method="GET" id="form-search" action="/">
                    <div>
                        <input name="keyword" placeholder="Tìm: tên clip, ca sĩ" value="" type="text">
                        <input id="searchsubmit" value=" " type="submit">
                    </div>
                </form>
            </div><!-- search -->
            <div id="upload_signin" class="col-md-3 text-right">
                <div class="btn-group">
                    <button type="button" class="btn btn-primary">Upload</button>
                    <button type="button" class="btn btn-primary">Đăng nhập</button>
                </div>
            </div>
        </div>
    </div><!-- /main header -->
    <div id="navigation" class="navigation" style="">
        <div class="container">
            <ul class="navigation navigation-anim-flip navigation-response-to-icons">
                <li><a href="#"><i class="fa fa-home"></i>Trang Chủ</a></li>
                <li><a href="#"><i class="fa fa-edit"></i>Mới</a></li>
                <li><a href="#"><i class="fa fa-edit"></i>Hot</a></li>
                <li><a href="#"><i class="fa fa-edit"></i>Bảng Xếp Hạng</a></li>
                <li><a href="#"><i class="fa fa-edit"></i>Playlist</a></li>
                <li><a href="#"><i class="fa fa-edit"></i>Tất Cả</a></li>
            </ul>
        </div>
    </div><!-- /navigation -->
</header>
<!-- /header -->
