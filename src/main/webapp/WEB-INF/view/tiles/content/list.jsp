<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<h2><spring:message code="documentation" /></h2>
<ul>
    <c:forEach var="resources" items="${resourcesList}">
        <li>
            ${resources.base}
            <ul>
                <c:forEach var="resource" items="${resources.resource}">
                    <li>
                        <c:url value="detail" var="detailUrl">
                            <c:param name="path" value="${resource.path}" />
                        </c:url>
                        <a href="${detailUrl}">${resource.path}</a>
                    </li>
                </c:forEach>
            </ul>
        </li>
    </c:forEach>
</ul>
