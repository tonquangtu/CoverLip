<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 17-May-17
  Time: 7:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="targetPage" scope="page" value="${requestScope.targetPage}"/>
<div class="main-menu header-shadow">
    <div class="header-box" id="header">
        <div class="container">
            <div class="header">

                <a class="logo" title="Cùng thưởng thức những bài cover tuyệt đỉnh cùng CoverLip" href="/cover"></a>
                <div class="super-menu">

                    <c:choose>
                        <c:when test="${targetPage eq 'cover_home_page'}">
                            <a href="/cover" class="active">COVER</a>
                            <a href="/lipsync">LIP-SYNC</a>
                            <c:set var="typeVideo" value="1" scope="page"/>
                        </c:when>

                        <c:otherwise>
                            <a href="/cover" >COVER</a>
                            <a href="/lipsync" class="active">LIP-SYNC</a>
                            <c:set var = "typeVideo" value="2" scope="page"/>
                        </c:otherwise>
                    </c:choose>


                </div>

                <div id="quick-search-box" class="search-box">
                    <%--<div class="bg-top-noel"></div>--%>
                    <form id="quickFormSearch" method="GET" action="/search" onsubmit="">
                        <input id="txtSearch" maxlength="45" name="searchString" class="i-search" value="" placeholder="Tìm video, ca sĩ" autocomplete="off" type="text">
                        <input type="hidden" name="limit" value="50">
                        <input type="hidden" name="type" value="${typeVideo}">
                        <input id="btnSearch" class="b-search" value="TÌM KIẾM" type="submit">
                        <div class="list-keyword" id="divHotKeyword">
                        </div>
                    </form>
                    <%@include file="search_card.jsp"%>
                </div>
                <div id="user_login_box" class="user-login-box">

                    <div class="avatar" style="float: right;">
                        <sec:authorize access="isAuthenticated()">
                            <a href="/personal"><sec:authentication property="principal.accountEntity.fullname"/></a> |
                        </sec:authorize>

                        <sec:authorize access="!isAuthenticated()">
                            <a id="btnShowBoxLogin" title="Đăng nhập" rel="nofollow" href="/login">Đăng nhập</a> |
                        </sec:authorize>
                        <a title="Upload" rel="nofollow" href="/personal/upload">Upload</a>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <div id="submenu" class="sub-menu-header">
        <div class="container">

            <div class="menu-top">
                <c:choose>

                    <c:when test="${targetPage eq 'cover_home_page'}">
                        <ul class="notifi" id="menuTop">
                            <li class="icon_logo_menu" id="icon_menu_logo">
                                <a href="/cover" title="Trang chủ" class="active">Trang chủ</a>
                            </li>

                            <li class="">
                                <a href="/new-cover" title="Cover mới">Cover mới</a>
                            </li>

                            <li class="">
                                <a href="/hot-cover" title="Cover hot">Cover hot</a>
                            </li>

                            <li class="">
                                <a href="/top-cover" title="Bảng xếp hạng">Bảng xếp hạng</a>
                            </li>

                            <li class="">
                                <a href="/playlist" title="Playlist">Playlist</a>
                            </li>

                            <li class="">
                                <a href="/all-cover" title="Tất cả">Tất cả</a>
                            </li>
                        </ul>
                    </c:when>

                    <c:otherwise>
                        <ul class="notifi" id="menuTop">
                            <li class="icon_logo_menu" >
                                <a href="/lipsync" title="Thịnh hành" class="active">Thịnh hành</a>
                            </li>

                            <li class="">
                                <a href="/new-lipsync" title="Lipsync mới">Lipsync mới</a>
                            </li>

                            <li class="">
                                <a href="/all-lipsync" title="Tất cả">Tất cả</a>
                            </li>
                        </ul>
                    </c:otherwise>

                </c:choose>

            </div>
        </div>
    </div>
</div>

<%--</body>--%>
<%--</html>--%>
