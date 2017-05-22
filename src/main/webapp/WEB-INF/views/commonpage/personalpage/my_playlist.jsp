<%--
  Created by IntelliJ IDEA.
  User: nguyenthanhtung
  Date: 19/05/2017
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="my_playlist">
    <div class="subhead main_person">
        <h2 class="subhead-heading">Playlist Của Tôi</h2>
    </div>
    <div style="padding-right:0; padding-left:0;">
        <!-- Main-->
        <c:forEach var="item" items="${playlistList}" varStatus="i" end="2">
            <c:if test="${i.index%3==0}">
                <div class="row" style="margin-left:0; margin-right: -20px;">
            </c:if>
            <div class="col-md-4" style="padding-right:20px; padding-left:0">
                <c:set var="item" value="${item}" scope="request"/>
                <%@include file="../../common/playlist_card.jsp" %>
            </div>
            <c:if test="${i.index%3==2||(i.index==videoList.size()-1)}">
                </div>
            </c:if>
        </c:forEach>
        <div id="addItem"></div>
    </div>
    <div id="loading" currentplaylistid="${(playlistList!=null&&playlistList.size()>0)?playlistList.get(playlistList.size()-1).id:0}" type="${type}" accountid="${userInfo.account.id}">
        <span><img class="loadicon" src="../../../resources/icons/loadding.svg" style="width:50px"></span>
        <span>Đang tải dữ liệu...</span>
    </div>
</div>