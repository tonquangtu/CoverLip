<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 22-May-17
  Time: 8:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page session="false" %>

<div class="information_person main_person">
    <div class="subhead">
        <h2 class="subhead-heading">Thông Tin Công Khai</h2>
    </div>
    <form accept-charset="UTF-8" action="./upload?${_csrf.parameterName}=${_csrf.token}" class="form_person" method="POST" enctype="multipart/form-data">



        <div class="col-md-12">
            <dl class="form-group">
                <dt><label>Tiêu Đề</label></dt>
                <dd><input class="form-control" id="title_cover" size="30"
                           value="" type="text" name="title"></dd>
            </dl>

            <dl class="form-group">
                <dt><label for="description">Mô tả </label></dt>
                <dd class="">
                                <textarea
                                        class="form-control"
                                        cols="20" id="description"
                                        name="description" placeholder="Hãy nói một chút về video!"
                                        rows="7"></textarea>
                </dd>
            </dl>
            <dl class="form-group">
                <dt>
                    <label for="choose_video">Chọn File</label>
                </dt>
                <dd>
                    <input type="file" name="file" id="choose_video">
                </dd>
            </dl>
            <input type="hidden" value="${userInfo.account.id}" name="accountId">
            <p>
                <button type="submit" class="btn btn-success" id="submit">Upload</button>
            </p>
        </div>
        <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">--%>
    </form>
</div>

<c:if test="${not empty message}">
    <c:choose>
        <c:when test="${message eq 'success'}">
            <script >
                alert("Upload thành công, video của bạn đang được admin kiểm duyệt");
            </script>
        </c:when>

        <c:otherwise>
            <script >
                alert("Có lỗi xảy ra trong khi upload: " + "${message}");
            </script>
        </c:otherwise>
    </c:choose>
</c:if>

