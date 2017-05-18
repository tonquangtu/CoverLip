<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 17-May-17
  Time: 1:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../common/common_lib.jsp"%>
   <link rel="stylesheet" href="../../../resources/styles/menu1.css">
   <style>


   </style>
</head>
<body>
<div class="box-header" id="header">
    <div class="wrap">
        <div class="content-wrap">
            <a class="logo" title="Nghe Nhạc MP3 Online 320kps mới nhất" alt="Nghe Nhac MP3 Online 320kps moi nhat" href="http://www.nhaccuatui.com/"></a>
            <div class="menu-subdomain">
                <a href="http://www.nhaccuatui.com/" class="active">Nhạc</a>
                <a href="http://v.nhaccuatui.com" target="_blank">VIDEO</a>
            </div>
            <div id="box_search_quick" class="box_search">
                <div class="bg-top-noel"></div>
                <form id="formSearchQuick" method="GET" action="http://www.nhaccuatui.com/tim-kiem" onsubmit="return NCTQuickSearch.buttonSearchProcess();">
                    <input id="txtSearch" maxlength="45" name="q" class="i-search" value="" rel="Tìm bài hát, video, playlist, ca sĩ" autocomplete="off" type="text">
                    <input id="btnSearch" class="b-search" value="TÌM KIẾM" type="submit">
                    <div class="list-keyword" id="divHotKeyword">
                    </div>
                </form>
                <div id="divSuggestion" class="hideShowCase suggestion" m="0">
                    <div style="float:left; width:446px; max-height: 450px;">
                        <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 0px;">
                            <div id="idScrllSuggestion" style="overflow: hidden; width: auto; height: 0px;">
                            <ul id="contentSuggestion" class="content_search" style="text-transform:capitalize;">

                            </ul>
                        </div>
                            <div class="slimScrollBar" style="background: rgb(0, 0, 0) none repeat scroll 0% 0%; width: 7px; position: absolute; top: 0px; opacity: 0.4; display: block; border-radius: 7px; z-index: 99; right: 1px;">
                            </div>
                            <div class="slimScrollRail" style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: rgb(51, 51, 51) none repeat scroll 0% 0%; opacity: 0.2; z-index: 90; right: 1px;">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="box_user_login" class="box_user_login">

                <div class="avatar" style="float: right;">
                    <a id="btnShowBoxLogin" title="Đăng nhập" rel="nofollow">Đăng nhập</a> |
                    <a title="Upload" rel="nofollow">Upload</a>
                </div>

                <div class="avatar_user">
                    <a href="javascript:;" id="showBoxUserProfile" style="text-overflow: ellipsis;overflow: hidden;white-space: nowrap;max-width: 225px;" title="Trang cá nhân của null667726456705909" class="link_user">
                        <span class="noel-cap"></span>
                        <img src="http://stc.id.nixcdn.com/v11/images/avatar_default.jpg" onerror="common.handleErrorImage(this, 'http://stc.id.nixcdn.com/v11/images/avatar_default.jpg', 'fail');" onload="common.handleErrorImage(this, 'http://stc.id.nixcdn.com/v11/images/avatar_default.jpg','');" alt="trang ca nhan cua null667726456705909" title="Trang cá nhân của null667726456705909" width="32" height="32">
                        <span style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap; max-width: 160px;">null667726456705909</span>
                    </a>
                </div>
                <div id="user_control" class="menu_user_show hideShowCase">
                    <span class="dot_show_menu"></span>
                    <ul>
                        <li><a rel="nofollow" href="http://www.nhaccuatui.com/user/null667726456705909.html" title="Trang cá nhân">Trang cá nhân</a></li>

                        <li><a rel="nofollow" href="http://www.nhaccuatui.com/user/null667726456705909.quan-ly.html" title="Quản lý tài khoản">Tài khoản</a></li>


                        <li class="vipnct"><a onclick="_gaq.push(['_trackEvent', 'User', 'Click', 'History']);" href="http://www.nhaccuatui.com/user/null667726456705909.lich-su-nghe-nhac.html" title="Lịch sử nghe nhạc">Lịch sử<span class="new"></span></a></li>
                        <li><a href="https://sso.nct.vn/auth/logout?ru=http://www.nhaccuatui.com/ajax/user?type=logout" title="Thoát">Thoát</a></li>
                    </ul>
                </div>
                <script type="text/javascript">
                    NCTLogin.loginLoad();

                </script>

            </div>
        </div>
    </div>
</div>



</body>
</html>
