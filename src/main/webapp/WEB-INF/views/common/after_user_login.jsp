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
<%@ page import="com.clteam.security.util.AccountUtil" %>
<%@ page import="com.clteam.security.model.CustomUser" %>
<html>
<head>
    <title>Title</title>
</head>
<h1>After normal user login</h1>
<h1>Id of user is: <%= AccountUtil.getCurrentUserId() %></h1>
<%--<h1>Date join: <%= ((CustomUser) AccountUtil.getCurrentUserDetails()).getAccountEntity().getDateJoin() %></h1>--%>
<sec:authorize access="isAuthenticated()">
    <h2><sec:authentication property="principal.accountEntity.username"/></h2>
    <h2><sec:authentication property="principal.accountEntity.dateJoin"/></h2>
    <h2><sec:authentication property="principal.accountEntity.fullname"/></h2>
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


<form action="<c:url value="/logout"/>" method="POST" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />
    <button type="submit">Logout</button>
</form>


<%--<c:if test="${not empty sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}">--%>
<%--<h1>${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}</h1>--%>
<%--</c:if>--%>
</body>
</html>