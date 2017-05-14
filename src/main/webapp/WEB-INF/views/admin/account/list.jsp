<%--
  Created by IntelliJ IDEA.
  User: Khanh Nguyen
  Date: 13/5/2017
  Time: 7:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <title>CoverLip - Admin Page</title>
    <%@ include file="../common/head.jsp"%>
    <script>
        $(function() {
            $("#success-msg").delay(2000).slideUp(1000);
        });
    </script>
</head>
<body>

<%@ include file="../common/topAndLeft.jsp"%>

<div id="main-content">
    <div class="center-content">
        <div class="user-detail">
            <div class="list shadow-all">
                <div id="creator-subheader">
                    <div class="creator-subheader-content">
                        <h2>Danh sách tài khoản</h2>
                        <span id="creator-subheader-item-count" class="badge-creator">100</span>
                    </div>
                    <div class="creator-subheader-controls">
                        <form action="" method="GET">
                            <div class="input-group">
                                <input id="search-text" type="text"
                                       class="form-control clear-border-radius" name="q"
                                       placeholder="Search...">
                                <div class="input-group-btn">
                                    <button class="btn btn-default clear-border-radius"
                                            type="submit">
                                        <i class="glyphicon glyphicon-search"></i>
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="clear"></div>
                <hr>
                <div>
                    <div class="pull-right">
                        <a href="#"
                           class="btn btn-success"> <span
                                class="glyphicon glyphicon-plus"></span> Thêm tài khoản mới
                        </a>
                    </div>
                    <div class="pull-left">
                        <c:if test="${not empty success}">
                            <div class="alert alert-success alert-dismissable"
                                 id="success-msg">
                                <a href="#" class="close" data-dismiss="alert"
                                   aria-label="close">&times;</a> <strong>Success!</strong>
                                    ${success}
                            </div>
                        </c:if>
                    </div>
                </div>
                <table class="table table-hover tablesorter" id="myTable">
                    <thead>
                    <tr>
                        <!--
                            <th><input type="checkbox" name="select-all" value="">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default select-action">Action</button>
                                    <button type="button"
                                        class="btn btn-default dropdown-toggle caret-action"
                                        data-toggle="dropdown">
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Delete</a></li>
                                        <li><a href="#">More</a></li>
                                    </ul>
                                </div></th>-->
                        <th>#</th>
                        <th>Email</th>
                        <th>Tên</th>
                        <th>Số điện thoại</th>
                        <th>Địa chỉ</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!--<tr class="filters">-->
                    <!--<th><input type="text" class="form-control" placeholder="Action" disabled></th>-->
                    <!--<th><input type="text" class="form-control" placeholder="#" ></th>-->
                    <!--<th><input type="text" class="form-control" placeholder="Picture" disabled></th>-->
                    <!--<th><input type="text" class="form-control" placeholder="Firstname"></th>-->
                    <!--<th><input type="text" class="form-control" placeholder="Lastname" ></th>-->
                    <!--<th><input type="text" class="form-control" placeholder="Email" ></th>-->
                    <!--<th><input type="text" class="form-control" placeholder="Address"></th>-->

                    <c:if test="${empty requestScope.accountList}">
                        <h3>Danh sách tài khoản rỗng</h3>
                    </c:if>
                    <c:if test="${not empty requestScope.accountList}">
                        <c:set var="count" value="0" scope="page" />
                        <c:forEach items="${requestScope.accountList}" var="account">
                            <tr>
                                <!--
                                <td><input type="checkbox" name="selected[]" value="">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default select-action">Action</button>
                                        <button type="button"
                                            class="btn btn-default dropdown-toggle caret-action"
                                            data-toggle="dropdown">
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu" role="menu">
                                            <li><a href="javascript:void(0)">Delete</a></li>
                                            <li><a href="user-detail.html">View Detail</a></li>
                                        </ul>
                                    </div></td>-->
                                <c:set var="count" value="${count + 1}" scope="page" />
                                <td>${count}</td>
                                <td>${account.email}</td>
                                <td>${account.name}</td>
                                <td>${account.phoneNumber}</td>
                                <td>${account.address}</td>
                                <td><a href="<c:url value="/admin/account/${account.accountId}/edit"/>"><span class="glyphicon glyphicon-pencil"></span></a></td>
                                <td><a href="<c:url value="/admin/account/${account.accountId}/delete"/>"><span class="glyphicon glyphicon-trash"></span></a></td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
                <div>
                    <ul class="pagination pull-right">
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li class="disabled"><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <!--<div style=" background-color: #1abb9c; height: 500px; margin: 20px;">-->

    <!--</div>-->

</div>

<%@ include file="../common/footer.jsp"%>

</body>
</html>
