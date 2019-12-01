<%-- 
    Document   : displayFilteredCourses
    Created on : 1 déc. 2019, 11:53:04
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
        <h1>Filtered Sessions</h1>
         <ul>
            <c:forEach var="session" items="${filteredSessions}">
                    <li>
                        ${session.toString()}
                        <a href="/register?session=${session.getId()}"> Register</a>
                    </li>
            </c:forEach>
        </ul>
    </body>
</html>
