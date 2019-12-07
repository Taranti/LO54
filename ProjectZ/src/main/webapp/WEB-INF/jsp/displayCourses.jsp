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
        <%@ page import="com.potatocorp.projectz.controller.CourseSessionController" %>
        <h1>Liste des formations</h1>
        
        <table>
            <thead>
                <td>
                    Title
                </td>
                <td>
                    Location
                </td>
                <td>
                    Start Date
                </td>
                <td>
                    End Date
                </td>
                <td>
                    Participants 
                </td>
                <td>
                    Register 
                </td>
            </thead>
            <tbody>
                <c:forEach var="session" items="${sessions}">
                    <tr>
                        <td>
                            ${session.getCourse().getTitle()}
                        </td>
                        <td>
                            ${session.getLocation().getCity()}
                        </td>
                        <td>
                            ${session.getStartDate()}
                        </td>
                        <td>
                            ${session.getEndDate()}
                        </td>
                        <td>
                            ${CourseSessionController.getNbParticipants(session)}/${session.getMax()}
                        </td>
                        <td>
                            <c:if test="${CourseSessionController.getNbParticipants(session)<session.getMax()}">
                                <a href="/register?session=${session.getId()}"> Register</a>
                            </c:if>
                        </td>
                    </tr>
            </c:forEach>
            </tbody>
            
        </table>
    </body>
</html>
