<%--
  Created by IntelliJ IDEA.
  User: Khanh Nguyen
  Date: 13/5/2017
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
                                         pageEncoding="UTF-8" %>
<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"--%>
         <%--pageEncoding="ISO-8859-1"%>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="vi">
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ include file="common_lib.jsp" %>
    <link rel="stylesheet" href="/resources/styles/main_header_style.css">
    <link rel="stylesheet" href="/resources/styles/main_navigation_style.css">
    <link rel="stylesheet" href="/resources/styles/main_footer_style.css">
    <link rel="stylesheet" href="/resources/styles/login.css">
    <link rel="stylesheet" href="/resources/styles/admin/common.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pwstrength-bootstrap/2.0.8/pwstrength-bootstrap.min.js"></script>
    <link rel="stylesheet" href="/resources/styles/signup.css">
    <!-- Bootstrap date picker plugin-->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.min.css">
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/locales/bootstrap-datepicker.vi.min.js"></script>
</head>
<body>
<div class="wrapper">
    <div class="main-header">
        <%@ include file="main_header.jsp" %>
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6 col-md-offset-3 sign-up-shadow sign-up">
                <h4 class="sign-up-title text-center">Đăng ký tài khoản</h4>
                <div class="account-info">
                    <c:url value="/signup" var="formUrl"/>
                    <form:form action="${formUrl}" method="POST"
                               modelAttribute="accountForm" class="form-horizontal">
                        <spring:bind path="email">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <label class="control-label col-sm-4"
                                       for="email">Email</label>
                                <div class="col-sm-6">
                                    <form:input path="email" type="text" class="form-control"
                                                id="email" placeholder="Email"/>
                                    <form:errors path="email" class="control-label"/>
                                </div>
                            </div>
                        </spring:bind>
                        <spring:bind path="fullName">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <label class="control-label col-sm-4" for="name">Tên</label>
                                <div class="col-sm-6">
                                    <form:input path="fullName" type="text" class="form-control"
                                                id="name" placeholder="Name"/>
                                    <form:errors path="fullName" class="control-label"/>
                                </div>
                            </div>
                        </spring:bind>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="name">Ngày sinh</label>
                            <div class="col-sm-6">
                                <%--<form:input path="dateOfBirth" type="text" class="form-control"--%>
                                            <%--id="dateOfBirth" placeholder="Date of birth"/>--%>

                                <form:input path="dateOfBirth" id="select-date"
                                       placeholder="Date of birth"
                                       class="form-control date-readonly" value="" readonly="true"
                                       type="text" data-provide="datepicker"
                                       data-date-format="dd/mm/yyyy" style="cursor: pointer; background-color: #eee"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4"
                                   for="address">Địa chỉ</label>
                            <div class="col-sm-6">
                                <form:input path="address" type="text" class="form-control"
                                            id="address" placeholder="Address"/>
                            </div>
                        </div>
                        <c:set var="pwdHasBindError">
                            <form:errors path="password"/>
                        </c:set>
                        <div
                                class="form-group ${not empty pwdHasBindError ? 'has-error' : '' }">
                            <label class="control-label col-sm-4" for="password">Mật
                                khẩu</label>
                            <div class="col-sm-6">
                                <form:input path="password" type="password"
                                            class="form-control" id="password" placeholder="Password"/>
                                <form:errors path="password" class="control-label"/>
                            </div>
                        </div>
                        <spring:bind path="confirmPassword">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <label class="control-label col-sm-4"
                                       for="confirmPassword">Xác nhận mật khẩu</label>
                                <div class="col-sm-6">
                                    <form:input path="confirmPassword" type="password"
                                                class="form-control" id="confirmPassword"
                                                placeholder="Confirm password"/>
                                    <form:errors path="confirmPassword" class="control-label"/>
                                    <span id="globalError" style="color: #d52929"></span>
                                </div>
                            </div>
                        </spring:bind>
                        <div class="form-group text-center">
                            <div>
                                <button type="submit" class="btn btn-success sign-up-submit">Gửi đăng ký</button>
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
    <script>
        var serverContext = "<spring:message code="server.path"/>";
        var passwordMatches = "<spring:message code="PasswordMatches.user"/>";
        var wordLength = "<spring:message code="error.wordLength"/>";
        var wordNotEmail = "<spring:message code="error.wordNotEmail"/>"
        var wordSequences = "<spring:message code="error.wordSequences"/>";
        var wordLowercase = "<spring:message code="error.wordLowercase"/>";
        var wordUppercase = "<spring:message code="error.wordUppercase"/>";
        var wordOneNumber = "<spring:message code="error.wordOneNumber"/>";
        var wordOneSpecialChar = "<spring:message code="error.wordOneSpecialChar"/>";

        $(document).ready(function () {
//            $('form').submit(function (event) {
//                register(event);
//            });

            $(":password").keyup(function () {
                if ($("#password").val() != $("#confirmPassword").val()) {
                    $("#globalError").show().html(passwordMatches);
                } else {
                    $("#globalError").html("").hide();
                }
            });

            options = {
                common: {minChar: 8},
                ui: {
                    showVerdictsInsideProgressBar: true,
                    showErrors: true,
                    errorMessages: {
                        wordLength: wordLength,
                        wordNotEmail: wordNotEmail,
                        wordSequences: wordSequences,
                        wordLowercase: wordLowercase,
                        wordUppercase: wordUppercase,
                        wordOneNumber: wordOneNumber,
                        wordOneSpecialChar: wordOneSpecialChar
                    }
                }
            };
            $('#password').pwstrength(options);
        });

        function register(event) {
            event.preventDefault();
            $(".alert").html("").hide();
            $(".error-list").html("");
            if ($("#password").val() != $("#confirmPassword").val()) {
                $("#globalError").show().html(passwordMatches);
                return;
            }
            var formData = $('form').serialize();
            $.post(serverContext + "/signup", formData, function (data) {
                if (data.message == "success") {
                    window.location.href = serverContext + "/success";
                }

            })
                .fail(function (data) {
                    if (data.responseJSON.error.indexOf("MailError") > -1) {
                        window.location.href = serverContext + "emailError.html";
                    }
                    else if (data.responseJSON.error == "UserAlreadyExist") {
                        $("#emailError").show().html(data.responseJSON.message);
                    }
                    else if (data.responseJSON.error.indexOf("InternalError") > -1) {
                        window.location.href = serverContext + "login?message=" + data.responseJSON.message;
                    }
                    else {
                        var errors = $.parseJSON(data.responseJSON.message);
                        $.each(errors, function (index, item) {
                            $("#" + item.field + "Error").show().html(item.defaultMessage);
                        });
                        errors = $.parseJSON(data.responseJSON.error);
                        $.each(errors, function (index, item) {
                            $("#globalError").show().append(item.defaultMessage + "<br/>");
                        });
                    }
                });
        }

        $(function () {
            $('#select-date').datepicker();
        });
    </script>
</div>
</body>
</html>