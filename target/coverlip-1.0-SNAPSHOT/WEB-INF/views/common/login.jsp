<%--
  Created by IntelliJ IDEA.
  User: Khanh Nguyen
  Date: 9/5/2017
  Time: 1:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <c:import url="common_lib.jsp"/>
    <link rel="stylesheet" href="/resources/styles/main_header_style.css">
    <link rel="stylesheet" href="/resources/styles/main_navigation_style.css">
    <link rel="stylesheet" href="/resources/styles/main_footer_style.css">
    <link rel="stylesheet prefetch" href="http://fonts.googleapis.com/css?family=Open+Sans:600">
    <link rel="stylesheet" href="/resources/styles/login.css">
    <link rel="stylesheet" href="/resources/styles/admin/common.css">
    <script src="/resources/scripts/login.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/styles/social_button.css">
<body>
<div class="wrapper">
    <div class="main-header">
        <c:import url="main_header.jsp"/>
    </div>
    <div class="main-content container-fluid">
        <div class="login-wrap-1">
            <div class="login-wrap-2">
                <div class="login-wrap">
                    <div class="row">
                        <div class="login-content">
                            <div>
                                <div class="login-title">
                                    Đăng nhập CoverLip
                                </div>
                                <%--<c:if test="${not empty error}">--%>
                                    <%--<div class="alert alert-danger alert-dismissable error-login">--%>
                                        <%--<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>--%>
                                        <%--<span>${error}</span>--%>
                                    <%--</div>--%>
                                <%--</c:if>--%>
                                <c:if test="${not empty param.error}">
                                    <div class="alert alert-danger alert-dismissable error-login-container error-login" style="display: block;">
                                        <a href="#" class="close" data-dismiss="alert" aria-label="close" id="close-error-login">&times;</a>
                                        <span id="error-login-content">Tên đăng nhập hoặc mật khẩu không đúng</span>
                                    </div>
                                </c:if>
                            </div>
                            <form id="loginForm" action="https://localhost:8443/perform_login" method="POST">
                                <%--<form method="POST" action="/perform_login">--%>
                                <%-- We have 4 ways to using csrf--%>
                                <%-- 1. using <sec:csrfInput />--%>
                                <%-- 2. using <form:form> --%>
                                <%-- 3. using Thymeleaf --%>
                                <%-- 4. below--%>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                <div class="form-group">
                                    <div class="input-group margin-bottom-sm">
                                        <span class="input-group-addon"><i class="fa fa-user-o fa-fw"></i></span>
                                        <input type="text" class="form-control" name="username"
                                               placeholder="Tên đăng nhập">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
                                        <input type="password" class="form-control" name="password"
                                               placeholder="Mật khẩu">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <input id="check" type="checkbox" class="check" name="remember-me" checked>
                                    <label for="check"><span class="icon"></span> Duy trì đăng nhập</label>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-submit">Đăng nhập</button>
                                </div>
                                <div class="form-group">
                                    <div class="social-btn flex-center">
                                        <span class="pull-left other-method-login">Đăng nhập với&#160;&#160;&#160;</span>
                                        <span class="pull-right">
                                                <a href="/auth/facebook" class="fa fa-facebook"></a>
                                                <a href="#" class="fa fa-twitter"></a>
                                                <a href="#" class="fa fa-google"></a>
                                                <a href="#" class="fa fa-linkedin"></a>
                                            </span>
                                    </div>
                                </div>
                                <%--<a href="/auth/facebook" style="display: block" class="btn">--%>
                                <%--<i class="fa fa-facebook-official" style="font-size: 20px;"> Login with facebook</i>--%>
                                <%--</a>--%>
                                <div class="form-group">
                                    <span class="pull-right">
                                        <a href="/signup">Đăng ký</a> |
                                        <a href="#">Quên mật khẩu?</a>
                                    </span>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="main-footer">
        <c:import url="main_footer.jsp"/>
    </div>
</div>
</body>
</html>
