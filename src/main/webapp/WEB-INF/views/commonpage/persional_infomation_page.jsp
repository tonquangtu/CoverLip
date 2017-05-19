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
    <link rel="stylesheet" href="../../../resources/styles/persional_infomation_style.css">

    <script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>

    <script type="text/javascript" src="../../../resources/scripts/persional_infomation_script.js"></script>

</head>
<body>
<%@include file="../common/main_header.jsp" %>

<content>
    <div class="container">
        <div class="">
            <div class="col-md-3 float-left" role="navigation">
                <nav class="menu" data-pjax="">
                    <h3 class="menu-heading">
                        Cài Đặt Thông Tin
                    </h3>
                    <a href="" class="">Thông Tin</a><br/>
                    <a href="">Thay Đổi Mật Khẩu</a>
                </nav>
            </div>
            <div class="col-md-9 float-left">
                <!-- Public Profile -->
                <div class="Subhead">
                    <h2 class="Subhead-heading">Thông Tin Công Khai</h2>
                </div>

                <form accept-charset="UTF-8" action="" class="" method="post">
                    <dl class="form-group float-right col-md-4">
                        <dt><label>Profile picture</label></dt>
                        <dd class="" style="padding:0; width:100%;">
                            <img alt="" class="avatar" src="/resources/storage/image/thumbnail/owner_thumbnail/avatar1.jpg">
                            <div class="btn btn-success avatar-upload">
                                <label>
                                    Cập Nhật Ảnh Đại Diện
                                    <input type="file">
                                </label>
                            </div>
                        </dd>
                    </dl>

                    <div class="col-md-8">
                        <dl class="form-group">
                            <dt><label for="user_profile_name">Họ Và Tên</label></dt>
                            <dd><input class="form-control" id="user_profile_name" name="" size="30"
                                       value="Nguyen Thanh Tung" type="text"></dd>
                        </dl>
                        <dl class="form-group">
                            <dt><label>Email</label></dt>
                            <input type="email" class="form-control"/>
                        </dl>
                        <dl class="form-group">
                            <dt><label for="user_profile_bio">Mô tả </label></dt>
                            <dd class="">
                                <textarea
                                        class="form-control"
                                        cols="20" id="user_profile_bio"
                                        name="" placeholder="Hãy nói một chút về bạn!"
                                        rows="7"></textarea>
                                <div class="suggester-container">
                                    <div class="suggester"
                                         data-url="/autocomplete/user-suggestions">
                                    </div>
                                </div>
                            </dd>
                        </dl>
                        <dl class="form-group">
                            <dt><label>Ngày sinh</label></dt>
                            <dd><input class="form-control" id="calendar" name="" size="30"
                                       value="" type="date"></dd>
                        </dl>
                        <dl class="form-group">
                            <dt><label for="user_profile_company">Company</label></dt>
                            <dd class="">
                                <input autocomplete="off" class="form-control"
                                       id="user_profile_company" name="" size="30" value=""
                                       type="text">
                                <div class="suggester-container">
                                    <div class=""
                                         data-url="/autocomplete/organizations">
                                    </div>
                                </div>
                            </dd>
                        </dl>
                        <dl class="form-group">
                            <dt><label for="user_profile_location">Địa Chỉ: </label></dt>
                            <dd><input class="form-control" id="user_profile_location" name=""
                                       size="30" value="" type="text"></dd>
                        </dl>
                        <p>
                            <button type="submit" class="btn btn-success">Cập nhật</button>
                        </p>
                    </div>
                </form>
            </div>
        </div>
    </div>
</content>
</body>
</html>

