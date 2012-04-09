<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<ul>
    <c:url value="/" var="homeUrl" />
    <li><a href="${homeUrl}"><spring:message code="home" /></a></li>

    <c:url value="list" var="listUrl" />
    <li><a href="${listUrl}"><spring:message code="documentation" /></a></li>
</ul>