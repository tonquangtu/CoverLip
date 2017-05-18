<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 17-May-17
  Time: 7:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>

    <%@ include file="../common/common_lib.jsp" %>
    <link rel="stylesheet" href="../../../resources/styles/main_header1_style.css">
    <script src="../../../resources/scripts/main_header1_script.js"></script>


</head>
<body>

<div class="header-box" id="header">

   <div class="container">
       <div class="header">

           <a class="logo" title="Cùng thưởng thức những bài cover tuyệt đỉnh cùng CoverLip" href="/"></a>
           <div class="super-menu">
               <a href="http://localhost:8080/cover" class="active">COVER</a>
               <a href="http://localhost:8080/lipsync" target="_blank">LIP-SYNC</a>
           </div>

           <div id="quick-search-box" class="search-box">
               <%--<div class="bg-top-noel"></div>--%>
               <form id="quickFormSearch" method="GET" action="#" onsubmit="">
                   <input id="txtSearch" maxlength="45" name="q" class="i-search" value="" rel="Tìm bài hát, video, playlist, ca sĩ" autocomplete="off" type="text">
                   <input id="btnSearch" class="b-search" value="TÌM KIẾM" type="submit">
                   <div class="list-keyword" id="divHotKeyword">
                   </div>
               </form>

                   <div id="divSuggestion" class="suggestion" m="0">
                       <div style="float:left; width:446px; max-height: 450px;">
                           <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; max-height: 450px;">
                               <div id="idScrllSuggestion" style="overflow: hidden; width: auto; max-height: 450px;">
                               <ul id="contentSuggestion" class="content_search" style="text-transform:capitalize;">
                                   <li id="liTopKeyWordFirst">
                                       <h3 class="title_row">Top từ khóa tìm kiếm nhiều nhất</h3>
                                       <ul id="ulTopKeyWord" class="info-search">
                                           <li id="li0" class="top-search" rel="0">
                                               <a class="tkw" href="http://www.nhaccuatui.com/tim-kiem?q=Còn+Nơi+Đó+Chờ+Em">
                                                   <span class="top-number top-number-1">1</span>
                                                   <span>Còn Nơi Đó Chờ Em</span>
                                               </a>
                                           </li>
                                           <li id="li1" class="top-search" rel="1">
                                               <a class="tkw" href="http://www.nhaccuatui.com/tim-kiem?q=Ngày+Mai+Sẽ+Khác">
                                                   <span class="top-number top-number-2">2</span>
                                                   <span>Ngày Mai Sẽ Khác</span>
                                               </a>
                                           </li>
                                           <li id="li2" class="top-search" rel="2">
                                               <a class="tkw" href="http://www.nhaccuatui.com/tim-kiem?q=Kết+Thúc+Lâu+Rồi">
                                                   <span class="top-number top-number-3">3</span>
                                                   <span>Kết Thúc Lâu Rồi</span>
                                               </a>
                                           </li>
                                           <li id="li3" class="top-search" rel="3">
                                               <a class="tkw" href="http://www.nhaccuatui.com/tim-kiem?q=Signal">
                                                   <span class="top-number top-number-4">4</span>
                                                   <span>Signal</span>
                                               </a>
                                           </li>
                                           <li id="li4" class="top-search" rel="4">
                                               <a class="tkw" href="http://www.nhaccuatui.com/tim-kiem?q=Symphony">
                                                   <span class="top-number top-number-5">5</span>
                                                   <span>Symphony</span>
                                               </a>
                                           </li>
                                       </ul>
                                   </li>
                               </ul>
                           </div>
                               <div class="slimScrollBar" style="background: rgb(0, 0, 0) none repeat scroll 0% 0%; width: 7px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 312px;"></div>
                               <div class="slimScrollRail" style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: rgb(51, 51, 51) none repeat scroll 0% 0%; opacity: 0.2; z-index: 90; right: 1px;"></div>
                           </div>
                       </div>
                   </div>

           </div>

           <div id="user_login_box" class="user-login-box">

               <div class="avatar" style="float: right;">
                   <a id="btnShowBoxLogin" title="Đăng nhập" rel="nofollow" href="#">Đăng nhập</a> |
                   <a title="Upload" rel="nofollow" href="#">Upload</a>
               </div>

           </div>


       </div>
   </div>




</div>


</body>
</html>
