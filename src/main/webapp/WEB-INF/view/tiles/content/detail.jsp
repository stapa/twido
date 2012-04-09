<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<h2><spring:message code="detail" /></h2>

<h3>${resource.path}</h3>

<h4><spring:message code="parameters" /></h4>
<ul>
    <c:forEach var="paramOrChoice" items="${resource.paramOrChoice}">
        <c:choose>
            <c:when test="${paramOrChoice.class.simpleName == 'Param'}">
                <!--param-->
                <li>${paramOrChoice.name}</li>
            </c:when>
            <c:otherwise>
                <!--choice-->
                <c:forEach var="parameter" items="${paramOrChoice.param}">
                    <li>${parameter.name}</li>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</ul>

<h4><spring:message code="methods" /></h4>
<ul>
    <c:forEach var="method" items="${resource.methodOrResource}">
        <li>${method.name}</li>
    </c:forEach>
</ul>
