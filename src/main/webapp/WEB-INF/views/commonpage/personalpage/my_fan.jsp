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
<div class="my_fan main_person">
    <div class="subhead">
        <h2 class="subhead-heading">Fan Của Tôi</h2>
    </div>
    <div style="padding-right:0; padding-left:0; margin-top: 45px">
        <!-- Main-->
        <c:forEach items="${fanList}" var="item1" varStatus="i">
            <c:if test="${i.index<9}">
                <c:if test="${i.index%3==0}">
                    <div class="row">
                </c:if>
                <div class="col-md-4 one_member text-center">
                    <a href="">
                        <div class="avatar">
                            <img src="${item1.account.avatarThumbnail}"
                                 alt="${item1.account.fullname}"
                                 class="img-responsive img-circle">
                        </div>
                        <div class="name_of_member">
                            <p>${item1.account.fullname}</p>
                        </div>
                    </a>
                </div>
                <c:if test="${i.index%3==2||idolList.size()-1==i.index}">
                    </div>
                </c:if>
            </c:if>
        </c:forEach>
        <div id="addItem"></div>
    </div>
    <div id="loading" currentItemId="${(fanList!=null&&fanList.size()>0)?fanList.get(fanList.size()-1).account.id:0}" type="${type}" accountid="${userInfo.account.id}">
        <span><img class="loadicon" src="../../../resources/icons/loadding.svg" style="width:50px"></span>
        <span>Đang tải dữ liệu...</span>
    </div>
</div>
