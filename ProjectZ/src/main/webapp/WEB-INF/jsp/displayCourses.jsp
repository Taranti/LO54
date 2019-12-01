<%-- 
    Document   : displayCourses
    Created on : 30 nov. 2019, 18:37:59
    Author     : Pierre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <h1>Liste des formations</h1>
        <ul>
            <c:forEach var="session" items="${sessions}">
                    <li>${session.toString()} </li>
            </c:forEach>
        </ul>
    </body>
</html>
