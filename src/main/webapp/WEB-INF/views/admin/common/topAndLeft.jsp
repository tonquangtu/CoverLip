<%--
  Created by IntelliJ IDEA.
  User: Khanh Nguyen
  Date: 13/5/2017
  Time: 7:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="username" property="principal.username"/>
<div id="top-nav" class="shadow">
    <div class="pull-left">
        <div class="site-title"> <!--<div class="menu-container" onclick="myFunction(this)">-->
            <!--<div class="bar1"></div>--> <!--<div class="bar2"></div>--> <!--<div class="bar3"></div>-->
            <!--</div>--> <!--<span class="glyphicon glyphicon-home"></span>--> <span
                    style="font-size: 30px; cursor: pointer" class="toggle-open">&#9776;
				open</span> <a href="/"><span>CoverLip</span></a>
        </div>
    </div>
    <div class="admin pull-right flex">
        <div class="admin-name">
            <img class="img-circle"
                 src="resources/icons/profile.jpg"
                 alt="null"> <span>${username} <i
                class="glyphicon glyphicon-chevron-down" style="font-size: 10px;"></i></span>
        </div>

        <form action="<c:url value="/logout"/>" method="POST" id="logoutForm">
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
        </form>
        <script>
            function formSubmit() {
                document.getElementById("logoutForm").submit();
            }
        </script>

        <ul class="admin-content shadow">
            <li><a href="#"> <span>Profile</span>
            </a></li>
            <li><a href="#"> <span>Settings</span> <span
                    class="badge bg-red pull-right">50%</span>
            </a></li>
            <li><a href="#"> <span>Help</span>
            </a></li>
            <li><a href="javascript:formSubmit()"> <span>Logout</span>
                <span class="glyphicon glyphicon-log-out pull-right"></span>
            </a></li>
        </ul>
    </div>
    <div class="pull-right" id="env-content">
        <i class="glyphicon glyphicon-envelope envelope"> <span
                class="badge">9</span>
        </i>
    </div>
</div>

<div id="left-nav" class="right-nav-shadow">
    <div class="profile">
        <div class="profile-pic">
            <img class="img-circle profile-image"
                 src="resources/icons/profile.jpg"
                 alt="null">
        </div>
        <div class="profile-info">
            <span>Welcome,</span>
            <h2>${username}</h2>
        </div>
        <span class="closebtn toggle-open">&times;</span>
    </div>
    <div style="clear: both;"></div>
    <div id="left-nav-content">
        <ul>
            <!-- <li class="list-active"> -->
            <li>
                <div class="left-nav-content-main">
                    <i class="glyphicon glyphicon-cog fa"></i> Quản lý tài khoản <span
                        class="glyphicon glyphicon-chevron-down gl-right"></span>
                </div> <!--  <ul class="child-menu" styte="display: block"> -->
                <ul class="child-menu">
                    <li class="current-page"><a href="#">Danh sách
                        tài khoản</a></li>
                    <li><a href="#">Thêm tài khoản</a></li>
                </ul>
            </li>
            <li>
                <div class="left-nav-content-main">
                    <i class="glyphicon glyphicon-cog fa"></i> Quản lý lộ trình <span
                        class="glyphicon glyphicon-chevron-down gl-right"></span>
                </div>
                <ul class="child-menu">
                    <li class=""><a href="#">Danh sách lộ trình</a></li>
                    <li><a href="#">Dashboard 1</a></li>
                    <li><a href="#">Dashboard 1</a></li>
                </ul>
            </li>
            <li>
                <div class="left-nav-content-main">
                    <i class="glyphicon glyphicon-cog fa"></i> Quản lý lịch chạy <span
                        class="glyphicon glyphicon-chevron-down gl-right"></span>
                </div>
                <ul class="child-menu">
                    <li><a href="#">Lịch chạy</a></li>
                    <li><a href="#">Lịch chạy tuần</a></li>
                </ul>
            </li>
            <li>
                <div class="left-nav-content-main">
                    <i class="glyphicon glyphicon-cog fa"></i> Quản lý tài xế <span
                        class="glyphicon glyphicon-chevron-down gl-right"></span>
                </div>
                <ul class="child-menu">
                    <li class=""><a href="#">Danh sách tài xế</a></li>
                    <li><a href="#">Dashboard 1</a></li>
                    <li><a href="#">Dashboard 1</a></li>
                </ul>
            </li>
            <li>
                <div class="left-nav-content-main">
                    <i class="glyphicon glyphicon-cog fa"></i> Quản lý xe <span
                        class="glyphicon glyphicon-chevron-down gl-right"></span>
                </div>
                <ul class="child-menu">
                    <li class=""><a href="#">Danh sách xe</a></li>
                    <li><a href="#">Dashboard 1</a></li>
                    <li><a href="#">Dashboard 1</a></li>
                    <li><a href="#">Dashboard 1</a></li>
                    <li><a href="#">Dashboard 1</a></li>
                </ul>
            </li>
            <li>
                <div class="left-nav-content-main">
                    <i class="glyphicon glyphicon-cog fa"></i> Thống kê <span
                        class="glyphicon glyphicon-chevron-down gl-right"></span>
                </div>
                <ul class="child-menu">
                    <li class=""><a href="#">Thống kê doanh thu</a></li>
                    <li><a href="#">Dashboard 1</a></li>
                    <li><a href="#">Dashboard 1</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <div id="bottom-left-nav">
        <a href="#"> <span class="glyphicon glyphicon-cog"></span>
        </a> <a href="javascript:void(0)"> <span
            class="glyphicon glyphicon-fullscreen"
            onclick="$(document).fullScreen(true)" title="Full Screen Mode"></span>
    </a> <a href="#"> <span class="glyphicon glyphicon-eye-close"></span>
    </a> <a href="#"> <span class="glyphicon glyphicon-off"></span>
    </a>
    </div>
</div>
