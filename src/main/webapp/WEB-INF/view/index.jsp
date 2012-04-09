<%@ page contentType="text/html; charset=utf-8" %>
<%@ page session="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="cs">
    <head>
        <meta charset="UTF-8">
        <title><spring:message code="title" /></title>
    </head>
    <body>
        <header>
            <tiles:insertAttribute name="header" />
        </header>
        <nav>
            <tiles:insertAttribute name="navigation" />
        </nav>
        <section>
            <tiles:insertAttribute name="feedback" />
            <tiles:insertAttribute name="content" />
        </section>
        <footer>
            <tiles:insertAttribute name="footer" />
        </footer>
    </body>
</html>