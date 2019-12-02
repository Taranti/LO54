<%-- 
    Document   : filterCourses
    Created on : 30 nov. 2019, 10:53:04
    Author     : pneau
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
        <h1>Filtrer les formations</h1>
        <form action="/filter" method="post">
            <input type="text" name="keyword">
            <input type="date" name="date" min=${today}>
            <select name="location">
                <option value=""> -- PLease choose a location</option>
                <c:forEach var="location" items="${locationList}">
                    <option value=${location.getId()} >${location.getCity()} </option>
                    
                </c:forEach>
            </select>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
