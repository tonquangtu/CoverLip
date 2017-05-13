<%--
  Created by IntelliJ IDEA.
  User: nguyenthanhtung
  Date: 03/05/2017
  Time: 08:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="top_idol">
    <div id="top_cover_idol">
        <h3 id="title_top_cover_idol">TOP COVER IDOL</h3>
        <ul>
            <c:forEach items="${listHot}" var="item" varStatus="i">
                <li class="item_top_cover_idol">
                    <img src="${item.user.avatarThumbnail}" class="img-circle" alt="top cover idol">
                    <div class="idol_info">
                        <p><strong>${item.user.account.fullname}</strong></p>
                        <p>${item.user.numHaveFollowed} người theo dõi</p>
                    </div>
                    <button type="button" class="btn btn-success btn-sm">Theo dõi</button>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>