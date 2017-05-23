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
<sec:authentication var="fullName" property="principal.name" />
<div id="top-nav" class="shadow">
    <div class="pull-left">
        <div class="site-title"> <!--<div class="menu-container" onclick="myFunction(this)">-->
            <!--<div class="bar1"></div>--> <!--<div class="bar2"></div>--> <!--<div class="bar3"></div>-->
            <!--</div>--> <!--<span class="glyphicon glyphicon-home"></span>--> <span
                    style="font-size: 30px; cursor: pointer" class="toggle-open">&#9776;
				Menu</span> <a href="/"><span>CoverLip</span></a>
        </div>
    </div>
    <div class="admin pull-right flex">
        <div class="admin-name">
            <img class="img-circle"
                 src="/resources/icons/profile.jpg"
                 alt="null"> <span>${fullName} <i
                class="glyphicon glyphicon-chevron-down" style="font-size: 10px;"></i></span>
        </div>

        <form action="<c:url value="/logout"/>" method="POST" id="logoutForm">
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
        </form>

        <ul class="admin-content shadow">
            <li><a href="#"> <span>Profile</span>
            </a></li>
            <li><a href="#"> <span>Settings</span> <span
                    class="badge bg-red pull-right">50%</span>
            </a></li>
            <li><a href="#"> <span>Help</span>
            </a></li>
            <li><a href="#" id="logout"> <span>Logout</span>
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
                 src="/resources/icons/profile.jpg"
                 alt="null">
        </div>
        <div class="profile-info">
            <span>Welcome,</span>
            <h2>${fullName}</h2>
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
                    <li class="current-page"><a href="/admin/account/list">Danh sách
                        tài khoản</a></li>
                    <li><a href="#">Thêm tài khoản</a></li>
                </ul>
            </li>
            <li>
                <div class="left-nav-content-main">
                    <i class="glyphicon glyphicon-cog fa"></i> Quản lý Cover <span
                        class="glyphicon glyphicon-chevron-down gl-right"></span>
                </div>
                <ul class="child-menu">
                    <li class=""><a href="/admin/cover/list"> Danh sách cover </a></li>
                    <li><a href="#">Danh sách cover</a></li>
                    <li><a href="#">Dashboard 1</a></li>
                </ul>
            </li>
            <li>
                <div class="left-nav-content-main">
                    <i class="glyphicon glyphicon-cog fa"></i> Quản lý lipsync <span
                        class="glyphicon glyphicon-chevron-down gl-right"></span>
                </div>
                <ul class="child-menu">
                    <li><a href="#">Danh sách lipsync</a></li>
                    <li><a href="#">Dashboard</a></li>
                </ul>
            </li>
            <li>
                <div class="left-nav-content-main">
                    <i class="glyphicon glyphicon-cog fa"></i> Quản lý playlist <span
                        class="glyphicon glyphicon-chevron-down gl-right"></span>
                </div>
                <ul class="child-menu">
                    <li class=""><a href="/admin/playlist/list">Danh sách playlist</a></li>
                    <li><a href="#">Dashboard 1</a></li>
                    <li><a href="#">Dashboard 1</a></li>
                </ul>
            </li>
            <li>
                <div class="left-nav-content-main">
                    <i class="glyphicon glyphicon-cog fa"></i> Quản lý người đăng <span
                        class="glyphicon glyphicon-chevron-down gl-right"></span>
                </div>
                <ul class="child-menu">
                    <li class=""><a href="#">Danh sách người đăng </a></li>
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
                    <li class=""><a href="#">Thống kê lượt xem </a></li>
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
