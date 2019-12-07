<%-- 
    Document   : createUser
    Created on : 2 déc. 2019, 19:39:36
    Author     : Pierre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>User registration</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>Sign Up</div>
        <form action="/register?session=${session}" method="post">
            First Name:<br>
            <input type="text" name="firstname" >
            <br>
            Last name:<br>
            <input type="text" name="lastname" >
            <br>
            Address:<br>
            <input type="text" name="address" >
            <br>
            Phone Number:<br>
            <input type="tel" name="phonenumber" pattern="0[0-9]{9}">
            <br>
            Email:<br>
            <input type="email" name="mail">
            <br><br>
            <input type="hidden" name="session" value=${session}>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
