<%--
  Created by IntelliJ IDEA.
  User: Khanh Nguyen
  Date: 13/5/2017
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ include file="common_lib.jsp" %>
    <link rel="stylesheet" href="/resources/styles/main_header_style.css">
    <link rel="stylesheet" href="/resources/styles/main_navigation_style.css">
    <link rel="stylesheet" href="/resources/styles/main_footer_style.css">
    <link rel="stylesheet" href="/resources/styles/login.css">
    <link rel="stylesheet" href="/resources/styles/admin/common.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pwstrength-bootstrap/2.0.8/pwstrength-bootstrap.min.js"></script>
    <link rel="stylesheet" href="/resources/styles/signup.css">
</head>
<body>
<div class="wrapper">
    <div class="main-header">
        <%@ include file="main_header.jsp" %>
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6 col-md-offset-3 text-center sign-up-shadow sign-up">
                    <h4 class="sign-up-title">Đăng ký tài khoản</h4>
                    <div class="account-info">
                        <c:url value="/signup" var="formUrl" />
                        <form:form action="${formUrl}" method="POST"
                                   modelAttribute="accountForm" class="form-horizontal">
                            <spring:bind path="email">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="control-label col-sm-4"
                                           for="email">Email</label>
                                    <div class="col-sm-6">
                                        <form:input path="email" type="text" class="form-control"
                                                    id="email" placeholder="Email" />
                                        <form:errors path="email" class="control-label" />
                                    </div>
                                </div>
                            </spring:bind>
                            <div class="form-group">
                                <label class="control-label col-sm-4" for="name">Tên</label>
                                <div class="col-sm-6">
                                    <form:input path="fullName" type="text" class="form-control"
                                                id="name" placeholder="Name" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-4"
                                       for="address">Địa chỉ</label>
                                <div class="col-sm-6">
                                    <form:input path="address" type="text" class="form-control"
                                                id="address" placeholder="Address" />
                                </div>
                            </div>
                            <c:set var="pwdHasBindError">
                                <form:errors path="password" />
                            </c:set>
                            <div
                                    class="form-group ${not empty pwdHasBindError ? 'has-error' : '' }">
                                <label class="control-label col-sm-4" for="pwd">Mật
                                    khẩu</label>
                                <div class="col-sm-6">
                                    <form:input path="password" type="password"
                                                class="form-control" id="pwd" placeholder="Password" />
                                    <form:errors path="password" class="control-label" />
                                </div>
                            </div>
                            <spring:bind path="confirmPassword">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="control-label col-sm-4"
                                           for="confirmPassword">Xác nhận mật khẩu</label>
                                    <div class="col-sm-6">
                                        <form:input path="confirmPassword" type="password"
                                                    class="form-control" id="confirmPassword"
                                                    placeholder="Confirm password" />
                                        <form:errors path="confirmPassword" class="control-label" />
                                    </div>
                                </div>
                            </spring:bind>
                            <div class="form-group">
                                <div>
                                    <button type="submit" class="btn btn-success sign-up-submit">Gủi đăng ký</button>
                                </div>
                            </div>
                        </form:form>
                    </div>

            </div>
        </div>
    </div>
    <div class="main-footer">
        <%@ include file="main_footer.jsp" %>
    </div>
</div>
</body>
</html>