<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %><%--
  Created by IntelliJ IDEA.
  User: Khanh Nguyen
  Date: 11/5/2017
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<sec:authorize access="isAuthenticated()">
    <h2><sec:authentication property="principal.username"/></h2>
</sec:authorize>
<c:choose>
    <c:when test="${not empty sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}}">
        <h1>${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}</h1>
    </c:when>
    <%--<c:when test="${}">--%>
        <%----%>
    <%--</c:when>--%>
    <c:otherwise>
        <h1>username is empty</h1>
    </c:otherwise>
</c:choose>
<%--<c:if test="${not empty sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}">--%>
    <%--<h1>${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}</h1>--%>
<%--</c:if>--%>
</body>
</html>
