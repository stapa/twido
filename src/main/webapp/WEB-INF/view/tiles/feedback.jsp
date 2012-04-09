<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${!empty errors}">
    <ul>
        <c:forEach var="error" items="${errors}">
            <li>${error}</li>
        </c:forEach>
    </ul>
</c:if>
