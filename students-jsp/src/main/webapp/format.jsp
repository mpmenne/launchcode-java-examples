<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://exigen.ru/students/tags" prefix="util" %>

<c:set var="language" value="${not empty param.language ? param.language : 'en'}"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="messages"/>

<html>
    <head>
        <title><fmt:message key="page.title"/></title>
    </head>

    <body>
        <h2><fmt:message key="page.title"/></h2>
    </body>
</html>