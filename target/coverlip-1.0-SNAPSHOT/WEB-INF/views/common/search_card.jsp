<%--
  Created by IntelliJ IDEA.
  User: nguyenthanhtung
  Date: 23/05/2017
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="divSuggestion" class="suggestion hideShowCase" m="0">
    <div class="search-suggestion-box">
        <div class="slimScrollDiv">
            <div id="idScrollSuggestion" style="overflow: hidden; width: auto; max-height: 450px;">
                <ul id="contentSuggestion" class="content_search" style="text-transform:capitalize;">
                    <li id="liTopKeyWordFirst">
                        <h3 class="title_row">Top từ khóa tìm kiếm nhiều nhất</h3>
                        <ul id="ulTopKeyWord" class="info-search">
                            <%--Data--%>
                            <div id="loading_search" style="text-align: center;margin-top: 20px;margin-bottom: 20px;">
                                <span><img class="loadicon" src="../../../resources/icons/loadding.svg"
                                           style="width:50px"></span>
                                <span>Đang tải dữ liệu...</span>
                            </div>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="slimScrollBar"
                 style="background: rgb(0, 0, 0) none repeat scroll 0% 0%; width: 7px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 312px;"></div>
            <div class="slimScrollRail"
                 style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: rgb(51, 51, 51) none repeat scroll 0% 0%; opacity: 0.2; z-index: 90; right: 1px;"></div>
        </div>
    </div>
</div>
