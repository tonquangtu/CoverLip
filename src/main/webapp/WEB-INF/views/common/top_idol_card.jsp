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
        <c:choose>
            <c:when test="${targetPage== 'cover_home_page'}">
                <h3 id="title_top_cover_idol">TOP COVER IDOL</h3>
            </c:when>
            <c:otherwise>
                <h3 id="title_top_cover_idol">TOP LIP SYNC IDOL</h3>
            </c:otherwise>
        </c:choose>

        <ul>
            <c:forEach items="${listHot}" var="item1" varStatus="i">
                <li class="item_top_cover_idol">
                    <img src="${item1.user.account.avatarThumbnail}" class="img-circle hvr-pulse-grow" alt="top cover idol">
                    <div class="idol_info">
                        <a href="/user/${item1.user.account.id}"><strong>${item1.user.account.fullname}</strong></a>
                        <p>${item1.user.numHaveFollowed} người theo dõi</p>
                    </div>
                    <button type="button" class="btn-follow btn btn-success btn-sm hvr-buzz-out">Theo dõi</button>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
