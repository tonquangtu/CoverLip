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
                        <a href="/account/${item1.user.account.id}"><strong>${item1.user.account.fullname}</strong></a>
                        <p><span>${item1.user.numHaveFollowed}</span> người theo dõi</p>
                    </div>

                    <c:choose>
                        <c:when test="${idolList == null || idolList.size() == 0}">
                            <button type="button" class="btn-follow btn btn-success btn-sm hvr-buzz-out"
                                    topIdolId = "${item1.user.account.id}"
                                    statusFollow = "0">
                                Theo dõi</button>

                        </c:when>
                        <c:otherwise>
                            <c:set var="checkFollow" value="false"/>
                            <c:forEach items="${idolList}" var="itemFollow" varStatus="j">
                                <c:if test="${item1.user.account.id == itemFollow.account.id}">
                                    <c:set var="j.index" value="${idolList.size() + 1}"/>
                                    <c:set var="checkFollow" value="true"/>
                                    <button type="button" class="btn-follow btn btn-success btn-sm hvr-buzz-out"
                                            style="background-color: #ffffff; border-color: #4cae4c; color: #4cae4c;"
                                            topIdolId = "${item1.user.account.id}"
                                            statusFollow = "1">
                                        Đã theo dõi</button>
                                </c:if>
                            </c:forEach>
                            <c:if test="${checkFollow == 'false'}">
                                <button type="button" class="btn-follow btn btn-success btn-sm hvr-buzz-out"
                                        topIdolId = "${item1.user.account.id}"
                                        statusFollow = "0">
                                    Theo dõi</button>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
